package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
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

    // trang user info
    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        System.out.println("check path id >> " + id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user/user_detail";
    }

    // chuyen trang create
    @GetMapping("/admin/user/creat")
    public String getCreateUserPage(Model model) {
        model.addAttribute("usernew", new User());
        return "/admin/user/creat";
    }

    // thuc hien create new

    @PostMapping("/admin/user/creat")
    public String getValueInform(Model model, @ModelAttribute("usernew") User userNew) {
        System.out.println("run hear : " + userNew);
        this.userService.handlSaveUser(userNew);
        return "redirect:/admin/user";
    }

    // @RequestMapping(value = "/admin/user/creat", method=RequestMethod.POST)
    // public String getValueInform(Model model,@ModelAttribute("usernew") User
    // userNew ) {
    // System.out.println("run hear : "+userNew);
    // return "test";
    // }

    // lay thong tin hien thi trang update
    @GetMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user/update_user";
    }

    // xu ly update user 

    @PostMapping("/admin/user/update")
    public String postMethodName(Model model, @ModelAttribute("user") User userUp) {
        User currenUser = this.userService.getUserById(userUp.getId());
        if (currenUser != null) {
            currenUser.setAddRess(userUp.getAddRess());
            currenUser.setFullName(userUp.getFullName());
            currenUser.setPhone(userUp.getPhone());

            this.userService.handlSaveUser(currenUser);
        }
        return "redirect:/admin/user";
    }

    // // delete user
    // @GetMapping("/admin/user/delete/{id}")
    // public String getDeletePage(Model model, @PathVariable long id) {
    //     User user = this.userService.getUserById(id);
    //     model.addAttribute("user", user);
    //     return "/admin/user/delete";
    // }

    // @PostMapping("/admin/user/delete")
    // public String deleteUser(Model model, @ModelAttribute("user") User userDel) {
    //     this.userService.deleteUser(userDel.getId());
    //     return "redirect:/admin/user";
    // }

    //thuc hien xoa kho chuyen trang
    @GetMapping("/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/user";
    }


}
