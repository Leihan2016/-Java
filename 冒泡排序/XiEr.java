import java.util.*;
import java.text.*;


public class XiEr  
{
	public static void main(String[] args) 
	{
		int[] data = {3,0,8,1,6,-1};
		timeSave();
		xiEr(randomData());
		timeSave();
	}

	public static int[] xiEr(int[] data)
	{
		int size = data.length;
		
		int upSize = size;
		int intSize = 0;

		while (upSize != 1)
		{
			upSize = upSize / 2;
			intSize = size / upSize;
			// 分为upSize组
			for (int i = 0; i < upSize; i++ )
			{
				//进行数据分割
				int[] num = new int[intSize];
				for (int j = 0; j < intSize; j++)
				{
					num[j] = data[j*upSize + i];
				}
				//对num进行排序
				
				num = insertSort3(num);

				//对num中数据进行还原
				for (int j = 0; j < intSize; j++)
				{
					data[j*upSize + i] = num[j];
				}
			}
		}
		//disPlay(data);
		return data;
	}


	public static int[] insertSort3(int[] data)
	{
		int size = data.length;
		int index;
		int indexNum;

		//int num = 0;

		for(int i = 1; i < size; i++)
		{
			//System.out.println("执行到此处验证"+data[i]);
			indexNum = data[i];
			for(index = i-1; index >= 0; index--)
			{
				//如果无序表中元素 小于 有序表中元素 有序表元素右移
				if(indexNum < data[index])
				{
					//元素右移 会覆盖 data[i] 因此需要使用indexNum进行标记
					data[index+1] = data[index]; 
				}else //否则 无序表元素直接插入有序表
					break;
			}
			//将无序表元素插入到 index
			if(index + 1 != i)
			{
				data[index + 1] = indexNum;
			}
			
		}
//		disPlay(data);
		return data;
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

	public static int[] randomData()
	{
		int[] data = new int[80000];
		for(int i=0; i < 80000; i++)
		{
			data[i] = (int)(Math.random() * 8000000);
		}
		return data;
	}

	public static void timeSave()
	{
		Date date = new Date();
		SimpleDateFormat formatSim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFm = formatSim.format(date);
		System.out.println("排序时间" + dateFm);
	}



}

