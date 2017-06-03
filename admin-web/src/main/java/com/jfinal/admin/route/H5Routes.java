package com.jfinal.admin.route;

import com.jfinal.admin.module.h5.controller.H5IndexController;
import com.jfinal.config.Routes;

/**
 * Created by pantheon on 17-5-26.
 */
public class H5Routes extends Routes {
    @Override
    public void config() {

        add("/h5", H5IndexController.class);
    }
}
