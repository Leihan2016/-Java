public class PuLiMu
{
	public static void main(String[] args) 
	{
		MinGraph minGraph = new MinGraph();
		int[][] weight = {
							{10000,5,7,10000,10000,10000,2}, 
							{5,10000,10000,9,10000,10000,3},
							{7,10000,10000,10000,8,10000,10000},
							{10000,9,10000,10000,10000,4,10000},
							{10000,10000,8,10000,10000,5,4},
							{10000,10000,10000,4,5,10000,6},
							{2,3,10000,10000,4,6,10000}
						};
		minGraph.init(7, weight);
		minGraph.outGraph();

		minGraph.prime(1);

	}
}

class MinGraph
{
	public Graph graph;

	public void init(int verx, int[][] weight)
	{
		graph = new Graph(verx);
		for(int i = 0; i < verx; i++)
		{
			for(int j = 0; j < verx; j++)
			{
				graph.weight[i][j] = weight[i][j];
			}
		}
	}

	public void prime(int begin)
	{
		int size = graph.verx;
		int[] visited = new int[size];

		int h = begin;
		int l = 0;

		visited[h] = 1;
		
		int min = 10000;

		for(int k = 1; k < size; k++)
		{
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < min)
					{
						h = i;
						l = j;
						min = graph.weight[i][j];
					}
				}	
			}
			min = 10000;
			visited[l] = 1;
			System.out.println("From " + graph.data[h] + " to " + graph.data[l]);
		}
	}

	public void outGraph()
	{
		for(int[] temp: graph.weight)
		{
			for(int i = 0, size = temp.length; i < size; i++)
			{
				System.out.printf("%d\t", temp[i]);
			}
			System.out.println();
		}	
	}

}

class Graph
{
	//记录节点个数
	public int verx;
	//记录节点名称
	public char[] data = {'A','B','C','D','E','F','G'};
	//记录节点权重
	public int[][] weight;

	public Graph(int verx)
	{
		this.verx = verx;
		weight = new int[verx][verx];
	}

}
