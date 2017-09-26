package testProxy.cglibRealization;

public class Test {

    public static void main(String[] args) {
        CglibProxy cglib=new CglibProxy();
        SayHello sy=(SayHello) cglib.getProxy(new SayHello());
        sy.say();
    }
}
