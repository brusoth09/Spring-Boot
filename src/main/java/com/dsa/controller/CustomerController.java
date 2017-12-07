package com.dsa.controller;

import com.dsa.annotation.Todo;
import com.dsa.domain.Customer;
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
    @Todo(author = "Burusothman", priority = Todo.Priority.HIGH, status = Todo.Status.STARTED)
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public HttpEntity<String> create(@Valid @NotNull @RequestBody Customer customer) {
        return new HttpEntity<>("created successfuly");
    }
}
