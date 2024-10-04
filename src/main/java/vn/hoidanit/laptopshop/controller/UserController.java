package vn.hoidanit.laptopshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import vn.hoidanit.laptopshop.repository.UserService;

@Controller
public class UserController {
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/") 
    public String getHomePage(){
        String test  = this.userService.hello();
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
