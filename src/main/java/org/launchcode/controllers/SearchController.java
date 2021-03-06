package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
//move arraylist and model out of if and else statement

    @RequestMapping(value = "results")
    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
        model.addAttribute("columns", ListController.columnChoices);

        model.addAttribute("jobs", jobs);
        // how to pass number of search result?
        model.addAttribute("numberOfJobs",jobs.size());


        if (searchType.equals("all")) {
            return "search";


        } else {
            return "search";


        }
    }
}

