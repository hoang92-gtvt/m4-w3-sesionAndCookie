package controller;


import model.Counter;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunctions;

@Controller
@SessionAttributes("visitor")
public class CounterController {


    @ModelAttribute("visitor")
    public Counter setCounter(){
        return new Counter();
    }

    @GetMapping("/index")
    public String get(@ModelAttribute("visitor") Counter counter){
        counter.increment();
        return "/index";
    }
}
