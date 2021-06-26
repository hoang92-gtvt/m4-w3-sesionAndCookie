package controller;

import model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class Counter3Controller {

    @ModelAttribute("visitor")
    public Counter setCounter(){
        return new Counter();
    }

    @GetMapping("/index3")
    public String get2(@SessionAttribute("visitor") Counter counter){
        counter.increment();
        return "/index3";
    }
}
