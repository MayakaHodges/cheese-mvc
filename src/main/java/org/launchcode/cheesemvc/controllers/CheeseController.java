package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
//Every handler in classes must start with cheese
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    //Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        //Do not want to hard code the information, so we added an add method
        // and moved ArraryList to class level.
        //ArrayList<String> cheeses = new ArrayList<>();
        //cheeses.add("cheddar");
        //cheeses.add("parmesan");
        //cheeses.add("munster");

        //Sending information to the html view
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);
        //Put the HTML into a folder named cheese.
        //Returns the HTML index template
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model)
    {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    /*
    The old way of processing forms, which are similar to Python's way
    to do web applications. This way will still work
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(HttpServletRequest request)
    {
        String cheeseName = request.getParameter("cheeseName");
    }
    */

    // Correspoonds to the add.html
    // @RequestParam looks in add.html to find the String variable.
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName)
    {
        cheeses.add(cheeseName);
        //Redirect to /cheese
        return "redirect:";
    }
}
