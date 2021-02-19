import java.util.*;
import java.text.*;

public class Select 
{
	public static void main(String[] args) 
	{
		//nt[] data = {0,3,8,12,1,6,-1};
		timeSave();
		sort(randomData());
		timeSave();
	}

	public static int[] sort(int[] data)
	{
		int lengthData = data.length;
		//需要进行n-1次排序
		for(int i = 0; i < lengthData-1; i++)
		{
			int num = data[i];
			int index = i;
			//每次排序需要遍历到最后一个数组元素，所以j<lengthData
			for(int j = i; j < lengthData; j++)
			{
				if(num > data[j])
				{
					num = data[j];
					index = j;
				}
			}
			data[index] = data[i];
			data[i] = num;
			//disPlay(data);
		}
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
