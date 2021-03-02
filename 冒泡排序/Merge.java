import java.util.Arrays;

public class Merge
{
	public static void main(String[] args) 
	{
		int[] data = {8,4,5,7,1,3,6,9};
		merage(data, 0, data.length - 1);
	}

	public static void merage(int[] data, int left, int right)
	{
		//向右+1 起点，向左终点
		int mid = (right + left) / 2;
		if(left < right)
		{
			//向左
			merage(data, left, mid);
			//System.out.println("向左：" + left + " " + mid);
			//向右
			merage(data, mid+1, right);
			//System.out.println("向右：" + (mid+1) + " " + right);
			System.out.println(left + " - " + right + " * " + mid);
			unNum(data, left, right);
			//System.out.println();
		}	
	}

	// data 原始数组， left左侧 right右侧
	public static void unNum(int[] data, int left, int right)
	{
		int[] temp = new int[right - left + 1];
		int mid = (right + left) / 2;

		int i = left;
		int j = mid + 1;

		int k = 0;
		//添加
		while(i <= mid && j <= right)
		{
			if(data[i] < data[j])
			{
				temp[k] = data[i];
				i++;
				k++;
			}else
			{
				temp[k] = data[j];
				j++;
				k++;
			}
			
		}

		while( i <= mid)
		{
			temp[k] = data[i];
			i++;
			k++;
		}
		while(j <= right)
		{
			temp[k] = data[j];
			j++;
			k++;
		}
		
		int n = 0;
		while(n < temp.length)
		{
			data[n+left] = temp[n];
			n++;

		}


		System.out.println(Arrays.toString(temp));
		
	}
}
