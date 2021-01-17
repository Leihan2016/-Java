
public class LinkListWay 
{
	public static void main(String[] args) 
	{
		LinkNode one = new LinkNode("Test1", 10, 89, 3);
		LinkNode two = new LinkNode("Test2", 11, 80, 2);
		LinkNode three = new LinkNode("Test3", 12, 84, 1);
		LinkNode four = new LinkNode("Test4", 13, 83, 1);
		LinkNode five = new LinkNode("Test5", 14, 87, 4);
		LinkNode six = new LinkNode("Test6", 15, 86, 7);

		ManageLink manage = new ManageLink();
		manage.addSquence(one);
		manage.addSquence(two);
		manage.addSquence(three);
		manage.addSquence(four);
		manage.addSquence(five);
		manage.addSquence(six);

		manage.disPlayLink();

		manage.deleteLink(7);
		manage.disPlayLink();

		manage.modifyLink(3, 100);
		manage.disPlayLink();

	}
}
class ManageLink
{
	private LinkNode linkHead;
	public ManageLink()
	{
		this.linkHead = new LinkNode("head", 0);
	}

	//添加 1、添加到最后
	public void addLink(LinkNode linkNode)
	{
		LinkNode temp = linkHead;
		while(true)
		{
			if(temp.next == null)
			{
				System.out.printf("----------正在添加----------%s\n", linkNode.getName());
				temp.next = linkNode;
				linkNode.pre = temp;
				break;
			}
			temp = temp.next;
		}
	}
	//添加 2、顺序添加 从小到大
	public void addSquence(LinkNode linkNode)
	{
		LinkNode temp = linkHead;
		
		while(temp != null)
		{
			if(linkNode.getId() > temp.getId())
			{
				if(temp.next == null)
				{
					temp.next = linkNode;
					linkNode.pre = temp;
					System.out.printf("----------正在添加----------%s\n", linkNode.getName());
					return ;
				}else
					temp = temp.next;
			}else if(linkNode.getId() == temp.getId())
			{
				System.out.println("----------已有此ID----------");
				return;
			}else
			{
				temp.pre.next = linkNode;
				linkNode.next = temp;
				linkNode.pre = temp.pre;
				temp.pre = linkNode;
				System.out.printf("----------正在添加----------%s\n", linkNode.getName());
				return ;
			}
		}
		/*temp.next = linkNode;
		linkNode.pre = temp;
		System.out.printf("----------正在添加----------%s\n", linkNode.getName());*/
	}
	
	public void disPlayLink()
	{
		LinkNode temp = linkHead.next;
		while(true)
		{
			if(temp != null)
			{
				temp.disPlay();
			}else
			{
				break;
			}
			temp = temp.next;
		}
	}

	public void deleteLink(int id)
	{
		LinkNode temp = linkHead.next;
		while(temp != null)
		{
			if(temp.getId() == id)
			{
				if(temp.next == null)
				{
					temp.pre.next = null;
					System.out.printf("----------正在删除----------%s\n", temp.getName());
					return;
				}else
				{
					temp.pre.next = temp.next;
					temp.next.pre = temp.pre;
					System.out.printf("----------正在删除----------%s\n", temp.getName());
					break;
				}
				
			}
			temp = temp.next;
		}
		if(temp == null)
		{
			System.out.printf("----------无此ID号----------%d\n", id);
		}
	}

	public void modifyLink(int id, int score)
	{
		LinkNode temp = linkHead.next;
		while(temp != null)
		{
			if(temp.getId() == id)
			{
				temp.setScore(score);
				System.out.printf("----------正在修改----------%s\n", temp.getName());
				break;
			}
			temp = temp.next;
		}
		if(temp == null)
		{
			System.out.printf("----------无此ID号----------%d\n", id);
		}
	}


}
class LinkNode
{
	private String name;
	private int age;
	private int score;
	private int id;
	
	public LinkNode next;
	public LinkNode pre;
	//头结点构造器
	public LinkNode(String name,int id)
	{
		this.name = name;
		this.id = id;
	}
	//正常节点构造器
	public LinkNode(String name, int age, int score, int id)
	{
		this.name = name;
		this.age = age;
		this.score = score;
		this.id = id;
	}

	public void disPlay()
	{
		System.out.printf("name = %s ,age = %d ,score = %d , id = %d\n", name, age, score,id);
	}

	public String getName()
	{
		return this.name;
	}

	public int getId()
	{
		return this.id;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
}
 
