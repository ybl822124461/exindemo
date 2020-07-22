package com.exin.exindemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

@Data

public class User {

    @TableId(type = IdType.ID_WORKER)//mp自带侧罗，生成19位值，数字类型使用这种侧罗，比如long
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //@TableField(fill = FieldFill.UPDATE)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;



    @TableLogic
    private Integer deleted;

}
