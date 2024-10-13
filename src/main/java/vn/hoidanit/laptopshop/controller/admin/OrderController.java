package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;

import vn.hoidanit.laptopshop.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OrderController {
    private final OrderService orderService;
    
     public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderPage(Model model, @RequestParam("page") Optional<String> pageOptional) {
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
        Pageable pageable = PageRequest.of(page - 1, 5);

        Page<Order> prs = this.orderService.getAllOrder(pageable);
        List<Order> listOrder = prs.getContent();
        model.addAttribute("listOrder", listOrder);
        //lây so trong hiện tại truyên sang view
        model.addAttribute("curentPage", page);
        // lấy tông số trang
        model.addAttribute("totalPages", prs.getTotalPages());
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
