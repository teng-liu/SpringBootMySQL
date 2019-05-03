package com.tamiconnectdb.TamiConnDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    TamiRepos formRepos;

    @Autowired
    CodeTableRepos codeTableRepos;

    @Autowired
    CodeFormMapRepos codeFormMappingRepos;

    @Autowired
    CodeValueRepos codeValueRepos;

    @GetMapping("/form")
    public List<Form> listForms(){
        return formRepos.findAll();
    }


//    @PutMapping("/form/{form}")
//    public ResponseEntity<Form> addForm(@RequestBody Form form){
//        //Form form = new Form(name);
//        //formRepos.save(form);
//        if(form != null){
//            form.setName(form.getName());
//        }
//        return new ResponseEntity<Form>(form, HttpStatus.OK);
//    }  //   http://localhost:8888/form/add?name=tamiNewForm
//

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ResponseEntity<Form> addFormJson(@RequestBody Form form){
        if(form != null){
            form.setName(form.getName());
        }
        formRepos.save(form);
        return new ResponseEntity<Form>(form, HttpStatus.OK);
    }

    @GetMapping("/form/{id}")
    public Form showForm(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return formRepos.findById(iden).orElse(null);
    }

    @GetMapping("/codetable")
    public List<CodeTable> showCodeTable(){
        return codeTableRepos.findAll();
    }

    @GetMapping("/codetable/{id}")
    public CodeTable showCodeTable(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return codeTableRepos.findById(iden).orElse(null);
    }

    @GetMapping("/codeformmapping")
    public List<CodeFormRelation> showMapping(){
        return codeFormMappingRepos.findAll();
    }

    @GetMapping("/codevalue")
    public List<CodeValue> showCodeValue(){
        return codeValueRepos.findAll();
    }

    @GetMapping("/codevalue/{id}")
    public CodeValue showCodeValue(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return codeValueRepos.findById(iden).orElse(null);
    }

    // @RequestMapping(value = "/codevalue", method = RequestMethod.POST)
    @PostMapping("/codevalue")
    public ResponseEntity<CodeValue> addCodeValueJson(@RequestBody CodeValue cv){
        if(cv != null){
            codeValueRepos.save(cv);
        }
        return new ResponseEntity<CodeValue>(cv, HttpStatus.OK);
    }

}
