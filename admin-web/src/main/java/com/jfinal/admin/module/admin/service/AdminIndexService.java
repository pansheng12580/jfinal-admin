package com.jfinal.admin.module.admin.service;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;

/**
 * Created by pantheon on 17-5-27.
 */
public class AdminIndexService {

    // 配置事务拦截器
    @Before(Tx.class)
    public void payment(int orderId, int userId) {
// service code here
        System.out.println("orderId:"+orderId+"--"+"userId:"+userId);
    }
}
