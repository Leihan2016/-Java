import java.util.*;

public class Linklist 
{
	public static void main(String[] args) 
	{
		//Scanner sc = new Scanner(System.in);
		HeadLink one = new HeadLink("Test1", 10, 89, 3);
		HeadLink two = new HeadLink("Test2", 11, 80, 2);
		HeadLink three = new HeadLink("Test3", 12, 84, 1);
		HeadLink four = new HeadLink("Test4", 13, 83, 1);
		HeadLink five = new HeadLink("Test5", 14, 87, 4);
		HeadLink six = new HeadLink("Test6", 15, 86, 7);

		ManageLink manage = new ManageLink();
		/*manage.addLink(one);
		manage.addLink(two);
		manage.addLink(three);
		manage.addLink(four);
		manage.printLink();  
		manage.deleteLastLink();
		manage.printLink();*/
		manage.addSequence(one);
		manage.addSequence(two);
		manage.addSequence(three );
		manage.addSequence(four);
		manage.addSequence(five);
		manage.addSequence(six);
		manage.printLink();
		manage.deleteLastLink();
		manage.printLink();
		manage.modifyNum( 2, 99, 20 );
		manage.printLink();
		manage.modifyNum( 10, 99, 20 );
		manage.printLink();
		manage.modifyDelete(2);
		manage.printLink();
		manage.numLink();
		ManageLink backManage = linkBack(manage);
		backManage.printLink();
		backManage.backPrintLink();
		
	}

	public static ManageLink linkBack(ManageLink manage)
	{
		
		if(manage.head.next == null || manage.head.next.next == null)
		{
			return null;
		}
		HeadLink manageLinkHead;
		ManageLink backManage = new ManageLink();
		manageLinkHead = manage.head.next;
		HeadLink back = new HeadLink(1);
		HeadLink link = null;
		while(manageLinkHead != null)
		{
			//进行的是中间插入操作
			link = manageLinkHead.next;
			manageLinkHead.next = back.next;
			back.next = manageLinkHead;
			manageLinkHead = link;
		}
		//替换头结点
		backManage.head.next = back.next;
		return backManage;
	}
	
	public static ManageLink backLink(ManageLink manage)
	{
		HeadLink manageLink;
		ManageLink backManage = new ManageLink();
		manageLink = manage.head;
		HeadLink flag = null;
		while(manage.head.next != flag)
		{
			if(manageLink.next != flag)
			{
				manageLink = manageLink.next;
			}else
			{
				backManage.addLink(manageLink);
				flag = manageLink;
				manageLink = manage.head;
			}
		}
		return backManage;
	}

}



class ManageLink
{
	public HeadLink head;
	public  HeadLink last;
	public ManageLink()
	{
		this.head = new HeadLink(1);	
		this.last = this.head;
	}
	//直接添加到队尾，在manage中创建last，从而实现直接添加
	public void addLink(HeadLink headlink)
	{
		if(last.next == null)
		{
			last.next = headlink;
			//原有节点 有之前的链表顺序
			headlink.next = null;
			last = headlink;
			System.out.printf("-------正在添加--------%s\n", headlink.getName());
		}
		
	}
	//按照id编号添加，从小到大，每次添加进行比较，只要大于下一节点，则继续进行遍历，小于下一节点则停止遍历进行添加操作
	public void addSequence(HeadLink headlink)
	{
		HeadLink sequnenceLink;
		HeadLink middleLink;
		sequnenceLink = head;
		
		while(linkIsNull(sequnenceLink))
		{
			middleLink = sequnenceLink.next;//遍历进行
			//大于下一节点，继续遍历
			if(headlink.getId() > middleLink.getId())
			{
				sequnenceLink = middleLink;
				middleLink = sequnenceLink.next;
			}else if(headlink.getId() == middleLink.getId())//等于则失败添加
			{
				System.out.printf("-------重复 添加失败--------%s\n", headlink.getName());
				break;
			} else //小于，进行添加到中间
			{  
				sequnenceLink.next = headlink;
				headlink.next = middleLink;
				System.out.printf("-------正在添加--------%s\n", headlink.getName());
				break;
			}
		}
		if(sequnenceLink.next == null)
		{
			last.next = headlink;
			last = headlink;
			System.out.printf("-------正在添加--------%s\n", headlink.getName());
		}
		
	}

	public void modifyDelete(int id)
	{
		HeadLink deleteLink;
		HeadLink bankLink;
		int flag = 0;
		deleteLink = head;
		bankLink = head;
		while(linkIsNull(deleteLink))
		{
			if(deleteLink.getId() == id)
			{
				System.out.printf("-------正在删除--------id is %s\n",deleteLink.getId());
				flag = 1;
				bankLink.next = deleteLink.next;
				break;
			}
			bankLink = deleteLink;
			deleteLink = deleteLink.next;
		}
		if(flag == 0)
		{
			System.out.println("---------查无此id---------");
		}
	}

	public void modifyNum(int id, int score, int age)
	{
		HeadLink modifyLink;
		modifyLink = head;
		int flag = 0;//判断是否找到
		while(linkIsNull(modifyLink))
		{
			if(modifyLink.getId() == id)
			{
				System.out.printf("-------正在修改--------id is %s\n",modifyLink.getId());
				flag = 1;
				modifyLink.setScore(score);
				modifyLink.setAge(age);
				break;
			}
			modifyLink = modifyLink.next;
		}
		if(flag == 0)
		{
			System.out.println("---------查无此id---------");
		}
	}

	public void deleteLastLink()
	{
		HeadLink linkTest;
		linkTest = head;
		while(linkTest.next != last)
		{
			linkTest = linkTest.next;
		}
		System.out.printf("-------正在删除--------%s\n",last.getName());
		last = linkTest;
		System.out.printf("此时last为%s\n",last.getName());
		last.next = null;
	}

	public void backPrintLink()
	{
		HeadLink linkPrint = head.next;
		Stack<HeadLink> stackLink = new Stack<>();
		System.out.println("-----------倒序打印---------");
		while(linkPrint != null)
		{
			stackLink.add(linkPrint);
			linkPrint = linkPrint.next;
		}
		while(stackLink.size()>0)
		{
			stackLink.pop().display();
		}
	}

	public void printLink()
	{
		HeadLink linkPrint;
		linkPrint = head;
		System.out.println("-------正在打印--------");
		while(linkIsNull(linkPrint))
		{
			//System.out.printf("name is %s:\n", linkPrint.getName());
			linkPrint.display();
			linkPrint = linkPrint.next;
		}
		//System.out.printf("name is: %s ,socre is: %d ,age is: %d ,id is: %d", linkPrint.getName());
		linkPrint.display();
	}  

	public void numLink()
	{
		HeadLink num;
		num = head;
		int result = 0;
		while(linkIsNull(num))
		{
			result = result+1;
			num = num.next;
		}
		System.out.printf("---------现有数据%d----------\n", result);
	}

	public boolean linkIsNull(HeadLink link)
	{
		return link.next != null;
	}

}

class HeadLink
{
	private String name;
	private int age;
	private int score;
	private int id;
	public HeadLink next;

	public HeadLink(int id)
	{
		this.id = id;
	}
	public HeadLink(String name, int age, int score, int id)
	{
		this.name = name;
		this.age = age;
		this.score = score;
		this.id = id;
	}
	public void display()
	{
		System.out.printf("name = %s ,age = %d ,score = %d , id = %d\n", name, age, score,id);
	}

	public String getName()
	{
		return this.name;
	}

	public int getId()
	{
		return id;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}