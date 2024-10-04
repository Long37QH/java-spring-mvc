package vn.hoidanit.laptopshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import vn.hoidanit.laptopshop.repository.UserService;

@Controller
public class UserController {
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/") 
    public String getHomePage(Model model){
        String test  = this.userService.hello();
        model.addAttribute("test", test);
        return "test";
    }
}

// @RestController
// public class UserController {
//     private UserService userService;
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }
//     @RequestMapping("/")
//     public String getHomePage() {
//         return this.userService.hello();
//     }
// }
