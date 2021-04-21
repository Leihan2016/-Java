import java.util.Arrays;


public class KMP
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		String str = "BBC ABCDAB ABCDABCDABDE";
		String valueStr = "ABCABCABCCABC";
		int[] next = backKmp(valueStr);
		System.out.println(Arrays.toString(next));
		
		System.out.println(kmp(str, valueStr, next));

	}

	public static int kmp(String str, String valueStr, int[] next)
	{
		char[] strChar = str.toCharArray();
		char[] valueChar = valueStr.toCharArray();

		int size = strChar.length;

		for(int i = 1, j = 0; i < size; i++)
		{
			while(j > 0 && strChar[i] != valueChar[j])
			{
				j = next[j-1];
			}

			if(strChar[i] == valueChar[j])
			{
				j++;
			}

			if(j == valueChar.length)
			{
				return i-j;
			}
		}
		
		return -1;
	}

	public static int[] backKmp(String valueStr)
	{
		char[] valueChar = valueStr.toCharArray();
		int size = valueChar.length;
		int[] result = new int[size];

		result[0] = 0;

		for(int i = 1, j = 0; i < size; i++)
		{
			//不相等
			while(j > 0 && valueChar[i] != valueChar[j])
			{
				j = result[j-1];
				//j--;
			}

			//相等
			if(valueChar[i] == valueChar[j])
			{
				j++;
			}
			result[i] = j;
		}
		return result;
	}
}
