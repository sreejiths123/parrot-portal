package com.parrot.portal.controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author tajzivit
 */
public class TestController {
    
    public void handle() {
        System.out.println("handling...");
    }
    
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("handling args...");
    }
}
