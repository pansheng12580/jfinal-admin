package com.jfinal.admin.module.front.controller;

import com.jfinal.admin.base.BaseFrontController;

/**
 * Created by pantheon on 17-5-26.
 */
public class FrontIndexController extends BaseFrontController {

    public void index(){
        render("index.html");
    }
}
