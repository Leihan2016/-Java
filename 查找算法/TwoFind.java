public class TwoFind 
{
	public static void main(String[] args) 
	{
		int[] data = {1,2,3,4,4,5,6,7,8,9};
		findTwoAll(data, 4, 0, data.length-1);
	}

	public static void findTwo(int[] data, int findVal, int left, int right)
	{
		int mid = (left + right) / 2;
		
		//终止条件，left==right，循环到一个数字
		if(left > right)
		{
			System.out.println("没找到");
			return ;
		}
		
		//向右查找
		if(findVal > data[mid])
		{
			findTwo(data, findVal, mid+1, right);
		}

		if(findVal < data[mid])
		{
			findTwo(data, findVal, left, mid-1);
		}

		if(findVal == data[mid])			
		{
			System.out.println("找到下标为：" + mid);
			return ;
		}
				
		//return -1;
		
	}

	public static void findTwoAll(int[] data, int findVal, int left, int right)
	{
		int mid = (left + right) / 2;
		
		//终止条件，left==right，循环到一个数字
		if(left > right)
		{
			System.out.println("没找到");
			return ;
		}
		
		if(findVal > data[mid])
		{
			findTwoAll(data, findVal, mid+1, right);
		}

		if(findVal < data[mid])
		{
			findTwoAll(data, findVal, left, mid-1);
		}

		if(findVal == data[mid])			
		{

			System.out.println("找到下标为：" + mid);
			//使用while循环，向左向右遍历寻找，找到的下标加入list<Integer>
			//退出条件 到达左边界或者右边界，或者，相邻的数据 data[i] != data[mid]
			//findTwoAll(data, findVal, left, mid-1);
			//findTwoAll(data, findVal, mid+1, right);
		}

		
	}
}
