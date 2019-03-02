package vendingmachine;

public class VendingMachine {
	int price=80;
	int balance=f();
	int total;
	
	VendingMachine() //构造函数，不能有返回类型
	{
		total = 0;
	}
	VendingMachine(int price) // 重载
	{
		this();
		this.price=price;
	}
	int f()
	{
		return 0;
	}
	void setPrice(int price)
	{
		this.price=price;
	}
	void showPrompt()
	{
		System.out.println("Welcome");
	}
	void insertMoney(int amount)
	{
		balance+=amount;
		showBalace();
	}
	void showBalace()
	{
		System.out.println(balance);
	}
	void getFood()
	{
		if (balance >= price)
		{
			System.out.println("Here you are.");
			balance -= price;
			total+=price;
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vm = new VendingMachine();
		vm.showPrompt();
		vm.showBalace();
		vm.insertMoney(100);
		vm.getFood();
		vm.showBalace();
		VendingMachine vm1 = new VendingMachine(100);
		vm1.insertMoney(200);
		vm.showBalace();
		vm1.showBalace();
	}

}
