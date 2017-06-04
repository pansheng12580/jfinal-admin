package com.jfinal.admin.generator;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

/**
 * Created by pantheon on 17-5-28.
 */
public class _JfinalGenerator {

    //获取数据源
    public static DataSource getDataSource() {
        //任意时空调用prop
        Prop p = PropKit.use("db_config.properties");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"),p.get("user"), p.get("password"));
        dp.start();
        return dp.getDataSource();
    }

    public static void main(String[] args) {
        // base model 所使用的包名
        String baseModelPkg = "com.jfinal.admin.model.base";
        // base model 文件保存路径
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/com/jfinal/admin/model/base";
        // model 所使用的包名
        String modelPkg = "com.jfinal.admin.model";
        // model 文件保存路径
        String modelDir = baseModelDir + "/..";
        Generator gernerator = new Generator(getDataSource(), baseModelPkg, baseModelDir,
                modelPkg, modelDir);

        gernerator.setDialect(new MysqlDialect());

        // 添加不需要生成的表名
//		gernerator.addExcludedTable("view_","sys_","sys_role_privilege","sys_user_role");
        // 设置是否在 Model 中生成 dao 对象
        gernerator.setGenerateDaoInModel(true);
        // 设置是否生成字典文件
        gernerator.setGenerateDataDictionary(false);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
		gernerator.setRemovedTableNamePrefixes("t_","sys_");
        // 生成

        gernerator.generate();
    }
}
