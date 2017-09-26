package testProxy.staticRealization;

public interface InterfaceRunContext {

    default void runContext(){
        System.out.println("运行中......");
    }

}
