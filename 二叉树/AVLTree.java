public class AVLTree
{
	public static void main(String[] args) 
	{
		//int[] data = {4,3,6,5,7,8};
		int[] data = {10,12,8,9,7,6};
		BinaryTree tree = new BinaryTree();

		for(int i = 0; i < data.length; i++)
		{
			tree.add(new Node(data[i]));
		}
		
		tree.midOrder();
		System.out.println("树的高度为 " + tree.getHeight());
		System.out.println("左子树的高度为 " + tree.getLeftHeight());
		System.out.println("右子树的高度为 " + tree.getRightHeight());
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


	public int getHeight()
	{
		if(root == null)
		{
			System.out.println("树为空");
			return 0;
		}

		return root.heightTree();
	}

	public int getLeftHeight()
	{
		if(root == null)
		{
			System.out.println("树为空");
			return 0;
		}

		return root.leftHeight();
	}

	public int getRightHeight()
	{
		if(root == null)
		{
			System.out.println("树为空");
			return 0;
		}

		return root.rightHeight();
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

	
	public void rotateLeftTree()
	{
		//创建一个新节点newNode，值等于当前根节点的值
		Node newNode = new Node(this.id);

		//新节点的左子树，设置为，当前节点的左子树
		newNode.left = this.left;
		
		//新节点的右子树设置为当前节点的右子树的左子树
		newNode.right = this.right.left;

		//当前节点的值换为右子节点的值
		newNode.id = this.right.id;

		//把当前节点的右子树设置为右子树的右子树
		this.right = this.right.right;

		//把当前节点的左子树设置为新节点
		this.left = newNode;

	}

	public void rotateRightTree()
	{
		//创建一个新节点newNode，值等于当前根节点的值
		Node newNode = new Node(this.id);

		//新节点的右子树，设置为，当前节点的右子树
		newNode.right = this.right;
		
		//新节点的左子树设置为当前节点的左子树的右子树
		newNode.left = this.left.right;

		//当前节点的值换为左子节点的值
		newNode.id = this.left.id;

		//把当前节点的左子树设置为左子树的左子树
		this.left = this.left.left;

		//把当前节点的右子树设置为新节点
		this.right = newNode;

	}

	public int leftHeight()
	{
		if(this.left == null)
			return 0;
		return this.left.heightTree();
	}

	public int rightHeight()
	{
		if(this.right == null)
			return 0;
		return this.right.heightTree();
	}

	public int heightTree()
	{
		return Math.max(this.left == null ? 0 : this.left.heightTree(), this.right == null ?  0 : this.right.heightTree()) + 1;
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
		}else if(node.id > this.id)
		{
			if(this.right == null)
			{
				this.right = node;
			}else
			{
				this.right.add(node);
			}	
		}

		//进行左旋操作
		if(this.rightHeight() - this.leftHeight() > 1)
		{
		//右子树的左子树高度大于它的右子树的高度
			if(this.right != null && this.right.leftHeight() > this.right.rightHeight())
			{
				//先对当前节点的y右节点进行右旋操作
				this.right.rotateRightTree();
				//再对当前节点进行左旋操作
				this.rotateLeftTree();
			}
			else
			{
				this.rotateLeftTree();
			}
		}
	
		//进行右旋操作
		if(this.leftHeight() - this.rightHeight() > 1)
		{

			//左子树的右子树高度大于它的左子树的高度
			if(this.left != null && this.left.rightHeight() > this.left.leftHeight())
			{
				//先对当前节点的左节点进行左旋操作
				this.left.rotateLeftTree();
				//再对当前节点进行右旋操作
				this.rotateRightTree();
			}
			else
			{
				this.rotateRightTree();
			}
	
		}

	}

	public void midOut()
	{
		
		if(this.left != null) {
			this.left.midOut();
		}
		outNode();
		if(this.right != null) {
			this.right.midOut();
		}
	}
}
