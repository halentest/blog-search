package blog.search.http;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: hzhang
 * Date: 11/12/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWrold(Model model) {
        model.addAttribute("name", "halen");
        return "hello_world";
    }
}
