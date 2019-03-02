package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.*;//存储数据结构

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<5;i++){
            arr.add(i);
        }
        ArrayList<Integer> tmp=(ArrayList<Integer>)arr.clone();
        System.out.println(tmp.toString());
        for(Integer i:arr){
            System.out.print(i+" ");
        }
    }
}
