package com.kaishengit.tms.api;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.system.service.SynthesizeLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统管理控制器
 */
@Controller
public class HomeController {

    @Autowired
    private SynthesizeLoginService synthesizeLoginService;

    @GetMapping("/")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            //登录认证
            //认为用户要切换账户
            subject.logout();
        }
        if (!subject.isAuthenticated() && subject.isRemembered()) {
            //被记住的账户直接去登录成功页面
            return "redirect:/home";
        }
        return "index";
    }

    @PostMapping("/")
    public String login(String accountMobile, String accountPassword, boolean rememberMe,
                        RedirectAttributes redirectAttributes, HttpServletRequest request) {

        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(accountMobile,accountPassword,rememberMe);
            subject.login(usernamePasswordToken);
            //跳转到登录前访问的url
            String url = "/home";
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            if (savedRequest != null) {
                //获取登录前访问的url
                url = savedRequest.getRequestUrl();
            }

            subject.checkRole("管理员");
            //登录成功，纪录日志
            String ip = request.getRemoteAddr();
            Account account = (Account) subject.getPrincipal();
            synthesizeLoginService.saveLoginInfo(ip,account.getId());
            return "redirect:" + url;
        } catch (AuthenticationException ex) {
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
            return "redirect:/";
        } catch (UnauthorizedException ex) {
            redirectAttributes.addFlashAttribute("message","对不起，您暂无权限访问综合管理系统");
            return "redirect:/";
        }
    }

    /**
     * 退出功能
     * @return
     */
    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message","您已安全退出系统");
        return "redirect:/";
    }

    /**
     * 去登录后的页面
     * @return
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
