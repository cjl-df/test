package testProxy.cglibRealization;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object obj;

    public Object getProxy(Object obj){
        this.obj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass()); //设置代理类的父类
        enhancer.setCallback(this);
        return enhancer.create();    //通过字节码技术动态创建子类实例
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = methodProxy.invoke(obj,args);
        System.out.println("代理后");
        return result;
    }
}
