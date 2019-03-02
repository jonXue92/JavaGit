package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OOExample {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Student[] students=new Student[n];
        for(int i=0;i<n;i++){
            students[i]=new Student();
            String name=in.next();
            int score=in.nextInt();
            students[i].setName(name);
            students[i].setScore(score);
        }
        for(Student student:students){
            student.speak();
        }
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore()-o1.getScore();
            }
        };
        Arrays.sort(students,comparator);
        for(Student student:students){
            student.speak();
        }
        Student stu=new Student("JonXue",92);
        Student stu1=stu;
        stu.speak();//实际调用speak是在Student里
        stu1.speak();
    }
}

class Student{
    private String name;
    private int score;

    public Student(){
        cry();
//        System.out.println("In constructor");
    }
    public Student(String name,int score){
        cry();
//        name=name;//第一个name不是对象的属性，而是传参，没有给属性赋值
//        score=score;//score由于没有使用this关键字，所以访问的仍是函数参数，而不是属性
        this.name=name;
        this.score=score;
//        System.out.println("In constructor");
    }
//        public Student(String stuname,int stuscore){
//        name=stuname;
//        score=stuscore;
//    }

    public void speak() {
        System.out.println(name + " : " + score);
    }
    public void cry(){
        System.out.println("wawawa");
    }

    public void setScore(int score){
        if(score>=0 && score<=100){
            this.score=score;
        }
    }
    public int getScore(){
        return score;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}