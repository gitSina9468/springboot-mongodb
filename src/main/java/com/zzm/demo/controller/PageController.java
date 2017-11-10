package com.zzm.demo.controller;

import com.mongodb.BasicDBObject;
import com.zzm.demo.pojo.DemoInfo;
import com.zzm.demo.pojo.PageModel;
import com.zzm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${sq} on 2017/9/25.
 */
@RestController
public class PageController {

    @Autowired
    IUserService userService;

    //分页查询
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageModel<DemoInfo> findByPage(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageModel pageModel = new PageModel();
        pageModel.setPageNo(pageNo);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        PageModel<DemoInfo> pageModel1 = userService.getPage(pageModel,new BasicDBObject(map),"demoInfo");
        return pageModel;
    }
}
