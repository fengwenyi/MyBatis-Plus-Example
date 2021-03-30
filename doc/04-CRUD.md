# CRUD

- 增加(Create)
- 检索(Retrieve)
- 更新(Update)
- 删除(Delete)

对于MyBatis-Plus而言，增删改查，有三种方式实现。

1、使用MyBatis-Plus提供的服务接口。
2、使用MyBatis的Mapper接口。
3、使用Mybatis-Plus提供的AR特性，Model可进行CRUD操作。

AR即为ActiveRecord,是一种领域模型模式，一个模型类对应一个表。通过实体类对象直接进行表的CRUD操作。