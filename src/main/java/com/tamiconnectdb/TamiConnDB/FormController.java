package com.tamiconnectdb.TamiConnDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.sql.Statement;
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

    @Autowired
    IApplicationService appService;


    // ------QUERY-ALL-------------------------------------
    @GetMapping("/form")
    public List<Form> listForms(){
        return formRepos.findAll();
    }

    @GetMapping("/jdbc-applications")
    public ResponseEntity<List<Application>> getAllApplication(){
        List<Application> apps = appService.getAllApplication();
        return new ResponseEntity<List<Application>>(apps,HttpStatus.OK);
    }

    @GetMapping("/codetable")
    public List<CodeTable> showCodeTable(){
        return codeTableRepos.findAll();
    }

    @GetMapping("/codeformmapping")
    public List<CodeFormRelation> showMapping(){
        return codeFormMappingRepos.findAll();
    }

    @GetMapping("/codevalue")
    public List<CodeValue> showCodeValue(){
        return codeValueRepos.findAll();
    }


    // ------QUERY-BY-ID------------------------------------
    @GetMapping("/jdbc-applicationbyid")
    public ResponseEntity<Application> getApplicationByIDJson(@RequestBody Application form){
        Application app = appService.getApplicationByID(form.getId());
        return new ResponseEntity<Application>(app,HttpStatus.OK);
    }

    @GetMapping("/jdbc-getcodelistbyformid")
    public ResponseEntity<List<CodeTableFormRel>> getCodeListByFormIdJson(@RequestBody CodeTableFormRel rel){
        List<CodeTableFormRel> list = appService.getCodeListByFormId(rel.getFormID());
        return new ResponseEntity<List<CodeTableFormRel>>(list, HttpStatus.OK);
    }

    /** get codevalues by code-table-id */
    @GetMapping("/jdbc-getcodevaluebycodeid")
    public ResponseEntity<List<CodeValue1>> getCodeValueByFormIDJson(@RequestBody CodeValue1 cv1){
        List<CodeValue1> list = appService.getCodeValueByCodeID(cv1.getCodeTableId());
        return new ResponseEntity<List<CodeValue1>>(list,HttpStatus.OK);
    }


    // ------INSERT-------------------------------------
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ResponseEntity<Form> addFormJson(@RequestBody Form form){
        if(form != null){
            // form.setName(form.getName());
            formRepos.save(form);
        }
        return new ResponseEntity<Form>(form, HttpStatus.OK);
    }

    @PostMapping("/addcodevalue")
    public ResponseEntity<CodeValue> addCodeValueByCodeIdJson(@RequestBody CodeValue cv){
        if(cv != null){
            codeValueRepos.save(cv);
        }
        return new ResponseEntity<CodeValue>(cv, HttpStatus.OK);
    }

    @PostMapping("/addcode")
    public ResponseEntity<CodeTable> addCodeJson(@RequestBody CodeTable ct){
        if(ct != null){
            codeTableRepos.save(ct);
        }
        return new ResponseEntity<CodeTable>(ct, HttpStatus.OK);
    }

    @PostMapping("/addmapping")
    public ResponseEntity<CodeFormRelation> addMappingJson(@RequestBody CodeFormRelation rel){
        if(rel != null){
            rel.setFormID(rel.getFormID());
            rel.setCodeId(rel.getCodeId());
            codeFormMappingRepos.save(rel);
        }
        return new ResponseEntity<CodeFormRelation>(rel, HttpStatus.OK);
    }

    // ------UPDATE---------------------------------------------
    @RequestMapping(value = "/form", method = RequestMethod.PUT)
    public ResponseEntity<Form> updateFormJson(@RequestBody Form form){
        if(form != null){
            form.setName(form.getName());
        }
        formRepos.save(form);
        return new ResponseEntity<Form>(form, HttpStatus.OK);
    }

    @RequestMapping(value = "/codetable", method = RequestMethod.PUT)
    public ResponseEntity<CodeTable> updateCodeTableJson(@RequestBody CodeTable ct){
        if(ct != null){
            ct.setName(ct.getName());
        }
        codeTableRepos.save(ct);
        return new ResponseEntity<CodeTable>(ct, HttpStatus.OK);
    }

    @RequestMapping(value = "/codevalue", method = RequestMethod.PUT)
    public ResponseEntity<CodeValue> updateCodeValueJson(@RequestBody CodeValue cv){
        if(cv != null){
            cv.setValue(cv.getValue());
            cv.setCodetableId(cv.getCodetableId());
        }
        codeValueRepos.save(cv);
        return new ResponseEntity<CodeValue>(cv, HttpStatus.OK);
    }


    // ------DELETE---------------------------------------------
    @RequestMapping(value = "/form", method = RequestMethod.DELETE)
    public HttpStatus deleteFormbyIdJson(@RequestBody Form form){
        if(form != null){
            formRepos.deleteById(form.getId());
        }
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/codetable", method = RequestMethod.DELETE)
    public HttpStatus deleteCodeTableJson(@RequestBody CodeTable ct){
        if(ct != null){
            codeTableRepos.deleteById(ct.getId());
        }
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/codevalue", method = RequestMethod.DELETE)
    public HttpStatus deleteCodeValueByCodeIdJson(@RequestBody CodeValue cv){
        if(cv != null){
            codeValueRepos.deleteById(cv.getId());
        }
        return HttpStatus.OK;
    }



    //=================PathVariable=================================

    @GetMapping("/form/{id}")
    public Form showForm(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return formRepos.findById(iden).orElse(null);
    }

    @GetMapping("/jdbc-application/{id}")
    public ResponseEntity<Application> getApplicationByID(@PathVariable("id") int id){
        Application app = appService.getApplicationByID(id);
        return new ResponseEntity<Application>(app,HttpStatus.OK);
    }

    @GetMapping("/codetable/{id}")
    public CodeTable showCodeTable(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return codeTableRepos.findById(iden).orElse(null);
    }

    @GetMapping("/codevalue/{id}")
    public CodeValue showCodeValue(@PathVariable String id){
        int iden = Integer.parseInt(id);
        return codeValueRepos.findById(iden).orElse(null);
    }

    /** get codevalues by code-table-id */
    @GetMapping("/jdbc-codevalue/{id}")
    public ResponseEntity<List<CodeValue1>> getCodeValueByFormID(@PathVariable("id") int id){
        List<CodeValue1> cv = appService.getCodeValueByCodeID(id);
        return new ResponseEntity<List<CodeValue1>>(cv,HttpStatus.OK);
    }

}
