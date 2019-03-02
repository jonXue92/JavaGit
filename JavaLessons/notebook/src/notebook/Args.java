package notebook;

public class Args {
	//printf()在实现时就采用了这种方式。
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
		max(1.2,5.2,6.5); //可接受任意数量的double值
		max(new double[]{1.2,5.2,6.5}); //等价
		double[] d = {1.2,5.2,6.5};
		max(d);
	}

}
