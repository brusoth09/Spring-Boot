package com.dsa.controller;

import com.dsa.domain.OrderTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {
    @Autowired
    JmsTemplate jmsTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/order")
    public void send(@RequestBody OrderTransaction orderTransaction){
        logger.info("Sending a transaction.");
        jmsTemplate.convertAndSend("OrderTransactionQueue", orderTransaction);
    }
}
