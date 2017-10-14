/**
 *  动态链接问题
 */
public class UF {

    private int[] id;
    private int count;

    public void UF(int N){
        //初始化id数组
        count = N;
        id = new int[N];
        for (int i =0;i< N; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int find(int p){ return id[p];}

    public void union(int p,int q){
        //将p和q归并到相同的分量中
        int pID = id [ p];
        int qID = id[q];
        if(pID == qID) return;
        //将p的分量名重命名为q的名称
        for(int i=0; i<id.length ; i++)
            if( id[i] == pID ) id[i] = qID;
        count --;
    }
}
