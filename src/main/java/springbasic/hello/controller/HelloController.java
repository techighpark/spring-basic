package springbasic.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hello Controller!");
        return "hello"; // ./templates/hello.html
    }
//
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("paramName") String paramValue, Model model){
        model.addAttribute("helloMvc", paramValue);
        return "hello-mvc-html";
    }
//
    @GetMapping("hello-api")
    @ResponseBody
    public String helloAPI(@RequestParam("paramName") String paramValue) {
        return "hello " + paramValue;
    }

    @GetMapping("hello-api2")
    @ResponseBody
    public Hello helloApi(@RequestParam("paramName") String paramValue) {
        Hello hello = new Hello();
        hello.setName(paramValue);
        return hello;
    }

    static class Hello {
        private String paramValue;

        public String getName() {
            return paramValue;
        }
        public void setName(String paramValue) {
            this.paramValue = paramValue;
        }
    }

}
