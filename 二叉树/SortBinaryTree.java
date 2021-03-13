public class SortBinaryTree 
{
	public static void main(String[] args) 
	{
		int[] data = {7,3,10,12,5,1,9};
		BinaryTree tree = new BinaryTree();

		for(int i = 0; i < data.length; i++)
		{
			tree.add(new Node(data[i]));		
		}
		tree.midOrder();
		tree.add(new Node(2));
		tree.midOrder();
		
	}
}

class BinaryTree
{
	public Node root;
	
	public void add(Node node)
	{
		if(root == null)
			root = node;
		else
			this.root.add(node);
	}
	
	public void midOrder()
	{
		if(root == null)
		{
			System.out.println("二叉树为空");
		}else
		{
			root.midOut();
		}
	}
}

class Node
{
	public Node left;
	public Node right;

	public int id;

	public Node(int id)
	{
		this.id = id;
	}

	public void outNode()
	{
		System.out.println("id 为: " + this.id);
	}

	public void add(Node node)
	{	
		if(node.id < this.id)
		{
			if(this.left == null)
			{
				this.left = node;
			}else
			{
				this.left.add(node);
			}
		}

		if(node.id > this.id)
		{
			if(this.right == null)
			{
				this.right = node;
			}else
			{
				this.right.add(node);
			}
			
		}

	}

	public void midOut()
	{
		outNode();
		if(this.left != null) {
			this.left.midOut();
		}
		if(this.right != null) {
			this.right.midOut();
		}
	}
}
