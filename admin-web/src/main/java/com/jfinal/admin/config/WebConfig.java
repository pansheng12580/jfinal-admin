package com.jfinal.admin.config;

import com.jfinal.admin.route.AdminRoutes;
import com.jfinal.admin.route.FrontRoutes;
import com.jfinal.admin.route.H5Routes;
import com.jfinal.config.*;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal3.JFinal3BeetlRenderFactory;

/**
 * Created by pantheon on 17-5-26.
 */
public class WebConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        //任意时空调用prop
        Prop p = PropKit.use("application.txt");
        constants.setDevMode(p.getBoolean("devMode"));

        constants.setEncoding("UTF-8");

        //beetl模板引擎设置
        JFinal3BeetlRenderFactory rf = new JFinal3BeetlRenderFactory();
        rf.config();
        constants.setRenderFactory(rf);

        GroupTemplate gt = rf.groupTemplate;
        //根据gt可以添加扩展函数，格式化函数，共享变量等，
    }

    public void configRoute(Routes routes) {
        routes.add(new FrontRoutes());
        routes.add(new AdminRoutes());
        routes.add(new H5Routes());

    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        //loadPropertyFile("db_config.txt");
        //DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"),getProperty("user"), getProperty("password"));
        //plugins.add(dp);

        //任意时空调用prop
        Prop p = PropKit.use("db_config.txt");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"),p.get("user"), p.get("password"));
        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setDialect(new MysqlDialect());
        plugins.add(arp);


    }

    public void configInterceptor(Interceptors interceptors) {
        //支持session
        interceptors.add(new SessionInViewInterceptor());
    }

    public void configHandler(Handlers handlers) {
    }

    @Override
    public void afterJFinalStart() {
        System.out.println("====jfinal war start====");


        super.afterJFinalStart();
    }

    @Override
    public void beforeJFinalStop() {
        System.out.println("====jfinal war stop====");

        super.beforeJFinalStop();
    }
}
