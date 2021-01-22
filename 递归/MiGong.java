public class MiGong 
{
	public static void main(String[] args) 
	{
		//定义棋盘大小
		int height = 8;
		int width = 8;
		//定义棋盘 0 为空
		int[][] board = new int[height][width];
		
		//完成棋盘边界初始化
		for(int i = 0; i < height; i++)
		{
			board[i][0] = 1;
			board[i][width-1] = 1;
		}
		for(int i = 0; i < width; i++)
		{
			board[0][i] = 1;
			board[height-1][i] = 1;
		}
		board[3][1] = 1;
		board[3][2] = 1;
		board[3][3] = 1;
		
		disBoard(board, height, width);
		
		findWay(board, 1, 1);
	    disBoard(board, height, width);

	}
	
	//出发位置i,j 结束位置7,7
	//1 为墙 2 为通 3 为不通
	// 路径与行走策略有关 走不通 回溯
	//函数findway 判断点i，j是否走通
	public static boolean findWay(int[][] board, int i, int j)
	{ 
		if(board[6][6] == 2)
			return true;
		else
		{
			if(board[i][j] == 0)//表示改点没有走过
			{
				//策略下-右-上-左
				board[i][j] = 2;// 这里标记可以走通 ,下 右 上 左 有一种即可走通
				if(findWay(board, i+1, j)) 
					return true;
				else if(findWay(board, i, j+1))
					return true;
				else if(findWay(board, i-1, j))
					return true;
				else if(findWay(board, i, j-1))
					return true;
				else //都走不通 标记3
				{
					board[i][j] = 3;
					return false;
				}
			}else
			{
				return false;
			}
		}
	
	}

	public static void disBoard(int[][] board, int height, int width)
	{
		System.out.println("棋盘输出");
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				System.out.printf(board[i][j]+" ");
			}
			System.out.println();
	
		}
	}
}
