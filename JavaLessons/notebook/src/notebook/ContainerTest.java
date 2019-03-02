package notebook;

import java.util.ArrayList;

public class ContainerTest {
 
    public static void main(String[] args) {
        Data data = new Data("实验体", 20, new StringBuilder("A"));
        System.out.println(data);
         
        ArrayList<Data> list = new ArrayList<Data>();
        list.add(data);
        System.out.println(data);
        System.out.println(list.get(0));
         
        // 测试0
        data.setName("========TEST0========");
        System.out.println(data);
        System.out.println(list.get(0));
         
        data.setAge(100);
        System.out.println(data);
        System.out.println(list.get(0));
         
        data.setGrade(new StringBuilder("D"));
        System.out.println(data);
        System.out.println(list.get(0));
 
        // 测试1
        data = new Data("========TES1=======", 0, new StringBuilder("A+"));
        System.out.println(data);
        System.out.println(list.get(0));
         
        // 测试2
        String s = "========TEST2========";
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add(s);
        System.out.println(s);
        System.out.println(list2.get(0));
         
        s = "String的不可变性";
        System.out.println(s);
        System.out.println(list2.get(0));
         
        // 测试3
        StringBuilder sb = new StringBuilder("========TEST3========");
        ArrayList<StringBuilder> list3 = new ArrayList<StringBuilder>();
        list3.add(sb);
        System.out.println(sb);
        System.out.println(list3.get(0));
         
        sb.append("StringBuilder的可变性");
        System.out.println(sb);
        System.out.println(list3.get(0));
    }
 
}
 
class Data {
    private String name;
    private int age;
    private StringBuilder grade;
     
    public Data(String name, int age, StringBuilder grade) {
        super();
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public StringBuilder getGrade() {
        return grade;
    }
 
    public void setGrade(StringBuilder grade) {
        this.grade = grade;
    }
 
    @Override
    public String toString() {
         
        return name + " " + age + " " + grade;
    }
 
}
