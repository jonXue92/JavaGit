package chapter6;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {
    public static void testStackOverflow(){
        testStackOverflow();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        stack.empty();
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(4);
        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }
        Set<Integer> set = new HashSet<>();//哈希表 Hash Table 1
//        Set<Integer> set=new TreeSet<>();//平衡树 Balance BST logn
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(4);
        System.out.println(set.contains(3));
        System.out.println(set.contains(10));
        set.remove(3);
        System.out.println(set.contains(3));
        System.out.println(set.contains(10));
        System.out.println(set.size());

        for(int num:set){
            System.out.println(num+" ");
        }
        Iterator it=set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Map<String,String> map = new HashMap<>();
//        Map<String,String> map = new TreeMap<>();
        map.put("Jack","CMU");
        map.put("Tom","Berkeley");
        map.put("Rose","MIT");
        map.put("Alex","Stanford");
        System.out.println(map.get("Jack"));
        System.out.println(map.get("JonXue"));
        System.out.println(map.getOrDefault("JonXue","家里蹲"));
        System.out.println(map.getOrDefault("Jack","家里蹲"));
//        map.put("Jack","Stanford");
//        map.replace("Jack","Stanford");
//        map.replace("Jack","CMU","Stanford");
        map.replace("Jack","家里蹲","Stanford");
        System.out.println(map.get("Jack"));
        map.remove("Rose");
        map.remove("Rose","CMU");
        map.remove("Rose","MIT");
        System.out.println(map.size());
        for(String key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
//        testStackOverflow();
//        List[] lists = new List[10];//合法
//        Queue[] queues = new Queue[10];
    }
}
