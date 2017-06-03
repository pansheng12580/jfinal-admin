package com.jfinal.admin.route;

import com.jfinal.admin.module.front.controller.FrontIndexController;
import com.jfinal.config.Routes;

/**
 * Created by pantheon on 17-5-26.
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {

        add("/", FrontIndexController.class,"front");
    }
}
