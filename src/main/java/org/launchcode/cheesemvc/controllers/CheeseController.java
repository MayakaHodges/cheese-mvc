package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Every handler in classes must start with cheese
@RequestMapping("cheese")
public class CheeseController {

    //Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "My Cheeses");
        //Put the HTML into a folder named cheese.
        //Returns the HTML index template
        return "cheese/index";
    }
}
