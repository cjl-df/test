package com.test;

public class Test {	
	/*
	 * 冒泡排序
	 */
	public static void maoPaoSort(int a[]) {
		int pointer = 0;
		for(int i=a.length-1;i>0;) {
			for(int j=0;j<i;) {
				if(a[j]<=a[j+1]) {
					j++;
					continue;
				}
				else {
					pointer=j;
					int tmp = a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
					j++;
				}
			}
			i=pointer;
		}
	}
	
	/*
	 * 猴子吃桃子
	 */
	public static int sumTaoZi(int n) {
		if(n<=1)
			return 1;
		return (sumTaoZi(n-1)+1)*2;
	}
	
	/*
	 * 超级阶梯
	 */
	public static int superStairs(int n) {
		if(n<=1)
			return 0;
		else if(n==2)
			return 1;
		else if(n==3)
			return 2;
		else
			return superStairs(n-1)+superStairs(n-2);
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("eeee");
		/*
		 * 冒泡排序
		 */
//		System.out.println("dfsd");
//		int []a = {3,6,9,2,6,0};
//		maoPaoSort(a);
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
//		}
		
		/**
		 * 猴子吃桃子
		 */
//		System.out.println(sumTaoZi(4));
		
		/*
		 * 超级阶梯
		 */
//		System.out.println(superStairs(4));
		
	}
}
