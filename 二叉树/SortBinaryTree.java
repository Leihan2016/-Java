public class SortBinaryTree 
{
	public static void main(String[] args) 
	{
		int[] data = {7,3,10,12,5,1,9};
		BinaryTree tree = new BinaryTree();
		
		//遍历添加
		for(int i = 0; i < data.length; i++)
		{
			tree.add(new Node(data[i]));		
		}
		//中序遍历输出
		tree.midOrder();
		tree.add(new Node(2));
		tree.midOrder();

		Node searchRe = tree.search(2);
		System.out.println("找到节点 -------------"  + searchRe.id);
		Node parent = tree.searchParent(searchRe);
		System.out.println(searchRe.id + " 的父节点 -------------" + parent.id);
		
		tree.delete(2);
		tree.delete(5);

		tree.delete(9);
		tree.delete(12);
		tree.delete(7);
		tree.delete(3);
		tree.delete(10);
		tree.delete(1);
		tree.midOrder();

	}

	
}

class BinaryTree
{
	public Node root;
	//加入节点，root为空，则将输入节点置为 root = node
	public void add(Node node)
	{
		System.out.println();
		if(root == null)
		{
			System.out.println("添加 -------------" + node.id);
			root = node;
		}
		else
		{
			System.out.println("添加 -------------" + node.id);
			this.root.add(node);
		}
	}

	public void delete(int id)
	{
		System.out.println();
		System.out.println("开始删除");
		
		Node deNode = search(id);
		//删除节点不存在
		if(deNode == null)
		{
			System.out.println("删除节点不存在");
			return ;
		}

		Node parent = searchParent(deNode);

		
		//只有一个节点
		if(root.left == null && root.right == null)
		{
			System.out.println("删除节点为：" + root.id);
			root = null;
			return;
		}
		
		//为叶子节点
		if(deNode.left == null && deNode.right == null)
		{
			if(parent.left != null && parent.left.id == id)
			{
				parent.left = null;
			}else if(parent.right != null && parent.right.id == id)
			{
				parent.right = null;
			}
			System.out.println("删除节点为：" + id);
			//root.delete(node);
		}else if(deNode.left != null && deNode.right != null)
		{
			deNode.id = findMinRight(deNode);
		}else if(deNode.left != null)//目标拥有一颗左子树
		{
			if(parent != null)
			{
				if(parent.left.id == id)//目标在父节点的左侧
				{
					parent.left = deNode.left;
				}else if(parent.right.id == id)//目标在父节点的右侧
				{
					parent.right = deNode.left;
				}
			}else
			{
				root = deNode.left;
			}
		}else if(deNode.right != null)//目标拥有一颗右子树
		{
			if(parent != null)
			{
				if(parent.left.id == id)//目标在父节点的左侧
				{
					parent.left = deNode.right;
				}else if(parent.right.id == id)
				{
					parent.right = deNode.right;//目标在父节点的右侧
				}
			}else
			{
				root = deNode.right;
			}
		}
	}

	//寻找节点node 的父节点 
	public Node searchParent(Node node)
	{
		if(node == root)
		{
			System.out.println("节点为根节点");
			return null;
		}else
		{
			return root.searchParent(node);
		}
	}
	
	//查找删除节点
	public Node search(int id)
	{
		if(root.id == id)
			return root;
		else
			return root.search(id);
	}

	public int findMinRight(Node node)
	{
		int temp;
		node = node.right;
		while(node.left != null)
		{
			node = node.left;
		}
		temp = node.id;
		delete(temp);
		return temp;
		
	}

	
	//中序遍历
	public void midOrder()
	{
		System.out.println();
		if(root == null)
		{
			System.out.println("二叉树为空");
		}else
		{
			System.out.println("二叉排序树-中序遍历为：");
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

	
	public void delete(Node node)
	{
		//首先判断向左 向右遍历，然后再看左节点或右节点是否等于寻找的值
		if(node.id < this.id && this.left != null)
		{
			if(node.id == this.left.id)
			{
				System.out.println("删除节点为：" + node.id );
				this.left = null;
			}else{
				this.left.delete(node);
			}
		}else if(node.id > this.id && this.right != null)
		{
			if(node.id == this.right.id)
			{
				System.out.println("删除节点为：" + node.id );
				this.right = null;
			}else{
				this.right.delete(node);
			}
		}
	}
	
	//查找节点的父节点
	public Node searchParent(Node node)
	{
		//首先判断向左 向右遍历，然后再看左节点或右节点是否等于寻找的值
		if(node.id < this.id && this.left != null)
		{
			if(node.id == this.left.id)
			{
				return this;
			}else{
				return this.left.searchParent(node);
			}
		}else if(node.id > this.id && this.right != null)
		{
			if(node.id == this.right.id)
			{
				return this;
			}else{
				return this.right.searchParent(node);
			}
		}else 
		{
			return null;	
		}
	}
		
	//查找删除节点
	public Node search(int id)
	{
		if(this.id == id)
		{
			return this;
		}else if(id < this.id && this.left != null)
		{
			return this.left.search(id);

		}else if(id > this.id && this.right != null)
		{
			return this.right.search(id);
		}else
		{
			System.out.println("无此节点");
			return null;
		}
	}
	

	
	//如果node.id小于当前值，则向左遍历，直到为空
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
