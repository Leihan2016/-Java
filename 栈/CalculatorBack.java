﻿import java.util.*;
//后缀表达式计算器
public class CalculatorBack 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		//例如: (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:

		MiddleToLast midLast = new MiddleToLast();
		//CalculatorStack cal = new CalculatorStack("3 4 + 50 * 6 - ");
		//CalculatorStack cal = new CalculatorStack("34+5*6-");
	}
}


//实际逆波兰表达式 一般会有空格
/*1.将逆波兰表达式String 通过String[]  array = split(" ")进行分割
  2.通过for循环读取，正则表达式"\\d+"进行匹配入栈 符号判断 进行计算
*/

class MiddleToLast
{
	private Stack<String> oper;
	private Stack<String> number;
	public MiddleToLast()
	{
		oper = new Stack<>();
		number = new Stack<>();
		init();
	}


	/*if(judge(temp) > judge(oper.peek().charAt(0)))
					{
						oper.push(String.valueOf(temp));
						break;
					}*/

	public void init()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入计算表达式：");
		String express = sc.next();
		char temp = ' ';
		int back = 0;
		for(int i = 0; i < express.length(); i++)
		{
			temp = express.charAt(i);
			if(judgeOper(temp))
			{
				back = i+1;
				while(true)
				{
					//符号栈为空 或者 符号为左括号
					if(oper.empty() || temp == '(')
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(oper.peek().equals("("))//符号栈顶为左括号
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(judge(temp) > judge(oper.peek().charAt(0)))//优先级比栈顶运算符高
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(temp == ')')//等于右括号
					{
						while(true)
						{
							if(oper.peek().equals("("))
							{
								oper.pop();
								break;
							}else
							{
								number.push(oper.pop());
							}
						}
					}else
					{
						number.push(oper.pop());
					}
				}
			}else
			{
				if(judgeOper(express.charAt(i+1)))
				{
					number.push(express.substring(back,i));
					System.out.println("入栈为："+number.peek());
					back = i+1;
				}
			}
		}
		while(true)
		{
			if(oper.empty())
				break;
			else
			{
				number.push(oper.pop());
			}
		}
		while(true)
		{
			if(number.empty())
				break;
			else
			{
				System.out.println(number.peek());
			}
		}


	}

	public boolean judgeOper(char temp)
	{
		if(temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '(' || temp == ')')
			return true;
		return false;
	}

	public int judge(char temp)
	{
		if(temp == '+' || temp == '-')
			return 1;
		if(temp == '*' || temp == '/')
			return 2;
		return -1;
	}
	
}


class CalculatorStack
{
	private String expression = " ";
	private Stack<Float> number;

	public CalculatorStack(String expression)
	{
		this.expression = expression;
	 	number = new Stack<>();
		//start();
		secondWay();
		
	}

	public void secondWay()
	{
		float a = 0;
		float b = 0;
		float result = 0;
		String[] array = expression.split(" ");
		
		for(String item: array)
		{
			//System.out.println(item);
			if(judgeOperStr(item))
			{
				//后出来的减去先出来的
				//System.out.println("符号为"+item);
				result = calNumStr(number.pop(), number.pop() , item);
				number.push(result);
			}else
			{
				if(item.matches("\\d+"))// \d匹配数字【0-9】，+表示多次匹配
				{
					number.push(Float.parseFloat(item));
					//System.out.println("入栈数字为"+number.peek());
				}
			}
		}
		System.out.printf("%s = %s\n", expression, number.pop());
	}

	//例如: (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
	//从左至右扫描表达式，遇到数字时，将数字压入堆栈，
	//遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈；
	//重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
	public void start()
	{
		char temp = ' ';
		float a = 0;
		float b = 0;
		float result = 0;

		for (int i = 0; i < expression.length(); i++)
		{
			temp = expression.charAt(i);
			if(judgeOper(temp))
			{
				//后出来的减去先出来的
				result = calNum(number.pop(), number.pop() , temp);
				number.push(result);
			}else
			{
				number.push(Float.parseFloat(expression.substring(i,i+1)));
			}
		}
		
		System.out.printf("%s = %s\n", expression, number.pop());
		
	}

	public boolean judgeOper(char temp)
	{
		if(temp == '+' || temp == '-' || temp == '*' || temp == '/')
			return true;
		return false;
	}
	
	public float calNum(float a, float b, char temp)
	{
		if(temp == '+')
			return a+b;
		if(temp == '-')
			return b-a;
		if(temp == '*')
			return a*b;
		if(temp == '/')
			return b/a;
		return -1;
	}

	public boolean judgeOperStr(String temp)
	{
		if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))
			return true;
		return false;
	}
	
	public float calNumStr(float a, float b, String temp)
	{
		if(temp.equals("+"))
			return a+b;
		if(temp.equals("-"))
			return b-a;
		if(temp.equals("*"))
			return a*b;
		if(temp.equals("/"))
			return b/a;
		return -1;
	}
}

