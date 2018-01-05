package com.kaishengit.tms.api;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.kaishengit.tms.api.exception.NotFoundException;
import com.kaishengit.tms.entity.Scenic;
import com.kaishengit.tms.entity.ScenicAccount;
import com.kaishengit.tms.service.ScenicService;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;


/**
 * 基本信息管理控制器
 */
@Controller
public class ScenicInfoController {

    @Autowired
    private ScenicService scenicService;

    private String qiniuAk = "I4JRF0gtqdZ76hQbmdMUsFCgAdjOVtohnQIDqwOY";
    private String qiniuSk = "zZTd3DnwiKiMJeE66-t97czrfEUYv6GgooPY_PcY";
    private String qiniuBuket = "crm2017";


    /**
     * 获取景区信息
     * @return
     */
    @GetMapping("/scenic/info")
    public String getScenicInfo(Model model) {
        PageInfo<Scenic> scenicPageInfo = scenicService.findAll();
        model.addAttribute("page",scenicPageInfo);
        return "scenicInfo/info-scenic";
    }

    /**
     * 根据id查找对应景区信息
     * @param id
     * @return
     */
    @GetMapping("/scenic/{id:\\d+}")
    public String showScenicDetail(@PathVariable Integer id,Model model) {
        Scenic scenic = scenicService.findScenicById(id);
        model.addAttribute("scenic",scenic);
        model.addAttribute("scenicAccount",scenicService.findScenicAccountByScenicId(id));
        return "scenicInfo/info-scenic-detail";
    }

    /**
     * 添加景区
     * @return
     */
    @GetMapping("/scenic/new")
    public String newScenic() {
        return "scenicInfo/info-scenic-new";
    }
    @PostMapping("/scenic/new")
    public String newScenic(Scenic scenic, MultipartFile pic,RedirectAttributes redirectAttributes) {
        Integer scenicId = null;
        try {
            String key = uploadFileToQiNiu(pic);
            scenic.setScenicAttachment(key);
            scenicId = scenicService.newScenic(scenic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message","您已成功添加该景区,<a href =\"/scenic/account/new/" + scenicId + "\">点击添加该景区账号！</ a>");
        return "redirect:/scenic/" + scenicId;
    }

    //上传图片到七牛云
    private String uploadFileToQiNiu(MultipartFile pic) throws IOException {
        //使用InputStream
        InputStream inputStream = pic.getInputStream();
        //上传文件到七牛云
        Configuration configuration = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(configuration);
        Auth auth = Auth.create(qiniuAk,qiniuSk);
        String uploadToken = auth.uploadToken(qiniuBuket);
        String key = null;
        try {
            Response response = uploadManager.put(IOUtils.toByteArray(inputStream),null,uploadToken);
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            key = defaultPutRet.key;
        } catch (IOException e) {
            throw new RuntimeException("上传文件到七牛云异常",e);
        }
        return key;
    }

    /**
     * 根据id修改景区
     * @param id
     * @return
     */
    @GetMapping("/scenic/edit/{id:\\d+}")
    public String editScenic(@PathVariable Integer id,Model model) {
        model.addAttribute("scenic",scenicService.findScenicById(id));
        return "scenicInfo/info-scenic-edit";
    }
    @PostMapping("/scenic/edit/{id:\\d+}")
    public String editScenic(@PathVariable Integer id,Scenic scenic) {
        scenicService.editScenic(id,scenic);
        return "redirect:/scenic/" + id;
    }

    /**
     * 根据景区id删除景区
     * @param id
     * @return
     */
    @GetMapping("/scenic/delete/{id:\\d+}")
    public String delScenic(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        scenicService.deleteScenicById(id);
        redirectAttributes.addFlashAttribute("message","您已成功删除该景区!");
        return "redirect:/scenic/info";
    }

    /**
     * 添加景区账号
     * @return
     */
    @GetMapping("/scenic/account/new/{scenicId:\\d+}")
    public String addScenicAccount(@PathVariable Integer scenicId,Model model) {
        ScenicAccount scenicAccount = scenicService.findScenicAccountByScenicId(scenicId);
        Scenic scenic = scenicService.findScenicById(scenicId);
        if (scenic == null) {
            throw new NotFoundException("该景区找不到......");
        }
        if (scenicAccount != null) {
            model.addAttribute("scenicAccount",scenicAccount);
        } else {
            model.addAttribute("message","请添加景区账户");
        }
        model.addAttribute("scenicId",scenicId);
        return "scenicInfo/info-scenic-new-account";
    }

    @PostMapping("/scenic/account/new/{scenicId:\\d+}")
    public String addScenicAccount(@PathVariable Integer scenicId, ScenicAccount scenicAccount,
                                   RedirectAttributes attributes) {
        scenicService.addScenicAccount(scenicAccount,scenicId);
        attributes.addFlashAttribute("scenicAccount",scenicService.findScenicAccountByScenicId(scenicId));
        attributes.addFlashAttribute("message","您已成功添加该景区账号");
        return "redirect:/scenic/" +  scenicId;
    }









}
