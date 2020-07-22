package com.exin.exindemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import sun.misc.Version;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

//使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
    this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
     this.setFieldValByName("Version",1,metaObject);
    }
    //使用mp实现修改操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
