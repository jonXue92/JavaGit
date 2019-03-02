import java.util.HashSet;

class Value {
    int i;
    public boolean equals(Value v) {
        return v.i == i;
    }
}
public class Test3 {
    public static void main(String[] args) {
    	HashSet<Value> set = new HashSet<Value>();
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 39;
        set.add(v1);
        set.add(v2);
        System.out.println(set.size());
    }
}
