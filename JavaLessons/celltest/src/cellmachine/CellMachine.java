package cellmachine;

import java.util.Scanner;

public class CellMachine {
	private static Scanner in = new Scanner(System.in);
	private static Field field;
	private static int width = 0;
	private static int height = 0;
	
	public static void initial() {
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());
			}
		}
		int row = in.nextInt();
		int col = in.nextInt();
		while(row != -1 || col != -1) {
			Cell cell = field.get(row, col);
			cell.reborn();
			row = in.nextInt();
			col = in.nextInt();
		}
	}

	public static void run(int step) {
		for ( int i = 0; i < step; i++ ) {
			Field temp = new Field(height, width);
			for ( int row = 0; row < field.getHeight(); row++ ) {
				for ( int col = 0; col < field.getWidth(); col++ ) {
					Cell newcell = new Cell();
					if (field.get(row, col).isAlive()) { 
						newcell.reborn(); 
					}
					temp.place(row, col, newcell);
				}
			}
			for ( int row = 0; row < field.getHeight(); row++ ) {
				for ( int col = 0; col < field.getWidth(); col++ ) {
					Cell cell = temp.get(row, col);
					Cell[] neighbour = temp.getNeighbour(row, col);
					int numOfLive = 0;
					for ( Cell c : neighbour ) {
						if ( c.isAlive() ) {
							numOfLive++;
						}
					}
					if ( cell.isAlive() ) {
						if ( numOfLive <2 || numOfLive >3 ) {
							field.get(row, col).die();
						}
					} else if ( numOfLive == 3 ) {
						field.get(row, col).reborn();
					}
				}
			}
		}
	}
	
	public static int countAlive() {
		int numofLive = 0;
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				if ( field.get(row, col).isAlive() ) {
					numofLive++;
				}
			}
		}
		return numofLive;
	}
	public static void main(String[] args) {
		width = in.nextInt();
		height = in.nextInt();
		field = new Field(height, width);		
		initial();	
		int step = in.nextInt();
		run(step);
		System.out.println(countAlive());
	}

}
