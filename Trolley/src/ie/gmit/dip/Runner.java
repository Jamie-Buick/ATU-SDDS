package ie.gmit.dip;


public class Runner {

	public static void main(String[] args) {
		
		Order o = new OrderImpl("QB-1234-AA");
		LineItem item1 = new LineItemImpl("AA1", "Salmon Fly Rod", 3, 899.99f);
		LineItem item2 = new LineItemImpl("AA2", "Salmon Fly Reel", 3, 200.00f);
		LineItem item3 = new LineItemImpl("AA3", "Salmon Fly Line", 21, 78.99f);
		LineItem item4 = new LineItemImpl("AA4", "Salmon Fly Sink Tip", 43, 10.00f);
		
		o.addItem(item1);
		o.addItem(item2);
		o.addItem(item3);
		o.addItem(item4);
		
		LineItem[] items = o.items();
		for (int i = 0; i < items.length; i++) {
			System.out.println("[" + (i + 1) + "]\t" + items[i].getItemName() + "\t " + items[i].getItemPrice());
			
		}
		
		System.out.println("Total: " + o.getTotal());
		
		LineItem itemX= new LineItemImpl("AA4", "Salmon Fly Sink Tip", 3, 10.00f);
		o.removeItem(itemX);
		System.out.println("Count: " + o.items().length);
	}
}
