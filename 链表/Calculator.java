import java.util.*;
public class Calculator  
{
	public static void main(String[] args) 
	{
		Stack<Float> number = new Stack<>();
		Stack<String> operator = new Stack<>();

		Scanner sc = new Scanner(System.in);
		System.out.printf("请输入表达式：");
		String cal = sc.next();
		System.out.printf("输入的表达式为：%s\n", cal);
		int back = 0;
		char temp; //可定义为temp = '';

		float result = 0; //中间计算结果
		float a;
		float b;
		for(int i = 0; i < cal.length(); i++)
		{
			temp = cal.charAt(i);
 
			if(temp >= 42 && temp <= 47)
			{
				//数字多位数处理  将字符串下标从back到i提取出来，并转换为浮点型存入栈
				//substring 提取[back,i)的字符串   
				number.push(Float.parseFloat(cal.substring(back,i)));
				//用于提取字符串中数字
				back = i+1; 
				if(operator.empty())
				{
					//将char型转化为String，存入栈
					operator.push(String.valueOf(temp));
				}else if(judgeOperation(temp) > judgeOperation(operator.peek().charAt(0)))
				{
					operator.push(String.valueOf(temp));
				}else
				{
					//a b存在除数 被除数 减数 被减数的区别
					b = number.pop();
					a = number.pop();
					if(operator.peek().equals("+"))
					{
						operator.pop();
						result = a + b;
					}else
					if(operator.peek().equals("-"))
					{
						operator.pop();
						result = a - b;
					}else
					if(operator.peek().equals("*"))
					{
						operator.pop();
						result = a * b;
					}else
					if(operator.peek().equals("/"))
					{
						operator.pop();
						result = a / b;
					}
					number.push(result);
					operator.push(String.valueOf(temp));
				}
			}
			if(i == cal.length()-1)
			{
				//把最后一个数字从String转换为float型并入栈
				number.push(Float.parseFloat(cal.substring(back,i+1)));
			}
		}
		
		while(true)
		{
			if(operator.empty())
				break;
			else
			{
				//此处和出栈顺序相关
				b = number.pop();
				a = number.pop();
				if(operator.peek().equals("+"))
				{
					operator.pop();
					result = a + b;
				}else
				if(operator.peek().equals("-"))
				{
					operator.pop();
					result = a - b;
				}else
				if(operator.peek().equals("*"))
				{
					operator.pop();
					result = a * b;
				}else
				if(operator.peek().equals("/"))
				{
					operator.pop();
					result = a / b;
				}
				number.push(result);
			}
		}
		
		while(true)
		{
			if(number.empty())
				break;
			System.out.printf("%s = %s\n", cal, number.pop());
		}
	}

	//用来判断符号的优先级
	public static int judgeOperation(char temp)
	{
		if(temp == 43 || temp == 45)
		{
			return 1;
		}
		if(temp == 42 || temp == 47)
		{
			return 2;
		}
		return 0;
	}
}
 