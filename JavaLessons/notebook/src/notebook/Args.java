package notebook;

public class Args {
	//printf()��ʵ��ʱ�Ͳ��������ַ�ʽ��
	public static void print(String...args) {
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	public static int Sum(int...values) {
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }
	public static double max(double... values) {
	    double max = Double.MIN_VALUE;
	    for (double v : values)
	        if (v > max)
	            max = v;
	    return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Sum(1,2,3,4));
		System.out.println(Sum(1,2,3,4,5));
		System.out.println(Sum(1,2,3,4,5,6));
		max(1.2,5.2,6.5); //�ɽ�������������doubleֵ
		max(new double[]{1.2,5.2,6.5}); //�ȼ�
		double[] d = {1.2,5.2,6.5};
		max(d);
	}

}
