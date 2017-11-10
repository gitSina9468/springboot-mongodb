package com.zzm.demo.service;

import com.mongodb.DBObject;
import com.zzm.demo.pojo.DemoInfo;
import com.zzm.demo.pojo.PageModel;
import com.zzm.demo.pojo.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);

    List<User> findUsersByName(String name);

    PageModel<DemoInfo> getPage(PageModel<DemoInfo> page, DBObject queryObject, String collectionName);
}
