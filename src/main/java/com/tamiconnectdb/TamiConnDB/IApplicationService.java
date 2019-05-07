package com.tamiconnectdb.TamiConnDB;

import java.util.List;

public interface IApplicationService {
    Application getApplicationByID(int id);
    List<Application> getAllApplication();
    List<CodeValue1> getCodeValueByCodeID(int appId);
    List<CodeTableFormRel> getCodeListByFormId(int appId);
}
