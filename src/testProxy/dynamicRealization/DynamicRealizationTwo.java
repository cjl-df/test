package testProxy.dynamicRealization;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicRealizationTwo implements InvocationHandler{

    private  Object obj;    //维护一个目标对象

    public DynamicRealizationTwo(Object obj){
        this.obj = obj;
    }

    /**
     * 动态生成一个代理对象
     * 第三个参数是InvocationHandler对象，因为该类实现了InvocationHandler借口，故可以直接this.
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("starting to run....log");
        Object pr=null;
        try {
            pr = method.invoke(obj,args);   //调用目标方法
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error......log");
        }
        System.out.println("end running .... log");
        return pr;
    }
}
