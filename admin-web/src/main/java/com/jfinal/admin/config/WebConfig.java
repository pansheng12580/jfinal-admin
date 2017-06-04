package com.jfinal.admin.config;

import com.jfinal.admin.route.AdminRoutes;
import com.jfinal.admin.route.FrontRoutes;
import com.jfinal.admin.route.H5Routes;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
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

    private boolean isLocal = isDevMode();

    @Override
    public void configConstant(Constants constants) {
        //是否是本地开发
        if(isLocal){
            constants.setDevMode(true);
        }
        constants.setError404View("admin/common/404.html");
        constants.setError500View("admin/common/500.html");

        constants.setEncoding("UTF-8");

        //beetl模板引擎设置
        JFinal3BeetlRenderFactory rf = new JFinal3BeetlRenderFactory();
        rf.config();
        constants.setRenderFactory(rf);

        GroupTemplate gt = rf.groupTemplate;
        //根据gt可以添加扩展函数，格式化函数，共享变量等，
    }
    @Override
    public void configRoute(Routes routes) {
        routes.add(new FrontRoutes());
        routes.add(new AdminRoutes());
        routes.add(new H5Routes());

    }
    @Override
    public void configEngine(Engine engine) {

    }
    @Override
    public void configPlugin(Plugins plugins) {
        //loadPropertyFile("db_config.properties");
        //DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"),getProperty("user"), getProperty("password"));
        //plugins.add(dp);

        //任意时空调用prop
        Prop p = PropKit.use("db_config.properties");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"),p.get("user"), p.get("password"));
        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setDialect(new MysqlDialect());
        if (isLocal) {
            arp.setShowSql(true);
        }
        plugins.add(arp);


    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        //支持session
        interceptors.add(new SessionInViewInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {
        //修改根目录路径名称
        handlers.add(new ContextPathHandler("basepath"));
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


    /**
     * 是否是开发模式
     * @return
     */
    private boolean isDevMode(){
        //任意时空调用prop
        Prop p = PropKit.use("application.properties");
        return p.getBoolean("devMode");
    }
}
