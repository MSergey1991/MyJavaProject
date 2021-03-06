package com.sheduler.controller;

import com.sheduler.dao.TaskDao;
import com.sheduler.utilities.MessageSetter;
import com.sheduler.utilities.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


@Controller
public class MainController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder, Locale locale, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    public TaskDao taskDao;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("allTasks", taskDao.findAll());
        model.addAttribute("allAssignees", taskDao.findAllAssignees());
        return "index";
    }

    @RequestMapping(value = {"addTask"}, method = RequestMethod.GET)
    public String addTask() {
        return "addTask";
    }

    @PostMapping("createNewTask")
    public String createNewTask(@RequestParam String assignee, @RequestParam String summary, @RequestParam Date startDate, @RequestParam Date endDate, Map<String, Object> model) {
        boolean parametersValidationResult = Validator.validateTaskParameters(assignee, summary, startDate, endDate);
        model.put("incorrectEnteredParametersMessage", MessageSetter.setEnteredIncorrectParametersMessage(parametersValidationResult));
        taskDao.saveTask(assignee, summary, startDate, endDate, parametersValidationResult);
        if(parametersValidationResult==true){return "redirect:/index";}
        else return "addTask";
    }

    @PostMapping("searchFilter")
    public String searchFilter(@RequestParam String assignee, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String period, Map<String, Object> model) {
        model.put("allTasks", taskDao.findBySearchFilter(assignee, startDate, endDate, period));
        model.put("allAssignees", taskDao.findAllAssignees());
        model.put("noSearchResultMessage", MessageSetter.setNoSearchResultMessage(taskDao.findBySearchFilter(assignee, startDate, endDate, period)));
        return "index";
    }
}