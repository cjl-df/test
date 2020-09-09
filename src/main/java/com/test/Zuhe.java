package com.test;

public class Zuhe {
	
	static int x=0;
	
	public static void main(String args[]){
		int i=3;
		int []a={1,2,3,4,5,6};
		new Zuhe().allunion(a, 5);
		System.out.println(x);
	}
	
	public void allunion(int []a,int i){
		int []b =new int[a.length];
		int k=init(b,i);
		if(k==-1)
			System.out.println("erro!");
		else if(k==0)
			print(a);
		else{
			outpr(a,b);
			int j=0;
			int m=0;
			for(;j<a.length-1;j++){
				if(b[j]==0)
					continue;
				else{
					m++;
					if(b[j+1]==0){
						b[j]=0;
						b[j+1]=1;
						int z=0;
						if(j!=0&&b[0]==0){
							for(;z<m-1;z++)
								b[z]=1;
							for(;z<j;z++)
								b[z]=0;
						}
						outpr(a,b);
						j=-1;
						m=0;
					}else{
						continue;
					}
				}
			}
		}
	}
	
	public void outpr(int []a,int []b){
		x++;
		int j=0;
		for(;j<a.length&&j<b.length;j++){
			if(b[j]==1)
				System.out.print(a[j]+" ");
			else
				continue;
		}
		System.out.println();
	}
	
	//初始化数组
	public int init(int []a,int i){
		if(i>a.length)
			return -1;
		else if(i<1)
			return -1;
		else if(i==a.length)
			return 0;
		else{
			int j=0;
			for(;j<i;j++)
				a[j]=1;
			for(;j<a.length;j++)
				a[j]=0;
			return 1;
		}
	}
	
	//输出函数
	public void print(int []a){
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}
}
