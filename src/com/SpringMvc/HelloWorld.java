package com.SpringMvc;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017-05-22.
 */
@Controller
public class HelloWorld {

    @RequestMapping("/helloSpringMVC")
    public String helloworld() {
        System.out.println(helloworld());
        return "success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, params = "userId")
    public String test1() {
        return "user/test1";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        UserDao.delelte(id);
        return "redirect:/user/list.action";
    }

    @RequestMapping("/handle5")
    public String handle5(@RequestParam(value = "userName", required = false) String userName, @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping("/handle6")
    public String handle6(@CookieValue(value = "sessionId", required = false) String sessionId, @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping("/handle7")
    public String handle7(@RequestHeader("Accep-Encoding") String encoding, @RequestHeader("Keep-Alive") long keppAlieve) {
        return "success";
    }

    @RequestMapping("/handle8")
    public String handle8(User user) {
        return "success";
    }

    @RequestMapping("/handle9")
    public void handle9(MockHttpServletRequest request, MockHttpServletRequest response) {
        return;
    }

    @RequestMapping("/handle10")
    public ModelAndView handle10(MockHttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //
        return modelAndView;
    }

    @RequestMapping("/handle11")
    public String handle11(MockHttpSession session) {
        //
        return "success";
    }

    @RequestMapping("/handle12")
    public String handle12(MockHttpServletRequest request, @RequestParam("userName") String userName) {
        //
        return "success";
    }

}
