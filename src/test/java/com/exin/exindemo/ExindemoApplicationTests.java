package com.exin.exindemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exin.exindemo.entity.User;
import com.exin.exindemo.mapper.UserMapper;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ExindemoApplicationTests {


    @Autowired
    private UserMapper userMapper;



   //查询所有
    @Test
    void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Test
    public void addUser(){
        User user=new User();
        user.setAge(25);
        user.setName("chenqi");
        user.setEmail("www.baisu.com");

        int insert=userMapper.insert(user);
        System.out.println("添加"+insert);
    }

    //修改
        @Test
        public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setName("libai");

        int result=userMapper.updateById(user);
            System.out.println("修改"+result);
        }

    //测试乐观锁
    @Test
    public void testOne(){
        User user = userMapper.selectById(5);

       //进行修改
        user.setAge(11);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void testselectids(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1l, 2l));
        System.out.println(users);
    }

    //分页查询
    @Test
    public void testpage(){
          //创建page对象
        //传入两个参数，当前页和每页显示记录数
        Page<User> page=new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //分页的所有数据封装到page 对象里面
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());  //当前页
        System.out.println(page.getRecords());  //每页数据list'集合
        System.out.println(page.getSize());  //每页显示记录数
        System.out.println(page.getTotal());  //总记录数
        System.out.println(page.getPages());  //总页数


        System.out.println(page.hasNext());  //是否有下一页
        System.out.println(page.hasPrevious());  //是否有上一页

    }


    //删除操作，物理删除
    @Test
    public void testDeleteById(){

        int result = userMapper.deleteById(5L);
        System.out.println(result);
    }


    //批量删除
    @Test
    public void testDeleteBatchIds() {

        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }










}
