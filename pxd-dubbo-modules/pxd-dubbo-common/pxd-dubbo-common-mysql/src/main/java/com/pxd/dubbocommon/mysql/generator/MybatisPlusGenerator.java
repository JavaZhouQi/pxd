package com.pxd.dubbocommon.mysql.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class MybatisPlusGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/pxd_user","root","root")
                .globalConfig(builder -> {
                    builder.author("PiXiaoDan") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/admin/Desktop/code/open-project/pxd/pxd-dubbo-modules/pxd-dubbo-user/pxd-dubbo-user-service/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.pxd.dubbo.user") // 设置父包名
                            //.moduleName("system") // 设置父包模块名
                            .service("manager")
                            .serviceImpl("manager.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/admin/Desktop/code/open-project/pxd/pxd-dubbo-modules/pxd-dubbo-user/pxd-dubbo-user-service/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
//                            .addInclude("t_simple") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                    .serviceBuilder().formatServiceFileName("%sManager")
                            .formatServiceImplFileName("%sManagerImpl")
                            .build();
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
