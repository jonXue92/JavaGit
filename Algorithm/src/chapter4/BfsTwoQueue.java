package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTwoQueue {
    public static void main(String[] args) {
//        queue1就是保存当前层的节点，queue2就是保存下一层的节点
//        Queue<Object> queue1 = new LinkedList<>();
//        Queue<Object> queue2 = new LinkedList<>();
//        queue1.offer(startNode);
//        int currentLevel = 0;
//        while (!queue1.isEmpty()) {
//            int size = queue1.size();
//            for (int i = 0; i < size; i++) {
//                Object head = queue1.poll();
//        遍历head所有的邻居
//                for (all neighbors of head) {
//        在实际实现上需要加一个访问标记数组
//                    queue2.offer(neighbor);
//                }
//            }
//            Queue<Object> temp = queue1;
//            queue1 = queue2;
//            queue2 = temp;
//            queue2.clear();
//            currentLevel++;
//        }
    }
}
