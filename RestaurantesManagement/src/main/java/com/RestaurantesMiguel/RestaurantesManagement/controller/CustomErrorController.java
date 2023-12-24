package com.RestaurantesMiguel.RestaurantesManagement.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());

            // Log the status code or return a custom error page based on statusCode
            System.out.println("Error with status code: " + statusCode);
        }

        return "error"; // Name of the error view
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
