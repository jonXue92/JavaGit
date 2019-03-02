class Base{
    public Base(int i){}
}
public class MyOver extends Base{
    public static void main(String arg[]){
        MyOver m = new MyOver(10);
    }
    MyOver(int i){
        super(i);
    }
    MyOver(String s, int i){
        this(i);
        //Here
//        super(); 
//        this("Hello",10);
//        MyOver m = new MyOver();
        Base b = new Base(10);
    }
}
