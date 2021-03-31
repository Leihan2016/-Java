public class DongTaiGuiHua
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		bagMax();
	}

	public static void bagMax()
	{
		int[] weight = {1,4,3};
		int[] value = {1500, 3000, 2000};

		int bagSize = 4;
		int numFreight = weight.length;

		int[][] v = new int[numFreight+1][bagSize+1];
		int[][] path = new int[numFreight+1][bagSize+1];

		for(int i = 1; i < v.length; i++)
		{
			for(int j = 1; j < v[0].length; j++)
			{
				if(weight[i-1] > j)
				{
					v[i][j] = v[i-1][j];
				}else
				{
					//v[i][j] = Math.max(v[i-1][j], v[i-1][j-weight[i-1]] + value[i-1]);
					if(v[i-1][j] < v[i-1][j-weight[i-1]] + value[i-1])
					{
						v[i][j] = v[i-1][j-weight[i-1]] + value[i-1];
						path[i][j] = 1;
					}else
					{
						v[i][j] = v[i-1][j];
					}
				}
			}
		}


		for(int i = 1; i < v.length; i++)
		{
			
			for(int j = 1; j < v[0].length; j++)
			{
				System.out.printf("%d    ", v[i][j]);
			}
			System.out.println();
		}

		int i = v.length - 1;
		int j = v[0].length - 1;

		while(i > 0 && j > 0)
		{
			if(path[i][j] == 1)
			{
				System.out.println("放入商品" + i);
				//剩余空间进行更新，商品i和价格i-1对应        numFreight+1
				j = j - weight[i - 1];
			}
			//已经加入商品i，对i进行更新
			i--;
		}
	}
}
