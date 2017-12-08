package com.dsa.annotation;

import com.dsa.controller.CustomerController;
import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertTrue;

public class TodoTest {
    @Test
    public void annotationTodoShouldNotbeInNotImplmentedStatus() throws Exception {
        Class customerControllerClass = CustomerController.class;
        for(Method method: customerControllerClass.getMethods()){
            Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
            if(todoAnnotation != null && todoAnnotation.status() == Todo.Status.NOT_STARTED){
                assertTrue(true == false);
            }
        }
    }
}
