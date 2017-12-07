package com.dsa.controller;

import com.dsa.annotation.Todo;
import com.dsa.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Todo(author = "Burusothman", priority = Todo.Priority.HIGH, status = Todo.Status.STARTED)
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpEntity<String> create(@Valid @NotNull @RequestBody Customer customer) {
        logger.info("Create request created for customer with name : " + customer.getFirstName());
        return new HttpEntity<>("created successfully");
    }
}
