# 自动填充


@TableField(.. fill = FieldFill.INSERT)

```
    /**
     * 默认不处理
     */
    DEFAULT,
    /**
     * 插入填充字段
     */
    INSERT,
    /**
     * 更新填充字段
     */
    UPDATE,
    /**
     * 插入和更新填充字段
     */
    INSERT_UPDATE
```

实现元对象处理器接口：com.baomidou.mybatisplus.core.handlers.MetaObjectHandler

```
注意事项：

- 填充原理是直接给entity的属性设置值!!!

- 注解则是指定该属性在对应情况下必有值,如果无值则入库会是null

- MetaObjectHandler提供的默认方法的策略均为:如果属性有值则不覆盖,如果填充值为null则不填充

- 字段必须声明TableField注解,属性fill选择对应策略,该声明告知Mybatis-Plus需要预留注入SQL字段

- 填充处理器MyMetaObjectHandler在 Spring Boot 中需要声明@Component或@Bean注入

- 要想根据注解FieldFill.xxx和字段名以及字段类型来区分必须使用父类的strictInsertFill或者strictUpdateFill方法

- 不需要根据任何来区分可以使用父类的fillStrategy方法
```

还需要再研究研究