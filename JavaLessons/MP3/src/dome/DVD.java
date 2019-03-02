package dome;

public class DVD extends Item {
	private String director;

	public DVD(String title, String director, int playingTime, String comment) {
		super(title, playingTime, false, comment);
		setTitle("hahahah");
		this.director = director;
	}
	
	public void print() {
		System.out.print("dvd:");
		super.print();
		System.out.println(":"+director);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD dvd = new DVD("a", "b", 30, "haha");
		dvd.print();
	}
}
