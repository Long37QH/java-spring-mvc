package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.domain.Product;


@Controller
public class ProductController {
     @GetMapping("/admin/product")
    public String getDashBoard() {
        return "admin/product/show";
    }

    @GetMapping("/admin/product/creat")
    public String getMethodName(Model model) {
        model.addAttribute("productnew", new Product());
        return "/admin/product/creat";
    }
    
}
