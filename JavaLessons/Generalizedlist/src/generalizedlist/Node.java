package generalizedlist;

public class Node {//�������
	Node ph;//������ͷ���
	Node pt;//������β���
	int tag;
	Object data;//����������ֵ
	public Node(Node hp, Node tp, int Tag, Object Data) {
		ph=hp;
		pt=tp;
		tag=Tag;
		data=Data;
	}
}
