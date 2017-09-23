package test;

public class Qsort {
	
	/*
	 * 交换函数
	 */
	public static void swap(int[]a,int i,int j) {
		if(i>a.length-1||j>a.length-1) {
			System.out.println("越界");
			return;
		}
		int tmp;
		tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	
	/**
	 * 输出打印函数
	 */
	public static void print(int []a){
		for(int i: a)
			System.out.print(i+" ");
		System.out.println();
	}
	
	/**
	 * 快速排序函数
	 */
	public static void qSort(int a [],int i,int j) {
		//这个条件不必要
		if(j<=i) 
			return;
		//跳出递归条件二  就剩两个元素
		if(j-i==1) {
			if(a[i]>a[j]) {
				swap(a,i,j);
			}
			return ;
		}
		int m=i,n=j;
		int po = a[i];
		while(m+1<=n) {
			if(a[m+1]<=po) {
				a[m]=a[m+1];
				m++;
			}else {
				swap(a,m+1,n);
				n--;
			}
		}
		a[m]=po;
		qSort(a,i,m-1);
		qSort(a,m+1,j);
	}
	
	/*
	 * 测试
	 */
	public static void main(String[] args) {
		int [] a = {5,4,3,2,6,8};
		qSort(a, 0, a.length-1);
		print(a);
	}
}
