package com.zzm.demo.dao;

import com.zzm.demo.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * @Description:数据操作层，不需要写实现类，但method命名一定要对应实体类属性
 * @author 钟志苗
 * @date 2017/9/19 15:17
 * @version V1.0
 */
public interface IUserDao extends MongoRepository<User, Integer> {
    User findByUuidAndNameOrAge(String uid,String name,int age);

    List<User> findByName(String name);

    long removeUserById(String id);
}
