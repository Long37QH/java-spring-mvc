package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;

import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getDashBoard(Model model) {
        List<Product> listProducts = this.productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/creat")
    public String getCreateProductPage(Model model) {
        model.addAttribute("productnew", new Product());
        return "/admin/product/creat";
    }

    @PostMapping("/admin/product/creat")
    public String postCreateProductPage(Model model,
            @ModelAttribute("productnew") @Valid Product productNew,
            BindingResult newProductBindingResult,
            @RequestParam("ImageProduct") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>" + error.getField() + " - " + error.getDefaultMessage());
        }
        // validate
        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/creat";
        }
        String productimg = this.uploadService.handeSaveUploadFile(file, "product");
        productNew.setImage(productimg);
        System.out.println("run hear : " + productNew);

        this.productService.handlSaveProduct(productNew);
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/{id}")
    public String getInfoProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/product_detail";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/update_product";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model,
            @ModelAttribute("product") @Valid Product productUp,
            BindingResult newProductBindingResult,
            @RequestParam("ImageProduct") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>" + error.getField() + " - " + error.getDefaultMessage());
        }
        // validate
        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/update_product";
        }

        Product CurrenProduct = this.productService.getProductById(productUp.getId());

        if(CurrenProduct != null){
            if(!file.isEmpty()){
                String image = this.uploadService.handeSaveUploadFile(file, "product");
                CurrenProduct.setImage(image);
            }
            CurrenProduct.setName(productUp.getName());
            CurrenProduct.setPrice(productUp.getPrice());
            CurrenProduct.setDetailDesc(productUp.getDetailDesc());
            CurrenProduct.setShortDesc(productUp.getShortDesc());
            CurrenProduct.setQuantity(productUp.getQuantity());
            CurrenProduct.setFactory(productUp.getFactory());
            CurrenProduct.setTarget(productUp.getTarget());

            this.productService.handlSaveProduct(CurrenProduct);
            redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");

        }

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getMethodName(Model model, @PathVariable long id, RedirectAttributes redirectAttributes) {
        this.productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/admin/product";
    }
    

}
