package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository, UserService userService,
            OrderRepository orderRepository,OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
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

    public void handleAddProductToCart(String email,long productId,HttpSession session,long quantity) {
        
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
            
            //lay thong tin san phan da ton tai truoc do trong gio hang
            CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);
            
            if(oldDetail == null){
                // luu cart_detail
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setProduct(realProduct);
                cartDetail.setPrice(realProduct.getPrice());
                cartDetail.setQuantity(quantity);

                this.cartDetailRepository.save(cartDetail);
                // up date cart (sum) tong so san pham trong cart
                int slsp = cart.getSum() + 1;
                cart.setSum(slsp);
                this.cartRepository.save(cart);
                // cap nhat len session
                // session.setAttribute("sumsp", slsp);
                session.setAttribute("sumsp", slsp);

            }else{
                oldDetail.setQuantity(oldDetail.getQuantity() + quantity);
                this.cartDetailRepository.save(oldDetail);
            }
            
            }
            
        }
        
    }

    // lấy thông tin cart theo user
    public Cart fetchByUser(User user){
        return this.cartRepository.findByUser(user);
    }

    public void handleRemoveCartDetail(long cartDetailId,HttpSession session){
        Optional<CartDetail> cartDetailOptional = this.cartDetailRepository.findById(cartDetailId);
        if (cartDetailOptional.isPresent()) {
            CartDetail cartDetail = cartDetailOptional.get();

            Cart currentCart = cartDetail.getCart();
            // delete cart-detail
            this.cartDetailRepository.deleteById(cartDetailId);

            // update cart
            if (currentCart.getSum() > 1) {
                // update current cart
                int s = currentCart.getSum() - 1;
                currentCart.setSum(s);
                session.setAttribute("sumsp", s);
                this.cartRepository.save(currentCart);
            } else {
                // delete cart (sum = 1)
                this.cartRepository.deleteById(currentCart.getId());
                session.setAttribute("sumsp", 0);
            }
        }

    }
    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
        for (CartDetail cartDetail : cartDetails) {
            Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cdOptional.isPresent()) {
                CartDetail currentCartDetail = cdOptional.get();
                currentCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

    public void handlePlaceOrder(
        User user , HttpSession session,String receiverName,
        String receiverAddress,String receiverPhone){

            // buoc1 : lay thong tin gio hang tho user
            Cart cart = this.cartRepository.findByUser(user);
            if(cart != null){
                List<CartDetail> cartDetails = cart.getCartDetails();
                if(cartDetails != null){

                    // creat order
                    Order order = new Order();
                    order.setUser(user); 
                    order.setReceiverName(receiverName);
                    order.setReceiverAddress(receiverAddress);
                    order.setReceiverPhone(receiverPhone);
                    order.setStatus("PENDING");

                    double sum = 0;
                    for(CartDetail cartDetail : cartDetails){
                        sum+= cartDetail.getPrice() * cartDetail.getQuantity();
                    }
                    order.setTotalPrice(sum);
                    order = this.orderRepository.save(order);


                    // create orderdetail
                    for(CartDetail cartDetail : cartDetails){
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setOrder(order);
                        orderDetail.setProduct(cartDetail.getProduct()); 
                        orderDetail.setPrice(cartDetail.getPrice());
                        orderDetail.setQuantity(cartDetail.getQuantity());

                        this.orderDetailRepository.save(orderDetail);
                    }

                    // xoa sanr pham trong gior hang
                    for(CartDetail cartDetail : cartDetails){
                        this.cartDetailRepository.deleteById(cartDetail.getId());
                    }
                    this.cartRepository.deleteById(cart.getId());

                    // cap nhat lai session
                    session.setAttribute("sumsp", 0);
                }
            }
    }

}
