package dome;

public class CD extends Item {
	private String artist;
	private int numOfTracks;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super(title, playingTime, false, comment);
		this.artist = artist;
		this.numOfTracks = numOfTracks;
	}
	
	public void print() {
		System.out.print("cd:");
		super.print();
		System.out.println(":"+artist);
	}
	
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numOfTracks=" + numOfTracks + ", toString()=" + super.toString() + "]";
	}
	

//	@Override
	public boolean equals(CD obj) {
		// TODO Auto-generated method stub
		return artist.equals(obj.artist);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CD cd = new CD("a","b",2,4,"c");
		CD cd1 = new CD("a","b",2,4,"c");
		System.out.println(cd.equals(cd1));
		cd.print();
		String s = "aa" + cd;
		System.out.println(s);
	}
}
