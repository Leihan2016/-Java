class ThreadSon extends Thread
{

	@Override
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			if(i % 2 == 0)
			{
				System.out.println("-------------------" + i);
			}
		}
	}
}

public class ThreadTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		ThreadSon test = new ThreadSon();
		test.start();

		for(int i = 0; i < 100; i++)
		{
			if(i % 2 == 0)
			{
				System.out.println("******************" + i);
			}
		}
	}
}
