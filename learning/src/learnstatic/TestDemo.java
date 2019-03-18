package learnstatic;

class Obj{
    private static int count = 0;

    public Obj(){
        System.out.println("count = " + ++count);
    }
}

public class TestDemo {
    public static void main(String args[]) {

        new Obj();
        new Obj();
        new Obj();
        new Obj();
        new Obj();
    }
}
