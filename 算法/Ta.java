public class Ta
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		wayTa(5, 'A', 'B', 'C');
	}

	public static void wayTa(int num, char a, char b, char c)
	{
		if(num == 1)
		{
			System.out.println(num + "从" + a + "移动到" + c);
		}else
		{
			//将上层的从a-b
			wayTa(num-1, a, c, b);
			//最后一层从a-c
			System.out.println(num + "从" + a + "移动到" + c);
			//把b的从b-c
			wayTa(num-1, b, a, c);

		}
	}

}
