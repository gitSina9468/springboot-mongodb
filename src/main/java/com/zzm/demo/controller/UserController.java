package com.zzm.demo.controller;

import com.zzm.demo.dao.IUserDao;
import com.zzm.demo.pojo.User;
import com.zzm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
/**
 * @Description:测试类Demo
 * @author zzm
 * @date 2017/9/19 12:13
 * @version V1.0 
 */
@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/index/test/{id}")
    @ResponseBody
    public Object test(@PathVariable String id) {
        User user = new User();
        user.setAge(1);
        user.setId(id);
        user.setAddress("lalala");
        user.setUid("1");
        user.setDate(new Date());
        user.setName("zzm");
        iUserService.saveUser(user);
        return "true";
    }

    @GetMapping("/index/findAll")
    @ResponseBody
    public Object findAll() {
        return iUserDao.findAll();
    }

    @GetMapping("/index/find")
    @ResponseBody
    public Object find() {
        return iUserService.findUsersByName("zzm");
    }

    @GetMapping("/index/delete")
    @ResponseBody
    public Object delete() {
        return iUserDao.removeUserById("1");
    }

    /**
     * 复杂查询，分页，更新都可以使用MongoTemplate
     * @param id
     * @return
     */
    @GetMapping("/index/update/{id}")
    @ResponseBody
    public Object update(@PathVariable String id) {
        Query query = new Query(Criteria.where("name").is(id).orOperator(Criteria.where("id").is(0)));
        mongoTemplate.updateFirst(query, new Update().set("name", "zxr"), User.class);
        return iUserService.findUsersByName("zzm");
    }

}
