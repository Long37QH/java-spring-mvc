package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }


    // trang danh sach user
    @GetMapping("/admin/user")
    public String getListUserPage(Model model,@RequestParam("page") Optional<String> pageOptional ) {
        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                page = Integer.parseInt(pageOptional.get());
            }else{
                // page = 1
            }
        } catch (Exception e) {
            // page = 1
        }
        Pageable pageable = PageRequest.of(page - 1, 3);
        Page<User> prs = this.userService.getAllUsers(pageable);
        List<User> listUser = prs.getContent();
        model.addAttribute("listUser1", listUser);
        //lây so trong hiện tại truyên sang view
        model.addAttribute("curentPage", page);
        // lấy tông số trang
        model.addAttribute("totalPages", prs.getTotalPages());
        return "/admin/user/show";
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
    public String getValueInform(Model model,
            @ModelAttribute("usernew") @Valid User userNew,
            BindingResult newUserBindingResult,
            @RequestParam("fileImage") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>" + error.getField() + " - " + error.getDefaultMessage());
        }
        // validate
        if (newUserBindingResult.hasErrors()) {
            return "/admin/user/creat";
        }
        // lay thonhg tin file anh
        String avatar = this.uploadService.handeSaveUploadFile(file, "avatar");
        // ma hoa pass
        String hashPassword = this.passwordEncoder.encode(userNew.getPassword());

        // cap nhat lai thong tin vao doi tuong usernew
        userNew.setAvatar(avatar);
        userNew.setPassword(hashPassword);
        userNew.setRole(this.userService.getRoleByName(userNew.getRole().getName()));

        // System.out.println("run hear : " + userNew);
        this.userService.handlSaveUser(userNew);
        redirectAttributes.addFlashAttribute("message", "Thêm user thành công!");
        return "redirect:/admin/user";
    }

    // lay thong tin hien thi trang update
    @GetMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user/update_user";
    }

    // xu ly update user

    @PostMapping("/admin/user/update")
    public String postUpdateProduct(Model model,
            @ModelAttribute("user") @Valid User userUp,
            BindingResult newUserBindingResult,
            @RequestParam("fileImage") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>" + error.getField() + " - " + error.getDefaultMessage());
        }
                
        // validate
        if (newUserBindingResult.hasErrors()) {
            return "/admin/user/update_user";
        }

        User currenUser = this.userService.getUserById(userUp.getId());
        if (currenUser != null) {
            if(!file.isEmpty()){
                String avatar = this.uploadService.handeSaveUploadFile(file, "avatar");
                currenUser.setAvatar(avatar);
            }
            currenUser.setAddRess(userUp.getAddRess());
            currenUser.setFullName(userUp.getFullName());
            currenUser.setPhone(userUp.getPhone());

            currenUser.setRole(this.userService.getRoleByName(userUp.getRole().getName()));

            this.userService.handlSaveUser(currenUser);
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        }

        return "redirect:/admin/user";
    }

    // // delete user
    // @GetMapping("/admin/user/delete/{id}")
    // public String getDeletePage(Model model, @PathVariable long id) {
    // User user = this.userService.getUserById(id);
    // model.addAttribute("user", user);
    // return "/admin/user/delete";
    // }

    // @PostMapping("/admin/user/delete")
    // public String deleteUser(Model model, @ModelAttribute("user") User userDel) {
    // this.userService.deleteUser(userDel.getId());
    // return "redirect:/admin/user";
    // }

    // thuc hien xoa kho chuyen trang
    @GetMapping("/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id, RedirectAttributes redirectAttributes) {
        this.userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "Xóa bản ghi thành công!");
        return "redirect:/admin/user";
    }

}
