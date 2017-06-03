package com.jfinal.admin.module.admin.controller;

import com.jfinal.admin.base.BaseAdminController;
import com.jfinal.aop.Clear;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by pantheon on 17-5-26.
 */
//@Clear //清除admin拦截器
public class AdminIndexController extends BaseAdminController {



    public void index(){
        List<Record> recordList = Db.find("select * from t_test");
        setAttr("recordList",recordList);
        setAttr("name","pansheng");
        render("index.html");
    }

    @Clear //清除拦截器
    public void login(){

    }

}
