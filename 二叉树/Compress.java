import java.util.*;

public class Compress 
{
	public static void main(String[] args) 
	{
		comPress("Hhellloooo");
	}

	public static void comPress(String str)
	{
		int size = str.length();
		int temp;
		int re;

		HashMap<Integer,Integer> hashMap = new HashMap<>();

		for(int i = 0; i < size; i++)
		{
			temp = (int)str.charAt(i);
			if(hashMap.containsKey​(temp))
			{
				hashMap.put(temp, hashMap.get(temp) + 1);
			}else
			{
				hashMap.put(temp, 1);
			}
		}

		//for(Integer key : hashMap.keySet()) {
        //   System.out.println("key为：" + key + "统计次数为：" + hashMap.get(key));
        //}
		preOrder(huffMan(hashMap));


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


	public static Node huffMan(HashMap<Integer,Integer> hashMap)
	{
		List<Node> list = new ArrayList<>();

		for(Integer key: hashMap.keySet())
		{
			list.add(new Node(key, hashMap.get(key)));
		}
		/*
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).printNode();
		}
		*/
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

	public int findValue(int value)
	{
		if(this.re == value)
			return 0;
		if(this.left != null)
		{
			return this.left.findValue(value);
		}
		if(this.right != null)
		{
			return this.right.findValue(value);
		}
			return -1;
	}

}
