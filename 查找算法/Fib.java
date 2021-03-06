import java.util.Arrays;

public class Fib
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		int[] data = {1,3,4,9,12,14,15,16,17,18,19,20,21,22,23,24,25};
		
		int k = 0;

		int size = data.length;

		int fib = 0;
		int back = 1;
		int now = 1;

		//计算斐波那契数列的大小k
		while(size > fib - 1)
		{
			fib = back + now;
			back = now;
			now = fib;
			k++;
		}
		
		//初始化斐波那契数列
		int[] fibA = new int[k+2];
		fibA[0] = 1;
		fibA[1] = 1;
		for(int i = 2; i < k+2; i++)
		{
			fibA[i] = fibA[i-2] + fibA[i-1];
		}

		System.out.println("斐波那契数列为：" + Arrays.toString(fibA));

		System.out.println("下标为：" + fibFind(data, 0, data.length - 1, fibA, k, 23));
	}

	public static int fibFind(int[] data, int left, int right, int[] fib, int k, int findVal)
	{
		//斐波那契计算mid
		int mid = left + fib[k] - 1;
		
		//如果计算的mid大于right，超范围，则mid为right；
		if(mid >= right)
		{
			mid = right;
		}
		
		if(left > right)
			return -1;

		if(findVal < data[mid])
		{
			//这里用mid-1，由于mid已经检验，不符合findVal==data[mid]，因此从mid-1
			return fibFind(data, left, mid-1, fib, k - 1, findVal);
		}
		if(findVal > data[mid])
		{
			//这里用mid+1，由于mid已经检验，不符合findVal==data[mid]，因此从mid+1
			return fibFind(data, mid+1, right, fib, k - 2, findVal);
		}
		if(findVal == data[mid])
		{
			return mid;
		}

		return -1;

	}
}
