package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    // lay danh sach order
    public List<Order> getAllOrder(){
        return this.orderRepository.findAll();
    }

    public Page<Order>getAllOrder(Pageable pageable){
        return this.orderRepository.findAll(pageable);
    }

    //lây thong tin order theo id
    public Order getOrderById(long id){
       return this.orderRepository.findById(id);
    }
    //lây ra thong tin orderdetail theo user
    public List<OrderDetail> getAllOrderDetailById(Order order){
        return this.orderDetailRepository.findByOrder(order);
    }

    public Order handleSaveOrder(Order order){
        Order orderNew = this.orderRepository.save(order);
        return orderNew;
    }

    public void deleteOderById(long id){
        Order order = this.orderRepository.findById(id);
        if(order != null){
            List<OrderDetail> orderDetails = this.getAllOrderDetailById(order);
            for(OrderDetail orderDetail : orderDetails){
                this.orderDetailRepository.deleteById(orderDetail.getId());
            }
            this.orderRepository.deleteById(order.getId());
        }
    }

    public List<Order> getAllOrderByUser(User user){
        return this.orderRepository.findByUser(user);
    }
}
