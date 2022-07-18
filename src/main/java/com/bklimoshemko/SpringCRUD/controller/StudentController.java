package com.bklimoshemko.SpringCRUD.controller;

import com.bklimoshemko.SpringCRUD.entity.Student;
import com.bklimoshemko.SpringCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    static final int DEFAULT_PAGE_SIZE = 10;

    private final StudentService service;

    @Autowired
    public StudentController(final StudentService service){
        this.service = service;
    }

    @GetMapping("/students")
    public String index(){
        return("redirect:/list");
    }

    @GetMapping("/students/list")
    public String getStudents(final Model model,
                              @RequestParam(value="page", defaultValue = "0") final int pageNumber,
                              @RequestParam(value="size", defaultValue = DEFAULT_PAGE_SIZE + "") final int pageSize){

        final Page<Student> studentPage = service.getStudent(pageNumber, pageSize);

        final int currentPageNumber = studentPage.getNumber();
        final int previousPageNumber = studentPage.hasPrevious() ? currentPageNumber - 1 : -1;
        final int nextPageNumber = studentPage.hasNext() ? currentPageNumber + 1 : -1;

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("previousPageNumber", previousPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);

        return "students/list";
    }

    @GetMapping("/students/add")
    public String add(){
        return "students/add";
    }
    @GetMapping("/students/view")
    public String view(){
        return "students/view";
    }
    @GetMapping("/students/edit")
    public String edit(){
        return "students/edit";
    }
    @GetMapping("/students/delete")
    public String delete(){
        return "students/delete";
    }
}
