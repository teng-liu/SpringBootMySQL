package com.tamiconnectdb.TamiConnDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    TamiRepos formRepos;

    @Autowired
    CodeTableRepos codeableRepos;

    @GetMapping("/form")
    public List<Form> listForms(){
        return formRepos.findAll();
    }

    @PostMapping("/form")
    public @ResponseBody String addForm(@RequestParam String name){
        Form form = new Form(name);
        formRepos.save(form);
        return "Saved: " + name;
    }  //   http://localhost:8888/form/add?name=tamiNewForm



    @GetMapping("/form/{id}")
    public Form show(@PathVariable String id){
        int formId = Integer.parseInt(id);
        return null;
        //return formRepos.findOne(new Form(formId));
    }

    @GetMapping("/codetable")
    public List<CodeTable> showCodeTable(){
        return codeableRepos.findAll();
    }

}
