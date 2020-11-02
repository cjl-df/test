package leetcode.diagram;
import java.util.List;

//空心多边形
public class HollowPolygon {
    List<Point> outs;
    List<Point> ins;
    HollowPolygon(List<Point> outs,List<Point> ins){
        this.outs = outs;
        this.ins = ins;
    }
}