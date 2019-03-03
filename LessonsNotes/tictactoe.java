import java.util.Scanner;
 
public class TicTacToe {
 
	private static int gird = 3; // 设定3*3的棋盘
	private static int[][] girds = new int[gird][gird]; // 创建与格数对应的二维数组
	private static int tokenRow, tokenColumn; // tokenRow表示横向格子，tokenColumn表示纵向格子
	private static int player1 = 1, player2 = 2;// player1表示为X ; player2表示为O
	private static int player = player1; // 初始化先落子的玩家为X玩家
 
	public static void main(String[] args) {
 
		Scanner input = new Scanner(System.in);
 
		// 一直循环至有玩家获胜或者平局
		while (judgeDraw() == true) {
 
			// 一直循环至玩家输入正确
			while (true) {
 
				// 输入玩家的落子情况
				System.out.print("Enter a row(0, 1 or 2) for player "
						+ (player == 1 ? "X" : "O") + ": ");
				tokenRow = input.nextInt();
				System.out.print("Enter a column(0, 1 or 2) for player "
						+ (player == 1 ? "X" : "O") + ": ");
				tokenColumn = input.nextInt();
 
				// 判断落子是否超出格子范围或落在已经占用的格子
				if (judgeToken(tokenRow, tokenColumn, player) == 1) {
					break;
				}
			}
 
			// 判断玩家是否获胜，获胜则返回0，否则返回1
			if (judgeWin(player) == 0) {
				System.out.println((player == 1 ? "X" : "O") + " player win.");
				break;
			}
 
			// 更换落子的玩家
			if (player == player1) {
				player = player2;
			} else {
				player = player1;
			}
		}
	}
 
	//判断格子是否占满，若占满则判断为平局
	private static boolean judgeDraw() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (girds[i][j] == 0) {
					return true;
				}
			}
		}
		System.out.println("X and O draw.");
		return false;
	}
 
	// 判断落子是否超出格子范围或落在已经占用的格子
	private static int judgeToken(int r, int c, int p) {
		if (r > 2 || r < 0 || c > 2 || c < 0) {
			System.out.println("Input Error! Please re-enter.");
			return 0;
		} else {
			if (girds[r][c] == 0) {
				girds[r][c] = p;
				showGrids();
				judgeWin(p);
				return 1;
			} else {
				System.out.println("This grid is occupied, please re-enter.");
				return 0;
			}
		}
	}
 
	// 判断玩家是否获胜，获胜则返回0，否则返回1
	private static int judgeWin(int p) {
		int count = 1;
		for (int i = 0; i < 3; ++i) {
			//判断行、列是否相等
			if (girds[i][0] == girds[i][1] && girds[i][1] == girds[i][2]
					&& girds[i][2] == p) {
				return 0;
			} else if (girds[0][i] == girds[1][i] && girds[1][i] == girds[2][i]
					&& girds[2][i] == p) {
				return 0;
			}
		}
 
		//判断两条斜线是否相等
		if (girds[0][0] == girds[1][1] && girds[1][1] == girds[2][2]
				&& girds[2][2] == p) {
			return 0;
		} else if (girds[0][2] == girds[1][1] && girds[1][1] == girds[2][0]
				&& girds[2][0] == p) {
			return 0;
		}
		return 1;
	}
 
	// 显示棋盘当前状况
	private static void showGrids() {
		System.out.println("-------------");
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.print("| "
						+ (girds[i][j] == 0 ? " " : (girds[i][j] == 1 ? "X"
								: "O")) + " ");
				if (j == 2) {
					System.out.println("|");
				}
			}
			System.out.println("-------------");
		}
 
	}
 
}