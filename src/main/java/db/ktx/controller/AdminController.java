package db.ktx.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AdminController {

    @GetMapping("/admin")
    public String Admin(){
        return "admin";
    }

}
