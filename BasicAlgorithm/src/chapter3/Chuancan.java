package chapter3;

class TwoNumbers{
    public int x,y;
    public TwoNumbers(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Chuancan {
    public static void swap(TwoNumbers obj){
        int temp=obj.x;
        obj.x=obj.y;
        obj.y=temp;
    }
    public static void swap(int[] numbers){
        int temp=numbers[0];
        numbers[0]=numbers[1];
        numbers[1]=temp;
    }
    public static void main(String[] args) {
        TwoNumbers obj=new TwoNumbers(1,-1);
        System.out.println(obj.x+" "+obj.y);
        swap(obj);
        System.out.println(obj.x+" "+obj.y);
        int[] numbers=new int[2];
        numbers[0]=1;
        numbers[1]=-1;
        System.out.println(numbers[0]+" "+numbers[1]);
        swap(numbers);
        System.out.println(numbers[0]+" "+numbers[1]);
    }
}
