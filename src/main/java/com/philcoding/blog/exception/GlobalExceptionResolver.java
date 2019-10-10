package com.philcoding.blog.exception;

import com.philcoding.blog.model.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(CURDException.class)
    @ResponseBody
    public ResponseEntity<Result> curdExceptionHandler(CURDException e) {
        return ResponseEntity
                .badRequest()
                .body(Result.fail(e.getCode(), e.getMessage()));
    }

    public ModelAndView handleException(Exception e, HttpServletRequest req) {

        ModelAndView view = new ModelAndView("error");
        view.addObject("msg", e.getMessage());
        view.addObject("url", req.getRequestURL());
        view.addObject("stackTrace", e.getStackTrace());

        return view;
    }
}
