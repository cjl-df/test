package testProxy.dynamicRealization;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy{

    private Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    /**
     * 给目标对象生成代理对象
     * @param 第三个参数是InvocationHandler对象，是直接匿名实现InvoctionHandler借口
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始检测。。。。");
                        Object returnValue = method.invoke(obj,args);
                        System.out.println("检测结束........");
                        return returnValue;
                    }
                }
        );
    }
}
