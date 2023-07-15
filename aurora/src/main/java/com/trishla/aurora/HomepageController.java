package com.trishla.aurora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomepageController {

    // Serve the React static files
    @GetMapping(value = { "", "/", "/app/**" })
    public String index() {
        return "index.html";
    }
}
