public class Maopao
{
	public static void main(String[] args) 
	{
		

		// 冒泡排序 相邻比较，逆序交换，不断后移   需要设置两个 指针类的符号进行后移操作
		// 对于数组大小为n的数据 操作次数为 n-1

		int[] data = {5,10,6,2,4};
		int back, next;
		int lengthData = data.length - 1;
		for(int i = 0; i < lengthData; i++)
		{
			back = i;
			next = back+1;
			if(data[back] < data[next])
			{
				int temp = data[next];
				data[next] = data[back];
				data[back] = temp;
			}
		}
		disPlay(data);
		System.out.println("Hello World!");
	}

	public static void disPlay(int[] data)
	{
		int size = data.length;
		for(int i = 0; i < size; i++)
		{
			System.out.printf("%d ",data[i]);
		}
		System.out.println();
	}
}
