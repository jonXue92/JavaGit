package linkedlist;

// ʵ����
public class TwowayNode {
	//Ϊ�˷��㣬������Ա��������ʹ��public��Ȩ�޲���private�Ͳ���Ҫ��дget��set�����ˡ�
	//private��Ȩ���ǽ��Ա�����ʡ�
	public TwowayNode next = null;
	public TwowayNode prev = null;
	//��Ž�����ݵı������򵥵㣬ֱ��Ϊint��
	public int data; 
	//���췽�����ڹ���ʱ���ܹ���data��ֵ
    public TwowayNode(int data){
        this.data = data;
    }
}
