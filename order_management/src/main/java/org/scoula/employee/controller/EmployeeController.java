package org.scoula.employee.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.employee.dto.EmployeeDTO;
import org.scoula.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    final private EmployeeService service;

    @GetMapping("/list")
    public void list(Model model){
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    /* create */
    @GetMapping("/create")
    public void create(){
        log.info("create");
    }

    @PostMapping("/create")
    public String create(EmployeeDTO employee){
        log.info("create: " + employee );

        service.create(employee);
        return "redirect:/employee/list";
    }

    /* get */
    @GetMapping({ "/get", "/update"})
    public void get(@RequestParam("emNo") Long emNo, Model model){
        log.info("/get or /update");
        model.addAttribute("employee", service.get(emNo));
    }

    /* update */
    @PostMapping("/update")
    public String update(EmployeeDTO employee){
        log.info("update : " + employee);

        service.update(employee);
        return "redirect:/employee/list";
    }

    /* delete */
    @PostMapping("/delete")
    public String delete(@RequestParam("emNo") Long emNo){
        log.info("delete........" + emNo);

        service.delete(emNo);
        return "redirect:/employee/list";
    }

}
