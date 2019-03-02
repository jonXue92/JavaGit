package hello;

import java.util.Scanner;

public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		final int SIZE = 3;
		int[][] board = new int[SIZE][SIZE];
		int numOfO = 0;
		int numOfX = 0;
		boolean gotResult = false;
		//读入矩阵
		for (int i = 0;i<board.length;i++)
		{
			for (int j = 0;j<board[i].length;j++)
			{
				board[i][j] = in.nextInt();
			}
		}
		//横着检验
		for(int i=0;i<SIZE;i++)
		{
			numOfX = 0;
			numOfO = 0;
			for (int j=0;j<SIZE;j++)
			{
				if (board[i][j] == 0)
				{
					numOfO ++;
				}
				else if (board[i][j] == 1)
				{
					numOfX ++;
				}
			}
			if (numOfX == SIZE || numOfO == SIZE) 
			{
				gotResult = true;
				break;
			}
		}
		//竖着检验
//		if (!gotResult)
//		{
//			for(int i=0;i<SIZE;i++)
//			{
//				numOfX = 0;
//				numOfO = 0;
//				for (int j=0;j<SIZE;j++)
//				{
//					if (board[j][i] == 0)
//					{
//						numOfO ++;
//					}
//					else if (board[j][i] == 1)
//					{
//						numOfX ++;
//					}
//				}
//				if (numOfX == SIZE || numOfO == SIZE) 
//				{
//					gotResult = true;
//					break;
//				}
//			}
//		}
		// 对角检验	
		if (!gotResult)
		{
			numOfX = 0;
			numOfO = 0;
			for(int i=0;i<SIZE;i++)
			{
				if (board[i][i] == 0)
				{
					numOfO ++;
				}
				else if (board[i][i] == 1)
				{
					numOfX ++;
				}
			}
			if (numOfX == SIZE || numOfO == SIZE) 
			{
				gotResult = true;
			}
		}
		//反对角检验
		if (!gotResult)
		{
			numOfX = 0;
			numOfO = 0;
			for(int i=0;i<SIZE;i++)
			{
				if (board[i][SIZE-1-i] == 0)
				{
					numOfO ++;
				}
				else if (board[i][SIZE-1-i] == 1)
				{
					numOfX ++;
				}
			}
			if (numOfX == SIZE || numOfO == SIZE) 
			{
				gotResult = true;
			}
		}
		if (gotResult) 
		{
			if (numOfX == SIZE)
			{
				System.out.println("X Win!");
			}
			else if (numOfO == SIZE)
			{
				System.out.println("O Win!");
			}
		}
	}

}
