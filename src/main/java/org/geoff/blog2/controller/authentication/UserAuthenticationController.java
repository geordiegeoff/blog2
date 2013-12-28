package org.geoff.blog2.controller.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAuthenticationController {
        
    @RequestMapping(value="/user-login", method=RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("pages/login-form");
    }
    
    @RequestMapping(value="/error-login", method=RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("pages/login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }
    
    @RequestMapping(value="/success-login", method=RequestMethod.GET)
    public ModelAndView successLogin() {
        return new ModelAndView("pages/success-login");
    }
    
    @RequestMapping(value="/user-logout", method=RequestMethod.GET)
    public ModelAndView getLogoutPage() {
        return new ModelAndView("pages/logout");
    }

}