package com.mammutmkii.clcproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {
    @GetMapping("/angular")
    public String home(Model model) {
        return "forward:/index.html";
    }
}
