package com.kaishengit.controller;

import com.kaishengit.profile.ProfileForm;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {


    @GetMapping("/profile")
    public String displayProfile() {
        return "profile/profilePage";
    }


    @PostMapping("/profile")
    public String saveProfile(ProfileForm profileForm) {
        System.out.println(profileForm);
        return "redirect:/profile";
    }


}
