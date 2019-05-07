package com.tamiconnectdb.TamiConnDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    private ApplicationDAO appDAO;

    public Application getApplicationByID(int id){
        Application obj = appDAO.getApplicationByID(id);
        return obj;
    }

    public List<Application> getAllApplication(){
        List<Application> list = appDAO.getAllApplications();
        return list;
    }

    public List<CodeValue1> getCodeValueByCodeID(int appId){
        List<CodeValue1> list = appDAO.getCodeValueByCodeID(appId);
        return list;
    }

    public List<CodeTableFormRel> getCodeListByFormId(int appId) {
        List<CodeTableFormRel> list = appDAO.getCodeListByFormId(appId);
        return list;
    }

}
