package Jar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "{name:[a-z]+}.generate", method = RequestMethod.GET)
    public String  generate(@PathVariable("name") String name) {
        int pwd = (int)(Math.pow(10,9) * Math.random());
        return "Hi, "+name +"\n"+"Your new password is "+ pwd +".";
    }
}