package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;







@Controller
public class ProductPageController {

    private final ProductService productService;
    

    public ProductPageController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product/{id}")
    public String getMethodName(Model model,@PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "/client/product/detail";
    } 

    @PostMapping("/add-product-to-cart/{id}")
    public String postMethodName(@PathVariable long id,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        long productId = id;
        this.productService.handleAddProductToCart(email,productId,session);
        
        return "redirect:/";
    }
    
    @GetMapping("/cart")
    public String getMethodName() {
        return "/client/cart/show";
    }
    
}
