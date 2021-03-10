import java.util.*;


public class HaFuMan 
{
	public static void main(String[] args) 
	{
		int[] data = {13,7,8,3,29,6,1};
		MaoPao(data);
		
		System.out.println(Arrays.toString(data));

		preOrder(haFuMan(data));
		
		//排序后  1 2 3 4 5 6 7 8 9 

	}
	//静态方法 用来前序遍历哈夫曼树
	public static void preOrder(Node root)
	{
		//只要根节点不为空，就调用Node中的前序遍历方法 实现递归调用遍历
		if(root != null)
		{
			root.preOrder();
		}
	}

	public static Node haFuMan(int data[])
	{
		//创建list,便于节点的删除添加
		List<Node> list = new ArrayList<>();
		
		//创建数据节点，并将节点添加进list
		for(int i = 0; i < data.length; i++)
		{
			list.add(new Node(data[i]));
		}
	
		//只要list中数据多于一个，就执行
		while(list.size() > 1)
		{
			//每次执行都需要调用sort进行排序--------------要实现排序，需要实现Comparable接口中的compareTo(Object o)方法
			Collections.sort(list);
			
			//取出list中的前两个 最小的数据，作为左节点和右节点
			Node left = list.get(0);
			Node right = list.get(1);
			
			//创建left与right 的父节点
			int temp = left.id+ right.id;
			Node father = new Node(temp);
			
			//将父节点的子节点指向left和right
			father.left = left;	
			father.right = right;
			
			//叶子节点完成使命，退出
			list.remove(left);
			list.remove(right);
			
			//将父节点加入list
			list.add(father);
		}
		//返回根节点
		return list.get(0);
	}

	public static void MaoPao(int data[])
	{
		int size = data.length;
		int temp = 0;
		for(int i = 0; i < size - 1; i++)
		{

			for(int j = 0; j < size - 1 - i; j++)
			{
				if(data[j] > data[j+1])
				{
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
}

class Node implements Comparable<Node>
{
	public int id;
	public Node left;
	public Node right;

	public Node(int id)
	{
		this.id = id;
	}


	//实现的Comparable类中的compareTo方法
	public int compareTo(Node o)
	{
		//从小到大排序
		return (this.id - o.id);
	}

	//递归的前序遍历
	public void preOrder()
	{
		System.out.println(this.id);
		if(this.left != null)
		{
			this.left.preOrder();
		}
		if(this.right != null)
		{
			this.right.preOrder();
		}
	}
}
