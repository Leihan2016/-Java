public class FindTwo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		int[] data = {1,3,8,10,11,67,100};
		
		System.out.println(backIndex(data, 11));
	}

	public static int backIndex(int[] data, int target)
	{
		int left = 0;
		int right = data.length - 1;

		int temp = 0;

		while(left < right)
		{
			temp = (left + right)/2;
			if(data[temp] == target)
			{
				return temp;
			}else if(data[temp] < target)
			{
				left = temp;
			}else
			{
				right = temp;
			}

		}
		return -1;
		/*
		while(left <= right)
		{
			temp = (left + right)/2;
			if(data[temp] == target)
			{
				return temp;
			}else if(data[temp] < target)
			{
				left = temp+1;
			}else
			{
				right = temp-1;
			}

		}
		return -1;
		*/
	}
}


