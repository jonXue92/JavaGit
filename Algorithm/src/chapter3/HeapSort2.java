package chapter3;

import java.util.Arrays;
import java.util.HashSet;

public class HeapSort2 {
    // 为了计算取下标方便，增加一个0在数组的首位
    //public static int[] origin = new int[]{0,30,20,80,40,50,10,60,70,90};
    public static int[] origin = new int[]{0,50,10,90,30,70,40,80,60,20};
    // indexSet数组记录每一次变化的结点的索引，仅是为了方便观察
    private static HashSet<Integer> indexSet = new HashSet<>();
    public static void main(String[] args) {
        int total = origin.length-1;
        System.out.println("Unsorted: "+Arrays.toString(origin));
        // 构建大顶堆
        for (int i = total/2,k=1; i >= 1; i--,k++) {
            heapAdjust(total,i,origin);
            // 打印每一次调整的结果及交换的下标
            System.out.println(k + "\t" + Arrays.toString(origin) + " " + Arrays.toString(indexSet.toArray()));
        }
        System.out.println();
        // 堆排序
        for (;total>1;) {
            System.out.println(total);
            // 交换根结点和最后一个叶子结点
            swap(1, total, origin);
            System.out.println("Swapped: " + Arrays.toString(origin));
            // 总数减1，因为最后一个叶子结点现在是最大值，要排除在排序数字之外
            total--;
            if (total==2 && origin[total]>=origin[total-1]) {
                // 改进的地方：如果只剩2个结点比较，且第二个结点大于等于根结点，没有必要再调整了，可以直接退出了
                break;
            }
            heapAdjust(total,1,origin);
            // 打印每一次调整的结果及交换的下标
            System.out.println("Changed: " + Arrays.toString(origin) + " " + Arrays.toString(indexSet.toArray()));
            System.out.println();
        }
        System.out.println("Sorted: "+Arrays.toString(origin));
    }
    /**
     * adjustHeap 调整为大顶堆结构
     * @param n 待比较数的个数
     * @param index 每次比较的结点下标
     * @param array 待比较的数组
     */
    public static void heapAdjust(int n,int index,int [] array){
        indexSet.clear();
        int maxChildrenIndex;
        for (int i = 2*index; i <= n; i = index<<1) {
            maxChildrenIndex = i;
            if (i<n && array[i]<array[i+1]) {
                // 小于n说明还有右边的结点，选出最大子结点的下标
                maxChildrenIndex=i+1;
            }
            // 等于n，说明只有一个子结点；小于n，同时左边结点大于右边结点，这两种情况maxindex都不用改变了。
            if (array[maxChildrenIndex]>array[index]) {
                swap(index, maxChildrenIndex, array);
                // 记录交换的结点index，便于观察
                indexSet.add(index);
                indexSet.add(maxChildrenIndex);
                // 调整后，需要重设比较的起始结点，看这个结点和它的子结点是否还要需要调整
                index = maxChildrenIndex;
            }
            else {
                break;
            }
        }
    }
    public static void swap(int index1,int index2,int [] array){
        try {
            int temp = origin[index1];
            origin[index1] = origin[index2];
            origin[index2] = temp;
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}