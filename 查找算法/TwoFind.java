public class TwoFind 
{
	public static void main(String[] args) 
	{
		int[] data = {1,2,3,4,5,6,7,8,9};
		findTwo(data, 10, 0, data.length-1);
	}

	public static void findTwo(int[] data, int findVal, int left, int right)
	{
		int mid = (left + right) / 2;

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
}
