package com.example.abstractroutingdemo.aop;

import com.example.abstractroutingdemo.config.DataSourceRouter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qinyan
 * @date 2021/6/24
 */
@Aspect
@Order(1) // 数据源的切换要在数据库事务之前, 设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中, 数值越小等级越高)
@Component
public class DataSourceAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    // 切点, 注意这里是在service层（具体是配置dao层还是service层需要看自己业务，原则就是当前业务需要在主库执行还是从库执行的判断依据在哪）
    @Pointcut("execution(* com.*.service.impl..*.*(..)))")
    public void aspect() {
    }

    @Before("aspect()")
    private void before(JoinPoint point) {
        //进入切面
        String method = point.getSignature().getName();//当前切入的方法名
        //	point.getSignature().getDeclaringType().getName();//当前切入的class

//		if (method.startsWith("query") || method.startsWith("select") || method.startsWith("get")
//				|| method.startsWith("find") || method.startsWith("read")) { //根据自己业务做判断主库从库切换
        DataSourceRouter.setMater();//设置为当前使用主库
//		DataSourceRouter.setSlave();//设置为当前使用从库
    }
    // 切面结束, 重置线程变量 ，
    @After("aspect()")
    public void after(JoinPoint joinPoint) {
        //切面结束
    }


}
