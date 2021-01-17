public class QueenNum
{
	//1.以存储的数据量来判断是否队满
	//2.存储量num = (rear - 1 - front + MaxSize) % MaxSize ;在出队后需要更新
	private int MaxSize;
	private int front;
	private int rear;
	private int[] queen;
	private int num;
	public QueenNum(int MaxSize)
	{
		this.MaxSize = MaxSize;
		this.front = 0;//队列第一个元素
		this.rear = 0;//队列中最后的后一个元素
		queen = new int[MaxSize];

	}
	//入队
	public void addQueen(int result)
	{
		System.out.println("----------入队----------");
		System.out.printf("添加result = %d ，此时rear的值为%d\n", result , rear);
		//判断队列是否满
		//if((rear - front + MaxSize) % MaxSize < MaxSize)

		if(num < MaxSize-1)
		{
			
			queen[rear] = result;
			rear = (rear+1) % MaxSize;
			num = (rear - 1 - front + MaxSize) % MaxSize ;
			System.out.printf("此时存储的值有%d\n", num+1);
			
		}else
		{
			System.out.println("队列满");
		}
	}
	//出队
	public int outQueen()
	{
		int result;
		front = front % MaxSize;
		System.out.println("----------出队----------");
		if(rear-1 != front)
		{
			result = queen[front];
			front = (front+1)%MaxSize;
			num = (rear - 1 - front + MaxSize) % MaxSize ;
			System.out.printf("此时出队的值为%d\n", result);
			System.out.printf("此时存储的值有%d\n", num+1);
		}else
		{
			throw new RuntimeException("队列空");
		}
		return result;
	}
	//显示队列
	public void displayQueen()
	{
		for(int i = front; i < num+1+front; i++)
		{
			System.out.printf("%d ", queen[i % MaxSize ]);
		}
		System.out.println(); 
	}
	//显示队头
	public int peek() 
	{
		System.out.println("----------队头----------");
		System.out.printf("此时front的值为%d\n", front);
		System.out.printf("此时rear的值为%d\n", rear);
		if(rear-1 == front)
			throw new RuntimeException("队列空");
		return queen[front];
	}
}  
