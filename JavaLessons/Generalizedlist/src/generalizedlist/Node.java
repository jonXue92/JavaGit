package generalizedlist;

public class Node {//广义表结点
	Node ph;//广义表的头结点
	Node pt;//广义表的尾结点
	int tag;
	Object data;//广义表的数据值
	public Node(Node hp, Node tp, int Tag, Object Data) {
		ph=hp;
		pt=tp;
		tag=Tag;
		data=Data;
	}
}
