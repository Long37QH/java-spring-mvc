package vn.hoidanit.laptopshop.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    private final UserService userService;
    
    
    public UserController(UserService userService) {
        this.userService = userService;   
    }
    @RequestMapping("/") 
    public String getHomePage(Model model){
        List<User> arrUser = userService.getAllByEmail("badgun37@gmail.com");
        System.out.println(arrUser);
        // model.addAttribute("test", "test");
        return "test";
    }

    // trang danh sach user
    @GetMapping("/admin/user")
    public String getListUserPage(Model model) { 
        List<User> listUser = userService.getAllUsers();
        model.addAttribute("listUser1", listUser);     
        return "/admin/user/list_user";
    }
    

    @GetMapping("/admin/user/creat")
    public String getCreateUserPage(Model model) {
        model.addAttribute("usernew", new User());
        return "/admin/user/creat";
    }
    
    @PostMapping("/admin/user/creat")
    public String getValueInform(Model model,@ModelAttribute("usernew") User userNew ) {
        System.out.println("run hear : "+ userNew);
        this.userService.handlSaveUser(userNew);
        return "redirect:/admin/user";
    }

    // @RequestMapping(value = "/admin/user/creat", method=RequestMethod.POST)
    // public String getValueInform(Model model,@ModelAttribute("usernew") User userNew ) {
    //     System.out.println("run hear : "+userNew);
    //     return "test";
    // }
    
    
}


