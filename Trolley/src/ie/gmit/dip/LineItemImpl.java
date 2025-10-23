package ie.gmit.dip;

public class LineItemImpl implements LineItem{

	private String number;
	private String name;
	private int qty;
	private float price;
	
	
	
	// Overloading constructors
	
	public LineItemImpl() {
		super();
	}


	public LineItemImpl(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}


	public LineItemImpl(String number, String name, int qty, float price) {
		super();
		this.number = number;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}


	public void setItemNumber(String number) {
		this.number = number;
	}

	
	public String getItemNumber() {
		return this.number;
	}

	
	public void setItemName(String name) {
		this.name = name;
	}

	
	public String getItemName() {
		return this.name;
	}

	
	public void setItemQuantity(int qty) {
		this.qty = qty;
	}

	public int getItemQuantity() {
		return this.qty;
	}


	public void setItemPrice(float price) {
		this.price = price;
	}

	
	public float getItemPrice() {
		return this.price;
	}


	public int hashCode() {
		return number.hashCode();
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineItemImpl other = (LineItemImpl) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}


	public int compareTo(LineItem o) {
		return -this.number.compareTo(o.getItemNumber()); // Delegating
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
