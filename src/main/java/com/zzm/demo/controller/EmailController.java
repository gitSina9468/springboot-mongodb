package com.zzm.demo.controller;

import com.zzm.demo.common.EmailRunnable;
import com.zzm.demo.pojo.Employee;
import com.zzm.demo.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/**
 * @author songQiang
 * @create 2018-04-16 15:16
 * @desc 邮件发动
 */
@RestController
public class EmailController {

    public static final String PATTERN_DATE = "yyyy-MM-dd";

    @Autowired
    ExecutorService executorService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public RespBean addEmp() throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat( PATTERN_DATE );
        Employee employee = new Employee();
        employee.setName("陈威");
        employee.setWorkID("123");
        employee.setContractTerm(3d);
        employee.setBeginContract(sdf.parse("2018-05-01"));
        employee.setEndContract(sdf.parse("2021-05-01"));
        employee.setEmail("369612871@qq.com");
        employee.setDepartmentName("技术部");
        employee.setPosName("java开发");
        executorService.execute(new EmailRunnable(employee));
        return new RespBean("success", "添加成功!");
    }
}
