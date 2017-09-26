package testProxy.staticRealization;

import java.util.Date;

public class ProxyRun implements InterfaceRunContext {

    private RunContextImpl rci;

    /**
     * 构造函数
     * @param rci
     */
    public ProxyRun(RunContextImpl rci){
        this.rci = rci;
    }

    @Override
    public void runContext(){
        System.out.println("before running...."+new Date());
        rci.runContext();
        System.out.println("after running....."+new Date());
    }

}
