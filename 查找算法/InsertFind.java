public class InsertFind 
{
	public static void main(String[] args) 
	{
		
		int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		System.out.println(insertFind(data, 0, data.length-1, 23));
		//insertFind(data, 0, data.length-1, 18);
	}

	//递归进行的函数，需要返回值时，造作如右式 return insertFind(data, left, mid -1 , findVal);

	public static int insertFind(int[] data, int left, int right, int findVal)
	{ 
		System.out.println("hello ");
		
		//这里left > right || findVal < data[0] || findVal > data[data.length - 1]防止计算出的mid过大，导致数组越界
		if(left > right || findVal < data[0] || findVal > data[data.length - 1])
			return -1;

		int mid = left + (right - left)*(findVal - data[left])/(data[right] - data[left]);
		
		if(findVal > data[mid])
		{
			return insertFind(data, mid+1, right, findVal);
		}

		if(findVal < data[mid])
		{
			return insertFind(data, left, mid -1 , findVal);
		}

		if(findVal == data[mid])
		{
			return mid;
		}

		return -1;

	}
}
