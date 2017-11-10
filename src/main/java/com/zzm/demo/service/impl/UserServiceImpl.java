package com.zzm.demo.service.impl;

import com.mongodb.DBObject;
import com.zzm.demo.dao.IUserDao;
import com.zzm.demo.pojo.DemoInfo;
import com.zzm.demo.pojo.PageModel;
import com.zzm.demo.pojo.User;
import com.zzm.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    IUserDao userDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        User user_copy = userDao.save(user);
        logger.info(user_copy.toString());
    }

    @Override
    public List<User> findUsersByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public PageModel<DemoInfo> getPage(PageModel<DemoInfo> page, DBObject queryObject, String collectionName) {

        Query query=new BasicQuery(queryObject);
//        Query query=new Query();
        //查询总数
        query.addCriteria(Criteria.where("age").gt(33));
        int count=(int) mongoTemplate.count(query,DemoInfo.class);
        page.setRowCount(count);

        //排序
        query.with(new Sort(Sort.Direction.ASC, "age"));
        query.skip(page.getSkip()).limit(page.getPageSize());
        List<DemoInfo>datas=mongoTemplate.find(query,DemoInfo.class);
        page.setDatas(datas);
        return page;
    }
}
