package com.kaishengit.controller;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhangyu on 2017/11/20.
 */
@Controller
public class HomeController {


    @GetMapping("/upload")
    public String uploadFile() {
        //1.鉴权 上传文件的凭证  Access Key 和 Secret Key
        String accessKey = "I4JRF0gtqdZ76hQbmdMUsFCgAdjOVtohnQIDqwOY";
        String secretKey = "zZTd3DnwiKiMJeE66-t97czrfEUYv6GgooPY_PcY";
        String bucket = "myphoto";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);



        return "upload";
    }

}
