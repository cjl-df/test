package leetcode.array;

public class Matrix {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length<1 || matrix[0].length<1){
            return false;
        }
        return findNumberIn2DArray(matrix,0,matrix.length-1,0,matrix[0].length-1,target);
    }

    public boolean findNumberIn2DArray(int[][] matrix,int x,int x1,int y,int y1, int target) {
        if(x1<x || y1<y || matrix[x][y]>target || matrix[x1][y1]<target){
            return false;
        }
        if(matrix[x1][y]<target){
            y++;
            return findNumberIn2DArray(matrix,x,x1,y,y1,target);
        }else if(matrix[x1][y]>target){
            x1--;
            return findNumberIn2DArray(matrix,x,x1,y,y1,target);
        }else {
            return true;
        }
    }
}