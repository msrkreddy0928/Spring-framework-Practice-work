package com.example.Loggingmvc.Controller;



import com.example.Loggingmvc.LoggingMvcApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class WebController {
    @GetMapping("/page")
    @ResponseBody
    public String productid(){
        return "Hello ID";
    }

    @GetMapping( "/dynamic-menu")
    public ModelAndView getMenu(){
        List<LoggingMvcApplication.Productnew>products=new ArrayList<>();

        products.add(new LoggingMvcApplication.Productnew(200,"lap",200.44));
        products.add(new LoggingMvcApplication.Productnew(300,"comp",600.23));
      ModelAndView modelandview = new ModelAndView("dynamic-page.html");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YY hh:mm:ss");
        modelandview.getModelMap().put("serverTime",dateFormat.format(new Date()));
        modelandview.getModelMap().put("products",products);
        return modelandview;



    }



}
