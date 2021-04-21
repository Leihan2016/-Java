public class PiPei
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		String str = "hellostrsstdfhanleisfskkdhh";
		String value = "hanlei";
		int index = pipeiStr(str, value);
		System.out.println(index);
	}

	public static int pipeiStr(String str, String value)
	{
		char[] strChar = str.toCharArray();
		char[] strValue = value.toCharArray();

		int strSize = strChar.length;
		int valueSize = strValue.length;

		int i = 0; 
		int j = 0;

		while(i < strSize && j < valueSize)
		{
			if(strChar[i] == strValue[j])
			{
				i++;
				j++;
			}else
			{
				i = i - (j - 1);
				j = 0;
			}
			if(j == valueSize)
			{
				return i-j;
			}
		}

		return -1;
		
	}
}
