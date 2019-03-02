package exception;

//class OpenException extends Exception {
//	
//}
//
//class CloseException extends OpenException {
//	
//}

public class OpenFile {
	
	public static int open() {
		int[] a = new int[10];
		a[10] = 10;
		return -1;
	}
	
	public static void readFile() throws OpenException, CloseException {
		if (open() == -1) {
			throw new CloseException();
		}
	}
	public static void main(String[] args) {
		try {
			readFile();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} 
		catch (CloseException e) {
			e.printStackTrace();
			System.out.println("Close");
		} 
		catch (OpenException e) {
			e.printStackTrace();
			System.out.println("Open");
		} 
//		catch (CloseException e) {
//			e.printStackTrace();
//			System.out.println("Close");
//		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Anything");
		} 
	}
}
