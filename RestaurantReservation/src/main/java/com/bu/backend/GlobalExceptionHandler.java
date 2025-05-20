package com.bu.backend;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bu.backend.exception.LoginFailedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException(LoginFailedException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "login"; // login.html 페이지로 에러 메시지와 함께 이동
    }
  
}