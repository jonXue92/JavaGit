package chapter8;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest
{
    public static void main(String[] args)
    {
        Set<Name> s = new HashSet<Name>();
        s.add(new Name("abc", "123"));
        System.out.println(s.contains(new Name("abc", "123")));
        Set<String> stringSet = new HashSet<>();
        String str1 = "123";
        String str2 = new String("123");
        System.out.println(str1 == str2);
        stringSet.add("123");
        System.out.println(stringSet.contains(str1));
        System.out.println(stringSet.contains(str2));
    }
}
class Name {
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o.getClass() == Name.class) {
            Name n = (Name)o;
            return n.first.equals(first) && n.last.equals(last);
        }
        return false;
    }
}