package com.fengwenyi.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器工具类（测试）
 *
 * 3.x生成的代码中，不含@TableField("name")
 * 官方人员的说法是：
 * @miemie 【成员】
 * 根据规则生成的entity不再会出现多余的注解
 *
 * @author Wenyi Feng
 * @since 2018-08-31
 */
public class Utils {

    /**
     * 执行生成代码
     */
    public static void generateCode() {
        String packageName = "com.fengwenyi.mpdemo";
        //generateByTables(packageName, "t_student", "t_city", "t_idcard");
        generateByTables(packageName, null);
    }

    private static void generateByTables(String packageName, String... tableNames) {

        // 数据库信息
        String dbUrl = "jdbc:mysql://localhost:3306/mybatis-plus?useSSL=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("xfsy2017")
                //.setDriverName("com.mysql.jdbc.Driver") // mysql 5
                .setDriverName("com.mysql.cj.jdbc.Driver") // mysql 8
                /*.setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        //.....
                        // 当发现生成的类型并不能满足你的要求时，可以去这里看，然后重写
                    }
                })*/
                ;

        // 配置
        GlobalConfig config = new GlobalConfig()
                .setActiveRecord(false)
                .setAuthor("Wenyi Feng")
                .setOutputDir("/Users/fengwenyi/Workspace/file/codeGen")
                .setFileOverride(true)
                .setActiveRecord(true)// 不需要ActiveRecord特性的请改为false
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(false)// XML columList
                .setKotlin(false) //是否生成 kotlin 代码
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setServiceName("MP%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setDateType(DateType.ONLY_DATE) //只使用 java.util.date 代替
                .setIdType(IdType.ID_WORKER)
                .setSwagger2(true) // model swagger2
                //.setOpen(true) // 是否打开输出目录
                ;
//                if (!serviceNameStartWithI)
//                    config.setServiceName("%sService");


        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                //.setDbColumnUnderline(true)
                .setTablePrefix("t_")// 此处可以修改为您的表前缀(数组)
                .setNaming(NamingStrategy.underline_to_camel) // 表名生成策略
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                //.setExclude(new String[]{"test"}) // 排除生成的表
                .setEntityLombokModel(true) // lombok实体
                .setEntityBuilderModel(false) // 【实体】是否为构建者模型（默认 false）
                .setEntityColumnConstant(true) // 【实体】是否生成字段常量（默认 false）// 可通过常量名获取数据库字段名
                .setLogicDeleteFieldName("is_delete") // 逻辑删除属性名称
                //.setEntityTableFieldAnnotationEnable
                .entityTableFieldAnnotationEnable(true)
                ;

        // 包信息配置
        PackageConfig packageConfig = new PackageConfig()
                .setParent(packageName)
                .setController("controller")
                .setEntity("model")
                .setMapper("dao")
                .setXml("mapper")

                /*
                // 共同构建成包名
                .setParent("com.fengwenyi")
                .setModuleName("model")
                */
                ;

        // 执行器
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

}
