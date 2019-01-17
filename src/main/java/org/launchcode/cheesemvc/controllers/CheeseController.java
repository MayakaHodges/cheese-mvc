package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
//Every handler in classes must start with cheese
@RequestMapping("cheese")
public class CheeseController {

    /*We used a ArrayList for just the cheese now we have added a description,
    so we need a Hash Map.
    static ArrayList<String> cheeses = new ArrayList<>();*/
    HashMap<String, String> addForm = new HashMap<>();

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
        model.addAttribute("addForm", addForm);
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

    // Corresponds to the add.html
    // @RequestParam looks in add.html to find the String variable.
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription)
    {
        addForm.put(cheeseName,cheeseDescription);
        //Old way of just adding cheese without a description attached.
        //cheeses.add(cheeseName);
        //Redirect to /cheese
        return "redirect:";
    }
}
