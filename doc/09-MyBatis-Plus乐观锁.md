# 乐观锁

添加拦截器

```
interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 乐观锁插件
```

乐观锁字段注解：

```
@Version
```
