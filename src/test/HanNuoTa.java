package test;

public class HanNuoTa{
		public static void first(int i,int j,int k,int n){
				if(n==1){
						System.out.println("把第一个盘子移动到"+k);
						return;
				}
				first(i,k,j,n-1);   //先把前n-1个放到j上
				System.out.println("把第"+n+"个盘子放到"+k+"上");
				first(j,i,k,n-1);
		}

		public static void main(String args[])
		{
				first(1,2,3,4);
		}
}
