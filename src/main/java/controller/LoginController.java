package controller;


import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User getModeUser(){
        return new User();
    }

    @RequestMapping("/login")
    public ModelAndView index(@CookieValue (value="setUser", defaultValue="") String setUser){
        ModelAndView mav = new ModelAndView("/login");
        Cookie cookie = new Cookie("setUser", setUser);
        mav.addObject("cookieValue", cookie);
        return mav;
    }

    @PostMapping("/dologin")
    public  ModelAndView doLogin(@ModelAttribute ("user") User user, @CookieValue (value="setUser", defaultValue = "") String setUser,
                                HttpServletResponse response, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/login");
        if (user.getEmail().equals("admin@gmail.com") && user.getPassWord().equals("12345")) {

            if (user.getEmail() != null){
                setUser = user.getEmail();
            }

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);


            Cookie[] cookies = request.getCookies();

            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    mav.addObject("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    mav.addObject("cookieValue", ck);
                    break;
                }
            }
            mav.addObject("message", "Login success. Welcome ");

        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            mav.addObject("cookieValue", cookie);
            mav.addObject("message", "Login failed. Try again.");

        }
        return mav;
    }




}
