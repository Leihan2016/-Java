import java.util.*;
import java.util.Arrays;

public class Tanxin
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        tanXin();
    }


    public static void tanXin()
    {
        HashSet<String> k1 = new HashSet<>();
        HashSet<String> k2 = new HashSet<>();
        HashSet<String> k3 = new HashSet<>();
        HashSet<String> k4 = new HashSet<>();
        HashSet<String> k5 = new HashSet<>();

        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");

        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");

        k4.add("上海");
        k4.add("天津");

        k5.add("杭州");
        k5.add("大连");

        HashSet<String> allArea = new HashSet<>();

        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("成都");
        allArea.add("杭州");
        allArea.add("大连");

        HashMap<String, HashSet<String>> all = new HashMap<>();
        all.put("k1", k1);
        all.put("k2", k2);
        all.put("k3", k3);
        all.put("k4", k4);
        all.put("k5", k5);

        HashSet<String> select = new HashSet<>();

        int allSize = allArea.size();
        int selectSize = select.size();

        HashSet<String> hebing = new HashSet<>();

        while(allArea.size() != 0)
        {
            String tempKey = null;
            for(String key: all.keySet())
            {
                hebing.clear();
                HashSet<String> temp = all.get(key);
                hebing.addAll(temp);
                hebing.retainAll(allArea);

                //比较得出覆盖区域最大值
                if(hebing.size() > 0 && (tempKey == null || hebing.size() > all.get(tempKey).size()))
                {
                    tempKey = key;
                }
            }

            if(tempKey != null)
            {
                select.add(tempKey);
                allArea.removeAll(all.get(tempKey));
            }
        }

        System.out.println(select);
    }
}
