package vn.hoidanit.laptopshop.controller.client;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String getHomePage(Model model) {
        return "/client/home";
    }
}
