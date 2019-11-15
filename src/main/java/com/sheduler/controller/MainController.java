package com.sheduler.controller;

import com.sheduler.dao.TaskDao;
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
        return "index";
    }

    @RequestMapping(value = {"addTask"}, method = RequestMethod.GET)
    public String addTask(Model model) {
        return "addTask";
    }

    @PostMapping ("createNewTask")
    public String createNewTask (@RequestParam String assignee, @RequestParam String summary, @RequestParam Date startDate, @RequestParam Date endDate, Map<String, Object> model){
        taskDao.saveTask(assignee, summary, startDate, endDate);
        return "redirect:/index";
    }
}