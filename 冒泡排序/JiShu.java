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
		
		//创建桶 bucket,用来存储数据
		int[][] bucket = new int[10][size];
		//创建下标index,用来存储相对应的桶里面有多少个数据
		int[] index = new int[10];
		
		//寻找数据集合data里面的最大值
		for(int i = 0; i < size; i++)
		{
			if(max < data[i])
			{
				max = data[i];
			}
		}

		//计算最大值的最高位数
		int num;
		for(num = 0; max != 0; num++)
		{
			max = max / 10;
		}
		System.out.println("最大位数为：" + num);
		
		//re用来存储个位十位.....相对应的数字
		int re;
		//外部for，循环num次，即表示个位、十位、百位、、、、、、
		for(int i = 0; i < num; i++)
		{
			//内部for用来对data进行遍历获取 re
			for(int j = 0; j < size; j++)
			{
				re = (int)(data[j] / Math.pow(10, i)) % 10;
				System.out.println("各个位数为：" + re);
				
				//将re存入桶里，并增加对应桶的下标
				bucket[re][index[re]] = data[j];
				index[re]++;
			}

			//将桶内的数据取回到data
			int m = 0;
			//外部for 用来对十个桶进行遍历
			for(int n = 0; n < index.length; n++)
			{
				//内部for 用来对桶内的数据进行遍历
				//如果index[n]为0，不执行------for先赋值，比较，执行，进行++
				for(int k = 0; k < index[n]; k++)
				{
					data[m] = bucket[n][k];
					m++;
					//
				}
				//把桶置零
				index[n] = 0;
			}
			
		}

		System.out.println(Arrays.toString(data));
	}

}
