import java.util.*;

public class KeLuSi
{
	//保存节点名称
	public char[] name;
	//传入节点个数
	public int vertx;
	//节点间权重矩阵
	public int[][] matrix;
	
	private static final int INF = Integer.MAX_VALUE;
	

	//统计并保存有权重边个数
	public ArrayList<ENode> eNode = new ArrayList<>();

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		char[] name = {'A','B','C','D','E','F','G'};
		int vertx = 7;
		int matrix[][] = {
	      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	/*A*/ {   0,  12, INF, INF, INF,  16,  14},
	/*B*/ {  12,   0,  10, INF, INF,   7, INF},
	/*C*/ { INF,  10,   0,   3,   5,   6, INF},
	/*D*/ { INF, INF,   3,   0,   4, INF, INF},
	/*E*/ { INF, INF,   5,   4,   0,   2,   8},
	/*F*/ {  16,   7,   6, INF,   2,   0,   9},
	/*G*/ {  14, INF, INF, INF,   8,   9,   0}}; 
		
		KeLuSi kelusi = new KeLuSi(vertx, name, matrix);
		kelusi.outPrint();
		int numOfEdge = kelusi.numWeight();
		System.out.println("共有边：" + numOfEdge);
		kelusi.sortMaopao();
		//kelusi.outPaixu();
		kelusi.keLusi();
		
	}

	public KeLuSi(int vertx, char[] name, int[][] matrix)
	{
		this.vertx = vertx;
		this.name = name;
		this.matrix = matrix;
	}

	public void keLusi()
	{
		int[] ends = new int[vertx];
		ArrayList<ENode> ret = new ArrayList<>();
		int size = eNode.size();

		for(int i = 0; i < size; i++)
		{
			ENode temp = eNode.get(i);
			int p1 = findPosition(temp.begin);
			int p2 = findPosition(temp.end);

			int end1 = backPosition(ends, p1);
			int end2 = backPosition(ends, p2);
			
			if(end1 != end2)
			{
				ret.add(eNode.get(i));
				//ends[p1] = p2;

				ends[end1] = end2;
			}
		}
		System.out.println("权值最小: ");
		int sizeRet = ret.size();
		for(int i = 0; i < sizeRet; i++)
		{
			ret.get(i).out();
		}
	}


	//统计权重边个数
	public int numWeight()
	{
		for(int i = 0; i < vertx; i++)
		{
			for(int j = i+1; j < vertx; j++)
			{
				if(matrix[i][j] < INF)
				{
					eNode.add(new ENode(name[i], name[j], matrix[i][j]));
				}
			}
		}
		return eNode.size();
	}
	
	//对有效权重边进行排序
	public void sortMaopao()
	{
		int size = eNode.size();
		for(int i = 0; i < size - 1; i++)
		{
			for(int j = 0; j < size - 1 - i; j++)
			{
				if(eNode.get(j).weight > eNode.get(j+1).weight)
				{
					ENode temp = eNode.get(j);
					//eNode.get(j) = eNode.get(j + 1);
					//eNode.get(j + 1) = temp;
					eNode.set(j, eNode.get(j + 1));
					eNode.set(j+1, temp);
				}
			}
		}
	}
	
	//根据节点名称 ch查找在数组中的位置
	public int findPosition(char ch)
	{
		for (int i = 0; i < vertx; i++)
		{
			if(ch == name[i])
			{
				return i;
			}
		}
		return -1;
	}

	public int backPosition(int[] ends, int i)
	{
		//这里i为出发节点，ends[i]为尾结点，挨个遍历
		while(ends[i] != 0)
		{
			//将尾结点赋给头结点继续查找
			i = ends[i];
		}

		return i;
	}

	public void outPaixu()
	{
		int size = eNode.size();
		for(int i = 0; i < size; i++)
		{
			eNode.get(i).out();
		}
	}	
	
	//输出一下权重矩阵
	public void outPrint()
	{
		for(int i = 0; i < vertx; i++)
		{
			for(int j = 0; j < vertx; j++)
			{
				System.out.printf("%10d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

	
}

class ENode
{
	public char begin;
	public char end;

	public int weight;

	public ENode(char begin, char end, int weight)
	{
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}

	public void out()
	{
		System.out.printf("%c ---- %c ----- %d\n", begin, end, weight);
	}
}
