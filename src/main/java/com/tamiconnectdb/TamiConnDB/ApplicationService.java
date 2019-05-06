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
        return appDAO.getCodeValueByCodeID(appId);
    }
}
