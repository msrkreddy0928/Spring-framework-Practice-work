package com.example.SpringSecuritydemo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Requestfilter extends HttpFilter {

    private Logger logger = LoggerFactory.getLogger(Requestfilter.class);


    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse , FilterChain filterChain) throws IOException, ServletException {
         logger.info("Executing Request filter");
          filterChain.doFilter(httpServletRequest,httpServletResponse);




    }

}
