import java.util.Arrays;

public class JiShu 
{
	public static void main(String[] args) 
	{
		int[] data = {53,3,52,748,14,214};
		jiShu(data);
	}

	public static void jiShu(int[] data)
	{	

		//数组data最大值
		int max = 0;
		int size = data.length;

		int[][] bucket = new int[10][size];
		int[] index = new int[10];

		for(int i = 0; i < size; i++)
		{
			if(max < data[i])
			{
				max = data[i];
			}
		}

		//位数
		int num;
		for(num = 0; max != 0; num++)
		{
			max = max / 10;
		}
		System.out.println("最大位数为：" + num);

		int re;
		for(int i = 0; i < num; i++)
		{
			for(int j = 0; j < size; j++)
			{
				re = (int)(data[j] / Math.pow(10, i)) % 10;
				System.out.println("各个位数为：" + re);
				
				bucket[re][index[re]] = data[j];
				index[re]++;
			}
			int m = 0;
			for(int n = 0; n < index.length; n++)
			{
				for(int k = 0; k < index[n]; k++)
				{
					data[m] = bucket[n][k];
					m++;
					//
				}
				index[n] = 0;
			}
			
		}

		System.out.println(Arrays.toString(data));
	}

}
