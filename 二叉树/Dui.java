import java.util.Arrays;

public class Dui 
{
	public static void main(String[] args) 
	{
		int[] data = {4,6,8,5,9};
		System.out.println(Arrays.toString(DuiSort(data)));
	}

	public static int[] DuiSort(int[] data)
	{
		int size = data.length;

		//第一次
		int notSon = size / 2 - 1;
		int index = size - 1;
		while(notSon >= 0)
		{

			int left = 2*notSon + 1;
			int right = 2*notSon + 2;
			
			if(data[notSon] < data[left])
			{
				int temp = data[notSon];
				data[notSon] = data[left];
				data[left] = temp;
				isOK(data, left);
			}

			if(data[notSon] < data[right])
			{
				int temp = data[notSon];
				data[notSon] = data[right]; 
				data[right] = temp;
				isOK(data, right);
			}

			notSon = (notSon - 2) / 2;
		}
		/*
		int temp = data[0];
		data[0] = data[index];
		data[index] = temp;
		*/

		
		return data;
	}

	public static void isOK(int[] data, int notSon)
	{
		int left = 2*notSon + 1;
		int right = 2*notSon + 2;
			
		if(data[notSon] < data[left])
		{
			int temp = data[notSon];
			data[notSon] = data[left];
			data[left] = temp;
		}
		if(data[notSon] < data[right])
		{
			int temp = data[notSon];
			data[notSon] = data[right]; 
			data[right] = temp;
		}

	}
}
