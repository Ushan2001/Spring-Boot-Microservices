package com.example.order.service;

import com.example.inventory.dto.InventoryDTO;
import com.example.order.common.ErrorOrderResponse;
import com.example.order.common.SuccessOrderResponse;
import com.example.order.common.orderResponse;
import com.example.order.dto.OrderDTO;
import com.example.order.model.Orders;
import com.example.order.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional

public class OrderService {

    private final WebClient webClient;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient.Builder webClientBuilder, OrderRepo orderRepo, ModelMapper modelMapper ) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/v1").build();
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders> ordersList = orderRepo.findAll();
        return modelMapper.map(ordersList, new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    public orderResponse saveOrder(OrderDTO orderDTO) {

        Integer itemId = orderDTO.getItemid();

        try {
            InventoryDTO inventoryResponse = webClient.get()
                    .uri(uriBuilder ->  uriBuilder.path("/inventory/{inventoryId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();

            assert inventoryResponse != null;

            if(inventoryResponse.getQuantity() > 0){
                orderRepo.save(modelMapper.map(orderDTO, Orders.class));
                return new SuccessOrderResponse(orderDTO);
            }
            else {
                return new ErrorOrderResponse("Item not available, please try later");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        orderRepo.save(modelMapper.map(orderDTO, Orders.class));
        return orderDTO;
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order Deleted Successfully";
    }

    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.getOrdersBy(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }


}
