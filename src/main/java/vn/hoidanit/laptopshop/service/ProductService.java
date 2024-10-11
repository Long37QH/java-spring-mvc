package vn.hoidanit.laptopshop.service;

import java.util.List;


import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository, UserService userService) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
    }

    public Product handlSaveProduct(Product product) {
        Product productNew = this.productRepository.save(product);
        System.out.println(productNew);
        return productNew;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email,long productId,HttpSession session) {
        
        User user = this.userService.getUserByEmail(email);
        if(user != null){
            // check user da co cart chua ? neu chua -> tao moi
            Cart cart = this.cartRepository.findByUser(user);
            if(cart == null){
                // tao moi cart
                Cart cardNew = new Cart();
                cardNew.setUser(user);
                cardNew.setSum(0);

                cart =  this.cartRepository.save(cardNew);
            }
            // tim product by id
            Product product = this.productRepository.findById(productId);
            if(product != null){
            Product realProduct = product;

            CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);
            
            if(oldDetail == null){
                // luu cart_detail
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setProduct(realProduct);
                cartDetail.setPrice(realProduct.getPrice());
                cartDetail.setQuantity(1);

                this.cartDetailRepository.save(cartDetail);
                // up date cart (sum) tong so san pham trong cart
                int slsp = cart.getSum() + 1;
                cart.setSum(slsp);
                this.cartRepository.save(cart);
                // cap nhat len session
                // session.setAttribute("sumsp", slsp);
                session.setAttribute("sumsp", slsp);

            }else{
                oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                this.cartDetailRepository.save(oldDetail);
            }
            
            }
            
        }
        
    }

}
