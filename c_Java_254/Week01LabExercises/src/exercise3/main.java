package exercise3;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxedItem item = new BoxedItem("basketball", 99, 1, false);
		System.out.print("Item description:" +item.description());
		System.out.print("\nList Price:" + item.listPrice());
		System.out.print("\nLowest Price:" + item.listPrice()); 
		System.out.print("\nInsured Value:" + item.insuredValue()); 
	}

}
