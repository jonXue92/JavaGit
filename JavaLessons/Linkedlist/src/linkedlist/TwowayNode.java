package linkedlist;

// 实体类
public class TwowayNode {
	//为了方便，这两成员个变量都使用public，权限不用private就不需要编写get、set方法了。
	//private的权限是仅对本类访问。
	public TwowayNode next = null;
	public TwowayNode prev = null;
	//存放结点数据的变量，简单点，直接为int型
	public int data; 
	//构造方法，在构造时就能够给data赋值
    public TwowayNode(int data){
        this.data = data;
    }
}
