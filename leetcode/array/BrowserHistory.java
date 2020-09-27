package leetcode.array;

/**
 * 堆栈应用
 */
public class BrowserHistory {
    public int index;
    public int end;
    public String[] urls = new String[100];
    
    public BrowserHistory(String homepage) {
        this.end = this.index=0;
        this.urls[0] = homepage;
    }
    
    public void visit(String url) {
        this.end = this.index = this.index+1;
        this.urls[index] = url;
    }
    
    public String back(int steps) {
        index = index-steps <0?0: index-steps;
        return urls[index];
    }
    
    public String forward(int steps) {
        index = index+steps>end?end:index+steps;
        return urls[index];
    }
}
