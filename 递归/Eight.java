public class Eight 
{
	public static void main(String[] args) 
	{
		//定义棋盘大小
		int height = 8;
		int width = 8;
		//定义棋盘 0 为空
		int[][] board = new int[height][width];
	
		disBoard(board, height, width);

		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				;//调用查找方法findway
			}
		}
		
	}
	// num用来记录已经摆放多少个
	public static boolean findWay(int[][] board, int i, int j, int num)
	{
		if()
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
