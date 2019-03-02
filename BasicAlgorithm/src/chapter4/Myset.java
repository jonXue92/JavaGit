package chapter4;

public class Myset <E> {
    private Object []arr;//容错率，健壮性
    private int len=0,DEFAULT_CAPACITY=10;//类中的变量一般为private
    Myset(int lens){
        arr=new Object[lens];
    }
    Myset(){
        arr = new Object[DEFAULT_CAPACITY];
    }
    public int length(){
        return len;
    }
    public boolean addVal(Object val){
        if(len==arr.length){
            throw new IllegalArgumentException("too many objects");
        }
        for(int i=0;i<len;i++){
            if(arr[i]==val){
                return false;
            }
        }
        arr[len++]=val;
        return true;
    }
    public boolean contains(Object val){
        for (int i=0;i<len;i++){
            if(arr[i]==val){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Myset<Integer> w = new Myset<Integer>();
        for(int i=0;i<12;i++){
            w.addVal(i);
            w.addVal(i);
        }
        System.out.println(w.length());
    }
}
