package com.baomidou.mybatisplus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.gousade.paint.AiPaintServerApplication.class)
public class MybatisPlusCodeGeneratorTests {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void runFast() {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("woxigousade") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\IdeaProjects\\ai-paint-server\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.gousade.paint") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                    /*.pathInfo(Collections.singletonMap(OutputFile.other, "E://MybatisPlusCodeGenerator"))*/; // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder.addInclude("paint_tag") // 设置需要生成的表名
                        // 设置过滤表前缀
                        .addTablePrefix("t_", "c_")
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().enableRemoveIsPrefix().disableSerialVersionUID()
                        .idType(IdType.ASSIGN_ID)
                        .logicDeleteColumnName("deleted")
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                        .addTableFills(new Column("deleted", FieldFill.INSERT))
                        .build())
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
