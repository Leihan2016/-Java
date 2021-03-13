import java.util.*;

public class Compress 
{
	public static void main(String[] args) 
	{
		comPress("hhellloooo");
	}

	public static void comPress(String str)
	{
		int size = str.length();
		int temp;
		int re;
		
		//用于统计各个字符出现的次数  key为字符，value 为次数
		HashMap<Integer,Integer> hashMap = new HashMap<>();

		for(int i = 0; i < size; i++)
		{
			//获取字符串中的字符
			temp = (int)str.charAt(i);
			//如果Map中含有key -- temp 则给它的Value加1，否则，将其加入key中，并设Value值为1
			if(hashMap.containsKey(temp))
			{
				hashMap.put(temp, hashMap.get(temp) + 1);
			}else
			{
				hashMap.put(temp, 1);
			}
		}
		//完成哈夫曼编码，并返回根节点
		Node root = huffMan(hashMap);
		//前序遍历
		preOrder(root);
		//栈用来保存每一步的0 1
		Stack<Integer> stack = new Stack<>();
		root.findValue(108, stack);

		HashMap<Integer,StringBuffer> hash = new HashMap<>();
		StringBuffer value = new  StringBuffer();
		findChar(hash, "", root, value);

		for(Integer key : hash.keySet()) 
           System.out.println("key为：" + key + "编码：" + hash.get(key));

		StringBuffer out = new  StringBuffer();

		int charTemp;
		for(int i = 0; i < size; i++)
		{
			charTemp = (int)str.charAt(i);
			out.append(hash.get(charTemp));
		}

		System.out.println("编码后输出为：" + out);

	}


	public static void preOrder(Node root)
	{
		if(root != null)
		{
			root.preOrder();
			System.out.println("preOrder");
		}else
			System.out.println("根节点为空");
	}

	public static void findChar(HashMap<Integer,StringBuffer> hash, String code, Node node, StringBuffer value)
	{
		//新建temp ，保存编码值
		StringBuffer temp = new StringBuffer(value);
		//追加本次的 0 1 值
		temp.append(code);
		if(node == null)
		{
			return;
		}
		if(node.re == -1)
		{
			findChar(hash, "0", node.left, temp);
			findChar(hash, "1", node.right, temp);
		}else
		{
			//到叶子节点后，进入Map
			hash.put(node.re, temp);
		}
	}


	public static Node huffMan(HashMap<Integer,Integer> hashMap)
	{

		List<Node> list = new ArrayList<>();

		for(Integer key: hashMap.keySet())
		{
			list.add(new Node(key, hashMap.get(key)));
		}
		while(list.size() > 1)
		{
			Collections.sort(list);

			Node left = list.get(0);
			Node right = list.get(1);

			Node father = new Node(-1, left.times+right.times);
			
			father.left = left;
			father.right = right;

			list.remove(left);
			list.remove(right);

			list.add(father);
			System.out.println(list.size());
		}

		return list.get(0);
	}
}

class Node implements Comparable<Node>
{
	public Node left;
	public Node right;
	public int re;
	public int times;

	
	public Node(int re, int times)
	{
		this.re = re;
		this.times = times;
	}

	public int compareTo(Node o)
	{
		return (this.times - o.times);
	}

	public void printNode()
	{
		System.out.println("字符为：" + re + "出现次数为：" + times);
	}

	public void preOrder()
	{
		//System.out.println("执行");
		printNode();
		if(this.left != null)
		{
			this.left.preOrder();
		}
		if(this.right != null)
		{
			this.right.preOrder();
		}
	}

	public boolean findValue(int value, Stack<Integer> stack)
	{
		
		if(this.re == value) {
			System.out.println("find it" + value);
			while(!stack.empty())
			{
				System.out.println(stack.pop());
			}
			return true;
		}

		if(this.left != null)
		{
			stack.push(0);
			if(this.left.findValue(value, stack))
			{
				return true;
			}else if(!stack.empty())
			{
				stack.pop();
			}
		}
		if(this.right != null)
		{
			stack.push(1);
			if(this.right.findValue(value, stack))
			{
				return true;
			}else if(!stack.empty())
			{
				stack.pop();
			}
		}
		return false;
	}

}
