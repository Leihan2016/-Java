import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Dui 
{
	public static void main(String[] args) 
	{
		//int[] data = {4,6,1,8,5,3,12,2};


		int[] data = new int[80];
		for (int i = 0; i < 80; i++) {
			data[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}

		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
	
		
		for(int i = data.length/2 - 1; i >= 0; i--)
		{
			data = isOK(data, data.length, i);
		}
		//System.out.println(Arrays.toString(data));
		int temp = data[0];
		data[0] = data[data.length - 1];
		data[data.length - 1] = temp;	
		//System.out.println("下沉后" + Arrays.toString(data));
		//System.out.println();
		
		for(int i = data.length - 1; i > 1 ; i--)
		{
			data = isOK(data, i, 0);
			//System.out.println(Arrays.toString(data));
			
			temp = data[0];
			data[0] = data[i - 1];
			data[i - 1] = temp;
			//System.out.println("下沉后" + Arrays.toString(data) + "size: " + (i-1));
			//System.out.println();
		}		
		System.out.println("排序结果为" + Arrays.toString(data));


		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
	}


	public static int[] isOK(int[] data, int size, int notSon)
	{
		int right = 2*notSon + 2;
		int left = right - 1;
		

		if(size == 2)
		{
			if(data[notSon] < data[left])
			{
				int temp = data[notSon];
				data[notSon] = data[left];
				data[left] = temp;
			}
			return data;
		}
		
		for(; right < size; right = 2*notSon + 2)
		{
			left = right - 1;
			//只存在左节点或只存在右节点
			
			if(data[notSon] < data[left] && data[right] < data[left])
			{
				int temp = data[notSon];
				data[notSon] = data[left];
				data[left] = temp;
				notSon = left;
			}else if(data[notSon] < data[right] && data[right] > data[left]) 
			{
				int temp = data[notSon];
				data[notSon] = data[right]; 
				data[right] = temp;
				notSon = right;
			}else
				return data;
		}
		return data;
	}
}
