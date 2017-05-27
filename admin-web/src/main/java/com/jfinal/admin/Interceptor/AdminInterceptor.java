package com.jfinal.admin.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by pantheon on 17-5-26.
 */
public class AdminInterceptor implements Interceptor {

    public void intercept(Invocation invocation) {

        System.out.println("======AdminInterceptor before======");
        System.out.println(invocation.getMethodName());
        invocation.invoke();
        System.out.println("======AdminInterceptor after======");
    }
}
