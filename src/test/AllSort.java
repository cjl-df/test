package test;

/*************************************************************************
	> File Name: AllSort.java
	> Author: 
	> Mail: 
	> Created Time: 2015年07月20日 星期一 20时14分23秒
 ************************************************************************/
//这是一个全排列函数
public class AllSort{

    public void sort(int []a,int i,int j){
        if(i==j){
            print(a);
            return ;
        }
        sort(a,i+1,j);
        for(int tmp=i+1;tmp<=j;tmp++){
            swap(a,i,tmp);
            sort(a,i+1,j);
            swap(a,tmp,i);
       }
    }


    public void swap(int []a,int i,int j)
    {
        int x=a[i];
        a[i]=a[j];
        a[j]=x;
    }


    public void print(int []a){
        int i=0;
        for(;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int []a={
            1,2,3,4
        };

        AllSort as=new AllSort();
        as.sort(a,0,a.length-1);
    }
}

