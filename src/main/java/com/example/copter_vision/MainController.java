package com.example.copter_vision;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/index")
    @ResponseBody
    public String getVideo(@RequestBody String http) {
        System.out.println(http);
        return http;
    }

}
