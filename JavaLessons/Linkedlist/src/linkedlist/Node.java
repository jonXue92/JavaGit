package linkedlist;

// ʵ����
public class Node {
	//Ϊ�˷��㣬������Ա��������ʹ��public��Ȩ�޲���private�Ͳ���Ҫ��дget��set�����ˡ�
	//private��Ȩ���ǽ��Ա�����ʡ�
	//�����һ�����ı���
	public Node next = null;
	//��Ž�����ݵı������򵥵㣬ֱ��Ϊint��
	public int data; 
	//���췽�����ڹ���ʱ���ܹ���data��ֵ
    public Node(int data){
        this.data = data;
    }
}
