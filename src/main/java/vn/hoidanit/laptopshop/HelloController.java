package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class HelloController {
    @GetMapping("/")
    public String getMethodName() {
        return "Xin chào java spring mvc 1";
    }

    @GetMapping("/user")
    public String showUserPage() {
        return "xin chào đên trang user1";
    }
    
    @GetMapping("/admin")
    public String showAdminPage() {
        return "xin chào đên trang Admin";
    }
    
}
