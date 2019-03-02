package exception;

class OpenException extends Exception {}

class CloseException extends OpenException {}

class NewException extends Exception {}

public class NewThing {
	public NewThing() throws OpenException {}
	public void f() throws OpenException {}
	public static void main(String[] args) {
	}
}

class NewClass extends NewThing {
//	public NewClass() { //wrong
	public NewClass() throws OpenException, NewException {
		super();
	}
//	public void f() {} //right
//	public void f() throws CloseException {} //right
//	public void f() throws NewException {} //wrong
//	public void f() throws OpenException, NewException {} //wrong
	public void f() throws OpenException {}
	public static void main(String[] args) {
		try {
			NewThing p = new NewClass();
			p.f();
		} catch (OpenException e1) {
			e1.printStackTrace();
		} catch (NewException e) {
			e.printStackTrace();
		}
	}
}