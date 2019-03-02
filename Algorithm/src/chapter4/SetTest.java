package chapter4;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i < 6; i ++) {
            set.add(i + "");
        }
        set.add("1"); //不会重复写入数据
        set.add(null);//可以写入空数据
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");//数据无序
        }// 输出(无序)为 3 4 1 5 null 2
        System.out.println();
        Set<String> set1 = new TreeSet<>();
        for (int i = 1; i < 6; i ++) {
            set1.add(i + "");
        }
        set1.add("1"); //不会重复写入数据
        // set1.add(null);//不可以写入空数据
        Iterator<String> iter1 = set1.iterator();
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + " ");//数据有序
        }// 输出(有序)为 1 2 3 4 5
        System.out.println();
        Map<String, String> map = new HashMap<>();
        for (int i = 5; i > 0; i --) {
            map.put(i + "", i + "");
        }
        map.put("1","1");//key无重复
        map.put("11","1");//value可以重复
        map.put(null, null);//可以为空
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            String key = (String)i.next();
            String value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
        Map<String, String> map1 = new TreeMap<>();
        for (int i = 5; i > 0; i --) {
            map1.put(i + "", i + "");
        }
        map1.put("1","1");//key无重复
        map1.put("11","1");//value可以重复
//        map1.put(null, null);//不可以为空
        // 注意，这里key是string，"11"是小于"2"的
        for (Iterator i = map1.keySet().iterator(); i.hasNext(); ) {
            String key = (String)i.next();
            String value = map1.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
