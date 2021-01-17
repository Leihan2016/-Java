public class OneWayLinkList  
{
	public static void main(String[] args) 
	{
		NodeOneWay one = new NodeOneWay("Test1", 1);
		NodeOneWay two = new NodeOneWay("Test2", 2);
		NodeOneWay three = new NodeOneWay("Test3", 3);
		NodeOneWay four = new NodeOneWay("Test4", 4);
		NodeOneWay five = new NodeOneWay("Test5", 5);
		NodeOneWay six = new NodeOneWay("Test6", 6);

		NodeManage manage = new NodeManage(5, 2);
		manage.nodeAdd(one);
		manage.nodeAdd(two);
		manage.nodeAdd(three);
		manage.nodeAdd(four);
		manage.nodeAdd(five);
		manage.nodeAdd(six);

		manage.disPlayOneWay();
		//manage.outLink();
	    manage.outLinkList(1);
	}
}

class NodeManage
{
	private int n;//环形链表大小
	private int m;//环形链表步进
	private int now = 0;//环形链表当前游标
	private NodeOneWay head;
	public NodeManage(int n, int m)
	{
		this.n = n;
		this.m = m;
	}

	public void nodeAdd(NodeOneWay temp)
	{
		NodeOneWay headTemp = head;
		if(now == n)
		{
			System.out.println("------链表已满-------");
			return;
		}
	
		//添加头结点
		if(head == null)
		{
			head = temp;
			now++;
			System.out.printf("------已经添加-------%s\n", temp.getName());
			return;
		}
		while(true)
		{
			if(headTemp.next != null)
			{
				headTemp = headTemp.next;
			}else
			{
				headTemp.next = temp;
				now++;
				System.out.printf("------已经添加-------%s\n", temp.getName());
				if(now == 5)
				{
					temp.next = head;
				}
				break;
			}
			
		}
		
	}

	public void disPlayOneWay()
	{
		NodeOneWay headTemp = head;
		while(true)
		{
			//循环遍历，当头结点与尾结点的下一节点相等，则遍历完成
			if(headTemp.next == head)
			{
				//显示最后一个节点
				headTemp.disPlayNode();
				break;
			}else
			{
				headTemp.disPlayNode();
				headTemp = headTemp.next;
			}
		}
	}
	
	//num为起始点
	public void outLinkList(int num)
	{
		NodeOneWay temp = head;
		NodeOneWay tempBack = head.next;
		//移动到起始点
		for(int i = 1; i < num; i++)
		{
			tempBack = temp;
			temp = temp.next;
		}

		while(true)
		{
			for(int i = 1; i < m; i++)
			{
				tempBack = temp;
				temp = temp.next;
			}
			if(tempBack == temp)
			{
				System.out.printf("------已经删除-------%s\n", temp.getName());
				break;
			}
			tempBack.next = temp.next;
			System.out.printf("------已经删除-------%s\n", temp.getName());
			temp = temp.next;
		}

	}


	public void outLink()
	{
		NodeOneWay headTemp = head;
		NodeOneWay tempBack = head.next;
		int num = 0;//标记目前在哪个节点,从头到尾
		int flag = 0;//标记删除节点的上一个节点
		while(true)
		{
			num++;
			if(num < flag + m)
			{
				tempBack = headTemp;
				headTemp = headTemp.next;
			}else
			{
				tempBack.next = headTemp.next;
				System.out.printf("------已经删除-------%s\n", headTemp.getName());
				headTemp = headTemp.next;
				flag = num;
			}
			if(tempBack == headTemp)
			{
				System.out.printf("------已经删除-------%s\n", headTemp.getName());
				break;
			}
		}
	}
}

class NodeOneWay
{
	public NodeOneWay next;
	private int Id;
	private String name;

	public NodeOneWay(String name, int Id)
	{
		this.name = name;
		this.Id = Id;
	}

	public void disPlayNode()
	{
		System.out.printf("name = %s , Id = %d \n", name, Id);
	}

	public int getId()
	{
		return Id;
	}

	public String getName()
	{
		return name;
	}
}
 