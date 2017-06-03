package com.jfinal.admin.route;

import com.jfinal.admin.module.admin.controller.AdminIndexController;
import com.jfinal.config.Routes;

/**
 * Created by pantheon on 17-5-26.
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {

        //addInterceptor(new AdminInterceptor());//添加admin拦截器

        add("/admin", AdminIndexController.class);

    }
}
