import java.util.*;
import java.text.*;

public class Maopao
{
	public static void main(String[] args) 
	{
		
		// 冒泡排序 相邻比较，逆序交换，不断后移   需要设置符号进行后移操作
		// 对于数组大小为n的数据 操作次数为 n-1

		//int[] data = {5,10,6,11,4,3,2};
		
		int[] data = new int[80000];
		for(int i=0; i < 80000; i++)
		{
			data[i] = (int)(Math.random() * 8000000);
		}

		Date date = new Date();
		SimpleDateFormat formatSim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFm = formatSim.format(date);
		System.out.println("排序前时间" + dateFm);
		sortNum(data);
		Date date2 = new Date();
		SimpleDateFormat formatSim2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFm2 = formatSim.format(date2);
		System.out.println("排序后时间" + dateFm2);
	}
	
	public static void sortNum(int[] data)
	{
		int lengthData = data.length - 1;
		int lengthTime = lengthData;
		boolean flag;
		for(int i = 0; i < lengthData; i++)
		{
			flag = true;
			for(int j = 0; j < lengthTime;j++)
			{
				if(data[j] < data[j+1])
				{
					int temp = data[j+1];
					data[j+1] = data[j];
					data[j] = temp;
					flag = false;
				}
			}
			//System.out.println("计算第"+(i+1));
			//disPlay(data);
			if(flag)
			{
				break;
			}
			lengthTime--;
		}
		System.out.printf("\n结果为：");
		//disPlay(data);
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
