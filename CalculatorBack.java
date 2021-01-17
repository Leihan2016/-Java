import java.util.*;
//��׺���ʽ������
public class CalculatorBack 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		//����: (3+4)��5-6 ��Ӧ�ĺ�׺���ʽ���� 3 4 + 5 �� 6 - , ��Ժ�׺���ʽ��ֵ��������:

		MiddleToLast midLast = new MiddleToLast();
		//CalculatorStack cal = new CalculatorStack("3 4 + 50 * 6 - ");
		//CalculatorStack cal = new CalculatorStack("34+5*6-");
	}
}


//ʵ���沨�����ʽ һ����пո�
/*1.���沨�����ʽString ͨ��String[]  array = split(" ")���зָ�
  2.ͨ��forѭ����ȡ��������ʽ"\\d+"����ƥ����ջ �����ж� ���м���
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
		System.out.println("�����������ʽ��");
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
					//����ջΪ�� ���� ����Ϊ������
					if(oper.empty() || temp == '(')
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(oper.peek().equals("("))//����ջ��Ϊ������
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(judge(temp) > judge(oper.peek().charAt(0)))//���ȼ���ջ���������
					{
						oper.push(String.valueOf(temp));
						break;
					}else if(temp == ')')//����������
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
					System.out.println("��ջΪ��"+number.peek());
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
				//������ļ�ȥ�ȳ�����
				//System.out.println("����Ϊ"+item);
				result = calNumStr(number.pop(), number.pop() , item);
				number.push(result);
			}else
			{
				if(item.matches("\\d+"))// \dƥ�����֡�0-9����+��ʾ���ƥ��
				{
					number.push(Float.parseFloat(item));
					//System.out.println("��ջ����Ϊ"+number.peek());
				}
			}
		}
		System.out.printf("%s = %s\n", expression, number.pop());
	}

	//����: (3+4)��5-6 ��Ӧ�ĺ�׺���ʽ���� 3 4 + 5 �� 6 - , ��Ժ�׺���ʽ��ֵ��������:
	//��������ɨ����ʽ����������ʱ��������ѹ���ջ��
	//���������ʱ������ջ�����������������������������Ӧ�ļ��㣨�ζ�Ԫ�� �� ջ��Ԫ�أ������������ջ��
	//�ظ���������ֱ�����ʽ���Ҷˣ��������ó���ֵ��Ϊ���ʽ�Ľ��
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
				//������ļ�ȥ�ȳ�����
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

