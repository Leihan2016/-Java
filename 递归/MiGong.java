public class MiGong 
{
	public static void main(String[] args) 
	{
		//定义棋盘大小
		int height = 8;
		int width = 8;
		//定义棋盘 0 为空
		int[][] board = new int[height][width];

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
		//完成棋盘边界初始化
		disBoard(board, height, width);
		
	

	}
	
	//出发位置1,1 结束位置7,7
	public static 

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
