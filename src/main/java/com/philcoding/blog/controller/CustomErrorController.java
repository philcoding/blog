package com.philcoding.blog.controller;

import com.philcoding.blog.model.Result;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController extends BasicErrorController {

    public CustomErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

        boolean includeStackTrace = isIncludeStackTrace(request, MediaType.ALL);
        Map<String, Object> model = getErrorAttributes(request, includeStackTrace);

        Map<String, Object> body = Result.fail(model);
        HttpStatus status = getStatus(request);

        return new ResponseEntity<>(body, status);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {

        HttpStatus status = getStatus(request);
        response.setStatus(getStatus(request).value());

        boolean includeStackTrace = isIncludeStackTrace(request, MediaType.TEXT_HTML);
        Map<String, Object> model = getErrorAttributes(request, includeStackTrace);
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);

        return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
    }
}
