package chapter3;
class Student1{
    public int id;
    public Student1(int id){
        this.id=id;
    }
}
public class This {
    public Student1[] students;
    public This(int n){
        this.students=new Student1[n];
        for(int i=0;i<n;i++){
            this.students[i]=new Student1(i);
        }
    }
}
