package test;

/*************************************************************************
    > File Name: ChildSet.java
    > Author: cjl
    > Created Time: 2015年06月27日 星期六 14时33分32秒
 ************************************************************************/
//这是一个求一个集合所有子集的类
public class ChildSet{
	public static int fatherset[];
	/**
	 * 这是用来初始化一个集合
	 */
	public ChildSet (int i){
		fatherset=new int[i];	
		for(int j=0;j<i;j++)
				fatherset[j]=0;
	}
		
	public static void print(int a[])
	{
		for(int i:a)
			System.out.print(i+"  ");
		System.out.println();
	}


	public boolean sortNext(int a[]){
		int k=a.length-1;
		ChildSet.print(a);
		while(k>=0)   
		{
			if(a[k]==1)
			{
				k--;
				continue;
			}
			else
			{
				a[k]=1;
				int tmp=k+1;
				while(tmp<a.length)
				{
					a[tmp]=0;
					tmp++;
				}
				return true;
			}
		}	
			return false;
	}

	public static void main(String args[])
	{
		ChildSet cs=new ChildSet(3);
		cs.print(ChildSet.fatherset);
		while(cs.sortNext(fatherset)){
		}
	}
}

