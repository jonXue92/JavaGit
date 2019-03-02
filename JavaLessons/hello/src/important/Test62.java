package important;

import java.util.Scanner;

public class Test62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s;
		String hour=null;
		String minute=null;
		String second=null;
		boolean print = false;
		s = in.nextLine();
		while(!s.equals("END"))
		{	
			if (s.startsWith("$GPRMC"))
			{
				String[] star = s.split(",");
				if (star[2].equals("A"))
				{
					int loc = s.indexOf("*");
					int num = 0;
					for (int i=1;i<loc;i++)
					{
						num ^= s.charAt(i);
					}
					num %= 65536;
					if (Integer.parseInt(s.substring(loc+1), 16)==num)
					{
						print = true;
						hour = star[1].substring(0, 2);
						minute = star[1].substring(2, 4);
						second = star[1].substring(4, 6);
					}
				}
			}
			s = in.nextLine();
		}
		if (print)
		{
			int h = (Integer.parseInt(hour)+8)%24;
			if (h < 10)
			{
				System.out.print("0");
			}
			System.out.println(h+":"+minute+":"+second);
		}
	}

}
