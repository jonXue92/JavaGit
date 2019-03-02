public class Test2 {
    private int i = f(); 
    private int j = 10;
    private int f() {
        return j;
    }
    public static void main(String args[]) { 
        System.out.println((new Test2()).i); 
    }
}
