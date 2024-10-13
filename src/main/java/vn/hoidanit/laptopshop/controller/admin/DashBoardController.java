package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.service.UserService;


@Controller
public class DashBoardController {
    private final UserService userService;
    
    public DashBoardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getDashBoard(Model model) {
        model.addAttribute("coutUser", this.userService.coutUsers());
        model.addAttribute("coutProduct", this.userService.coutProducts());
        model.addAttribute("CoutOrder", this.userService.coutOrders());
        return "/admin/dashboard/show";
    }
    
}
