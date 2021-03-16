import java.util.*;

public class Graph
{
	public static void main(String[] args) 
	{
		String[] nameArray = {"A","B","C","D","E"};
		GraphTest test = new GraphTest(5);

		for(String name : nameArray)
		{
			test.addString(name);
		}

		test.addGraph(0,1,1);
		test.addGraph(1,2,1);
		test.addGraph(0,2,1);

		test.addGraph(1,3,1);
		test.addGraph(1,4,1);

		test.outPrint();
		test.dfs();


	}
}

class GraphTest
{
	//存储节点名称
	public ArrayList<String> list;
	//存储节点间关系
	public int[][] graph;
	//一共有多少条边
	public int nums;
	//存储是否被访问
	public boolean[] isOut;

	public GraphTest(int n)
	{
		graph = new int[n][n];
		list = new ArrayList<>(n);
		nums = 0;
		isOut = new boolean[n];
	}
	
	//初始化，默认没有被访问
	public void initIsOut()
	{
		for(int i = 0; i < list.size(); i++)
		{
			isOut[i] = false;
		}
	}

	//得到第一个邻节点的下标
	public int findFirst(int node)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(graph[node][i] != 0)
				return i;
		}

		return -1;
	}


	//得到back，起点为start+1 下一个节点
	public int findNext(int back, int start)
	{
		for(int i = start + 1; i < list.size(); i++)
		{
			if(graph[back][i] != 0)
				return i;
		}

		return -1;
	}
	

	public void dfs()
	{
		initIsOut();
		for(int i = 0; i < list.size(); i++)
		{
			if(!isOut[i])
			{
				dfs(i);
			}
			
		}
	}

	//对一个节点进行深度遍历
	public void dfs(int node)
	{
		System.out.printf("%s -> ", list.get(node));
		isOut[node] = true;
		
		//2. 查找节点node 的第一个邻节点
		int temp = findFirst(node);
		//3.w---temp存在继续执行
		while(temp != -1)
		{
			//4.w---temp未被访问
			if(!isOut[temp])
			{	
				//对w---temp进行深度遍历
				dfs(temp);
			}else
			{	//查找当前的另一个连接节点的邻节点是否存在
				temp = findNext(node, temp);
			}
		}
		
	}

	public void addGraph(int A, int B, int re)
	{
		graph[A][B] = re;
		graph[B][A] = re;
		nums++;
	}

	public void addString(String name)
	{
		System.out.println("添加" + name);
		list.add(name);
	}

	//输出存储节点关系的二维数组
	public void outPrint()
	{
		int i = 0;
		System.out.printf("  ");
		for(int k = 0; k < list.size(); k++)
		{
			System.out.printf("%s ", list.get(k));
		}
		System.out.println();
		for(int[] temp : graph)
		{
			System.out.printf("%s ", list.get(i));
			i++;
			for(int re : temp)
			{
				System.out.printf("%d ", re);
			}
			System.out.println();
		}
	}
}
