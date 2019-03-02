package linkedlist;

// 实体类
public class Node {
	//为了方便，这两成员个变量都使用public，权限不用private就不需要编写get、set方法了。
	//private的权限是仅对本类访问。
	//存放下一个结点的变量
	public Node next = null;
	//存放结点数据的变量，简单点，直接为int型
	public int data; 
	//构造方法，在构造时就能够给data赋值
    public Node(int data){
        this.data = data;
    }
}
