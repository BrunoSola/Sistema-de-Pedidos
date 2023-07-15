package com.devsuperior.sistemadepedidos.model.services;

import com.devsuperior.sistemadepedidos.model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;
    public double total(Order order){
        if (order.getDiscount() != 0.0) {
            double valueDiscount = order.getBasic() * (order.getDiscount()/100.0);
            return order.getBasic() - valueDiscount + shippingService.shipment(order);
        }
        else {
            return order.getBasic() + shippingService.shipment(order);
        }
    }
}
