import java.util.*;

public class SparseArry 
{
	public static void main(String[] args) 
	{
		int width = 4;
		int height = 4;
		int[][] arr = new int[width][height];
		//初始化数组，置零
		for(int i = 0 ; i < height ; i++)
		{
			for (int j = 0; j < width ; j++)
			{
				arr[i][j] = 0;
			}
		}
		//数组赋值
		System.out.println("请输入数组行和列，以及相应的值，输入q离开");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			if(sc.hasNextInt())
			{
				int i = sc.nextInt();
				int j = sc.nextInt();
				int num = sc.nextInt();
				arr[i][j] = num;
			}else
				break;
		}
		System.out.println("\n输入完成");
		out(arr,width,height);
		int num = num(arr,width,height);
		int[][] sparse = sparse(arr , num , width , height);
		out(sparse,3,num+1);
		System.out.println();
		int[][] unsparse = unSparse(sparse);
		System.out.println();
		out(unsparse,sparse[0][0],sparse[0][1]);
	}
	public static void out(int[][] arr, int width , int height)
	{
		for(int i = 0 ; i < height ; i++)
		{
			for (int j = 0; j <width ; j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

	/* 1.通过稀疏数组前三个值创建原数组，并赋值
	   2.单层便利稀疏数组完成赋值
	   */
	public static int[][] unSparse(int[][] sparse)
	{
		int width = sparse[0][0];
		int height = sparse[0][1];
		int[][] unArr = new int[width][height];
		for(int i = 0 ; i < height ; i++)
		{
			for (int j = 0; j < width ; j++)
			{
				unArr[i][j] = 0;
			}
		}
		System.out.println("已执行");
		int num = sparse[0][2]+1;
		for(int i = 1 ; i < num ; i++)
		{
				int a = sparse[i][0];
				int b = sparse[i][1];
				int re = sparse[i][2];
				System.out.print("已执行："+a+" "+b+" "+re);
				unArr[a][b] = re;
		}
		return unArr;

	}

		/* 1.函数num统计有效值的个数
		   2.声明稀疏数组
		   3.将有效值给稀疏数组赋值*/
	public static int[][] sparse(int[][] arr, int num ,int width ,int height)
	{
		int[][] sparse = new int[num+1][3];
		sparse[0][0] = width;
		sparse[0][1] = height;
		sparse[0][2] = num;
		int flag = 1;
		for(int i = 0 ; i < height ; i++)
		{
			for (int j = 0; j <width ; j++)
			{
				if(arr[i][j] != 0)
				{
					sparse[flag][0] = i;
					sparse[flag][1] = j;
					sparse[flag][2] = arr[i][j];
					flag = flag + 1;
				}
			}
			System.out.println();
		}
		return sparse;
	}

	public static int num(int[][] arr, int width , int height)
	{
		int num = 0;
		for(int i = 0 ; i < height ; i++)
		{
			for (int j = 0; j <width ; j++)
			{
				if(arr[i][j] != 0)
				num++;
				
			}
			System.out.println();
		}
		System.out.println(num);
		return num;
	}
}

/*for(int[] row: chessArr)
{
	for(int data: row)
	{
		System.out.println("%d\t", data);
	}
}*/