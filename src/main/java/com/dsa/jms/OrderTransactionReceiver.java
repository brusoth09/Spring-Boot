package com.dsa.jms;

import com.dsa.domain.OrderTransaction;
import com.dsa.respository.OrderTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.das.configuration")
public class OrderTransactionReceiver {
    @Autowired
    private OrderTransactionRepository transactionRepository;

    @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
    public void receiveMessage(OrderTransaction transaction) {
        System.out.println("Received <" + transaction + ">");
        transactionRepository.save(transaction);
    }

}
