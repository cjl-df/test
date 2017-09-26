package testProxy.dynamicRealization;

import testProxy.staticRealization.InterfaceRunContext;
import testProxy.staticRealization.RunContextImpl;

public class TestDynamic {

    public static void main(String[] args) {
        InterfaceRunContext ifc = new RunContextImpl();

//        DynamicProxy dp = new DynamicProxy(ifc);
//        InterfaceRunContext proxy=(InterfaceRunContext)dp.getProxy();
//        proxy.runContext();

        InterfaceRunContext tpr = (InterfaceRunContext) new DynamicRealizationTwo(ifc).getProxy();
        tpr.runContext();
    }
}
