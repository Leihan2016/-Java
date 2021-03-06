import java.util.Arrays;
public class BinaryTree 
{
	public static void main(String[] args) 
	{
		int[] data = {1,3,6,8,10,14};
		ArrBinaryTree tree = new ArrBinaryTree(data);
		System.out.println("前序遍历");
		tree.preOrder(0);
		System.out.println("中序遍历");
		tree.midOrder(0);
		System.out.println(Arrays.toString(tree.out));
		System.out.println("后序遍历");
		tree.lastOrder(0);
	}
}

class ArrBinaryTree
{

	private int pre = 0;
	private int mid = 0;
	private int last = 0;

	public int[] out;

	private int[] data;
	public ArrBinaryTree(int[] data)
	{
		this.data = data;
		int size = data.length;
		this.out = new int[size];
		
	}

	public void preOrder(int index)
	{
		if(data == null || data.length == 0)
		{
			return ;	
		}

		System.out.println(data[index]);
		
		int left = 2*index + 1;
		int right = 2*index + 2;
		if(left < data.length)
		{
			preOrder(left);
		}
		
		if(right < data.length)
		{
			preOrder(right);
		}
	}

	public void midOrder(int index)
	{
		if(data == null || data.length == 0)
		{
			return ;	
		}

		int left = 2*index + 1;
		int right = 2*index + 2;
		if(left < data.length)
		{
			midOrder(left);
		}
		
		System.out.println(data[index]);
		out[mid] = data[index];
		mid++;

		if(right < data.length)
		{
			midOrder(right);
		}
	}

	public void lastOrder(int index)
	{
		if(data == null || data.length == 0)
		{
			return ;	
		}

		int left = 2*index + 1;
		int right = 2*index + 2;
		if(left < data.length)
		{
			lastOrder(left);
		}

		if(right < data.length)
		{
			lastOrder(right);
		}

		System.out.println(data[index]);
		
	}

	public void logicTree()
	{
		
	}

}
