public class Eight 
{
	static int num;//用于计数
	int size = 8;
	int[] queen = new int[size];//创建八个皇后
	public static void main(String[] args) 
	{
		Eight eight = new Eight();
		eight.setQueen(0);
		System.out.println();
		System.out.println("正确解法共有" + num);
	}

	//采用递归 放置皇后
	private void setQueen(int n)
	{
		//如果 放置了8个，则进行一次输出，输出后进行递归；控制皇后
		if(n == 8)
		{
			num++;
			disBoard();
			return; //跳出，继续进行递归
		}
		//这里的for用来遍历皇后的位置
		for(int i = 1; i < size+1; i++)
		{
			//将第n个皇后放在位置i，然后进行判断是否合适，合适的话继续放置，既调用setQueen，不合适换位置到i+1;
			queen[n] = i;
			if(judge(n))
			{
				setQueen(n+1);
			}
		}
	}


	//用来判断放置位置是否合理，n表示第几个皇后
	private boolean judge(int n)
	{
		for(int i = 0; i < n; i++)
		{
			//不能在同一列，列的值用数组元素的值来表示，且不能在同一斜线
			//斜线上，上下(n-i)差1， queen[i] - queen[n]左右差1
			if(queen[i] == queen[n] || (n - i) == Math.abs(queen[i] - queen[n]))
			{
				return false;
			}
		}
		return true;
	}

	//此处用来显示结果
	private void disBoard()
	{
		for(int i = 0; i < size ; i++)
		{
			System.out.printf("%d ", queen[i]);
		}
		System.out.println();
	}
}
