package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

    public void handleAddProductToCart(String email,long productId) {
        
        User user = this.userService.getUserByEmail(email);
        if(user != null){
            // check user da co cart chua ? neu chua -> tao moi
            Cart cart = this.cartRepository.findByUser(user);
            if(cart == null){
                // tao moi cart
                Cart cardNew = new Cart();
                cardNew.setUser(user);
                cardNew.setSum(1);

                cart =  this.cartRepository.save(cardNew);
            }
            // tim product by id
            Product product = this.productRepository.findById(productId);
            if(product != null){
            Product realProduct = product;
            // luu cart_detail
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(realProduct);
            cartDetail.setPrice(realProduct.getPrice());
            cartDetail.setQuantity(1);

            this.cartDetailRepository.save(cartDetail);
            }
            
        }
        
    }

}
