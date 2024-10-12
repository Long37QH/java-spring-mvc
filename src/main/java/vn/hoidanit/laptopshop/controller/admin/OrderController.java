package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;

import vn.hoidanit.laptopshop.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {
    private final OrderService orderService;
    
     public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderPage(Model model) {
        List<Order> listOrder = this.orderService.getAllOrder();
        model.addAttribute("listOrder", listOrder);
        return "/admin/order/show";
    }

    @GetMapping("/admin/order/{id}")
    public String getOrderDetailPage(Model model,@PathVariable long id) {
        Order order = this.orderService.getOrderById(id);
        List<OrderDetail> orderDetails = this.orderService.getAllOrderDetailById(order);
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "/admin/order/order_detail";
    }
    
    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrderPage(Model model,@PathVariable long id) {
        Order order = this.orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "/admin/order/update_order";
    }

    // câp nhật order
    @PostMapping("/admin/order/update")
    public String postMethodName(Model model,@ModelAttribute("order") Order OrderUp) {
         Order order = this.orderService.getOrderById(OrderUp.getId()) ;
         if(order != null){
            order.setStatus(OrderUp.getStatus());
            this.orderService.handleSaveOrder(order);
         }      
        return "redirect:/admin/order";
    }

    @GetMapping("/admin/order/delete/{id}")
    public String getMethodName(Model model,@PathVariable long id) {
        this.orderService.deleteOderById(id);
        return "redirect:/admin/order";
    }
    
    
}
