import java.util.Arrays;


public class GuiBing  
{
	public static void main(String[] args) 
	{
		//int[] data = {8,4,5,7,1,3,6,9};
		int[] data = {1,3,5,7,2,4,6,8};
		guiSort(data);
	}

	public static void guiSort(int[] data)
	{
		int size = data.length;
		int temp;
		int num = size/2;

		int index1;
		int index2;
		
		int[] dataN1 = new int[num];
		int[] dataN2 = new int[size - num];

		for(int i=0; i < num; i++)
		{
			dataN1[i] = data[i];
		}
		for(int i=num; i < size; i++)
		{
			dataN2[i-num] = data[i];
		}

		if(dataN1.length != 1)
			guiSort(dataN1);
		else
			return ;

		if(dataN2.length != 1)
			guiSort(dataN2);
		else
			return ;

		System.out.println("dataN1: " + Arrays.toString(dataN1));
		System.out.println("dataN2: " + Arrays.toString(dataN2));
		
		if(dataN1[0] < dataN2[0])
		{
			temp = dataN1[0];
		}else
			temp = dataN2[0];

		int sizeN1N2 = dataN1.length + dataN2.length;
		int[] dataN1N2 = new int[sizeN1N2];
		
		int n1 = 0;
		int n2 = 0;
		
		for(int i = 0, j = 0, k = 0; k < sizeN1N2; )
		{
			while( i < dataN1.length)
			{
				if(dataN1[i] < dataN2[n2])
				{
					n1 = i;
					dataN1N2[k] = dataN1[i];
					i++;
					k++;
				}else
				{
					i--;
					break;
				}		
			}

			while( j < dataN2.length)
			{
				if(dataN1[n1] < dataN2[j])
				{
					n2 = j;
					dataN1N2[k] = dataN2[j];
					j++;
					k++;
				}else
				{
					j--;
					break;
				}	
			}
		}
		System.out.println("dataN12: " + Arrays.toString(dataN1N2));
		
	}
}
