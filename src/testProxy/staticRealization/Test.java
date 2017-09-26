package testProxy.staticRealization;

/**
 * 用来测试java 静态代理
 */
public class Test {
    public static void main(String[] args) {
        InterfaceRunContext pr = new ProxyRun(new RunContextImpl());
        pr.runContext();
    }
}
