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

## MyBatis-Plus服务接口

[CategoryRepositoryTests](../src/test/java/com.fengwenyi.mybatisplusexample.CategoryRepositoryTests)

### 数据添加

```
mpXxxService.save(entity);
```

### 数据删除

```
mpXxxService.removeById(entity.getId());
```

### 数据查询

```
mpXxxService.list(queryWrapper);
```

### 数据修改

```
mpXxxService.updateById(entity);
```

## MyBatis数据库操作Mapper接口

[CategoryMapperTests](../src/test/java/com.fengwenyi.mybatisplusexample.CategoryMapperTests)

### 数据添加

```
xxxMapper.insert(entity);
```

### 数据删除

```
xxxMapper.deleteById(entity);
```

### 数据查询

```
xxxMapper.selectList(queryWrapper);
```

### 数据修改

```
xxxMapper.updateById(entity);
```

## Mybatis-Plus提供的AR

[CategoryModelTests](../src/test/java/com.fengwenyi.mybatisplusexample.CategoryModelTests)

### 数据添加

```
xxxModel.insert();
```

### 数据删除

```
xxxModel.deleteById();
```

### 数据修改

```
xxxModel.updateById();
```