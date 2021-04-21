import java.awt.*;
import java.util.*;

public class Knight
{
    static boolean[] isVisited = new boolean[64];
    static boolean finished = false;

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        findAll(0,0,1);
    }


    //找出每一步可走的点，然后标记为已走，然后继续在已走过得点找出可走的点，继续标记，如果达到步数，则退出
    public static void findAll(int x, int y, int step)
    {

        isVisited[x*8 + y] = true;
        Point temp = new Point(x, y);
        ArrayList<Point> tempList = next(temp);
		//sort(tempList);
        //System.out.println("执行" + tempList.size());
        while(!tempList.isEmpty())
        {
            Point point = tempList.remove(0);
            int index = point.x*8 + point.y;
            if(!isVisited[index])
            {
                findAll(point.x, point.y, step + 1);
            }
        }

        if(step < 64 && !finished)
        {
            isVisited[x*8 + y] = false;
        }else
        {
            finished = true;
            System.out.println("完成");
        }



    }

    //函数---找出可走的点
    public static ArrayList<Point> next(Point point)
    {
        ArrayList<Point> listPoint = new ArrayList<>();

        //每个点有8个位置，进行统计
        if(point.x-2 > -1 && point.y-1 > -1)
        {
            listPoint.add(new Point(point.x-2, point.y-1));
        }

        if(point.x-1 > -1 && point.y-2 > -1)
        {
            listPoint.add(new Point(point.x-1, point.y-2));
        }

        if(point.x+1 < 8 && point.y-2 > -1)
        {
            listPoint.add(new Point(point.x+1, point.y-2));
        }

        if(point.x+2 < 8 && point.y-1 > -1)
        {
            listPoint.add(new Point(point.x+2, point.y-1));
        }

        if(point.x+2 < 8 && point.y+1 < 8)
        {
            listPoint.add(new Point(point.x+2, point.y+1));
        }

        if(point.x+1 < 8 && point.y+2 < 8)
        {
            listPoint.add(new Point(point.x+1, point.y+2));
        }

        if(point.x-1 > -1 && point.y+2 < 8)
        {
            listPoint.add(new Point(point.x-1, point.y+2));
        }

        if(point.x-2 > -1 && point.y+1 < 8)
        {
            listPoint.add(new Point(point.x-2, point.y+1));
        }

        return listPoint;
    }
	//根据当前这个一步的所有的下一步的选择位置，进行非递减排序, 减少回溯的次数
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                //获取到o1的下一步的所有位置个数
                int count1 = next(o1).size();
                //获取到o2的下一步的所有位置个数
                int count2 = next(o2).size();
                if(count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }

        });
    }
}

