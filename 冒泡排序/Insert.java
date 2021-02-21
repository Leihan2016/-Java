import java.util.*;
import java.text.*;

public class Insert 
{
	public static void main(String[] args) 
	{
		int[] data = {3,0,8,12,1,6,-1};
		timeSave();
		insertSort3(randomData());
		timeSave();
	}

	public static void insertSort1(int[] data)
	{
		int size = data.length;
		int[] sortData = new int[size];
		sortData[0] = data[0];

		//int num = 0;

		for(int i = 1; i < size; i++)
		{
			//System.out.println("执行到此处验证"+data[i]);
			for(int j = i-1; j >= 0; j--)
			{
				//如果无序表中元素 大于 有序表中元素 将无序表元素插入到右边
				if(data[i] > sortData[j])
				{
					sortData[j+1] = data[i]; 
					break;
				}else //如果无序表元素 小于 有序表元素 将有序表数据向右移动 并判断是否最后一位
				{
					sortData[j+1] = sortData[j];//数据下标右移一位，为数据插入让位
					if(j == 0)
					{
						sortData[0] = data[i];
					}
				}
				//System.out.println("执行到此处"+j);
			}
			//disPlay(sortData);
		}
		//disPlay(sortData);
	}

	// 3 0 8 12
	public static void insertSort2(int[] data)
	{
		int size = data.length;
		int[] sortData = new int[size];
		sortData[0] = data[0];
		int index;

		//int num = 0;

		for(int i = 1; i < size; i++)
		{
			//System.out.println("执行到此处验证"+data[i]);
			for(index = i-1; index >= 0; index--)
			{
				//如果无序表中元素 小于 有序表中元素 有序表元素右移
				if(data[i] < sortData[index])
				{
					sortData[index+1] = sortData[index]; 
				}else //否则 无序表元素直接插入有序表
					break;
			}
			//将无序表元素插入到 index
			sortData[index + 1] = data[i];
			//disPlay(sortData);
		}
	}

	//3 0 8 12 1 6
	public static void insertSort3(int[] data)
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
