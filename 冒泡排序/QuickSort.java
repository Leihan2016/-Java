import java.util.Arrays;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		int[] data = {32,-7, -81, -9, 6, 25, 0, 23, -567, -70, 35};
		quickSort(data, 0, data.length-1);
	}
	
	public static void quickSort(int[] data, int left, int right)
	{
		int middle = (left + right)/2;;
		int temp;
		int middleInt = data[middle];
		
		if(right == left)
			return;

		//执行交换部分代码
		
		
		while(true)
		{			
			//查找左侧
			while(data[left] < middleInt)
				left++;
			//查找右侧
			while(data[right] > middleInt)
				right--;
			
			temp = data[left];
			data[left] = data[right];
			data[right] = temp;
			
			if(middleInt == data[left])
			{
				right--;
			}
			if(middleInt == data[right])
			{
				left++;
			}
			
			//越界行为
			if(left >= right)
				break;
			
		}
		
		System.out.println(Arrays.toString(data));
		
		int num = data.length - 1;
		if(right != num)
		{
			System.out.println("right is :" + right);
			quickSort(data, right+1, num);
		}
		if(left != 0)
		{
			System.out.println("left is :" + left);
			quickSort(data, 0, left-1);
		}
			
		
	}
}
