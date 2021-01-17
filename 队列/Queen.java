public class Queen 
{
	public static void main(String[] args) 
	{
		QueenNum num = new QueenNum(6);
		num.addQueen(3);
		num.addQueen(4);
		num.addQueen(7);
		num.addQueen(3);
		num.addQueen(4);
		num.addQueen(5);
		num.displayQueen();
		System.out.printf("此时队头%d\n",num.peek());
		num.outQueen();
		num.displayQueen();
		System.out.printf("此时队头%d\n",num.peek());
		num.addQueen(5);
		num.displayQueen();
		System.out.printf("此时队头%d\n",num.peek());
		num.outQueen();
		num.displayQueen();
		System.out.printf("此时队头%d\n",num.peek());

	}
}
