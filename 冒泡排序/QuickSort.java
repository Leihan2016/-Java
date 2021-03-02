import java.util.Arrays;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		int[] data = {-9,78,0,23,-567,70, -1,900, 4561,-3};
		quickSort(data, 0, data.length-1);
	}
	
	public static void quickSort(int[] data, int left, int right)
	{
		int temp;
		int middleInt = data[(left + right)/2];
		int r = right;
		int l = left;
		//执行交换部分代码
		while(true)
		{			
			//查找左侧
			while(data[l] < middleInt)
				l++;
			//查找右侧
			while(data[r] > middleInt)
				r--;
			
			//越界行为
			if(l >= r)
				break;
			
			temp = data[l];
			data[l] = data[r];
			data[r] = temp;
			//System.out.println(left + "交换" + right);
			
			//如果将中间数据交换，交换后 左侧data[l] 数据为中间数据，证明右边指针r到达了middleint点停止了循环，而中间数据换到了左边，为继续while寻找，则将r--，指针左移
			if(middleInt == data[l])
			{
				r--;
			}
			//如果将中间数据交换，交换后 左侧data[r] 数据为中间数据，证明左边指针r到达了middleint点停止了循环，而中间数据换到了右边，为继续while寻找，则将l++，指针右移
			if(middleInt == data[r])
			{
				l++;
			}	

		}
		System.out.println(Arrays.toString(data));
		//当l == r时，此时刚好到达中间，为继续进行左右排序，给l右移，r左移，离开中心指针。
		if (l == r) {
			l += 1;
			r -= 1;
		}
		//可向左递归
		if(left < r)
		{
			quickSort(data, left, r);
		}
		if(right > l)
		{
			quickSort(data, l, right);
		}
	}
}
