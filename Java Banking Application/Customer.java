// Customer.java
public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    // Constructor
    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Display Customer Details
    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Address      : " + address);
        System.out.println("Phone Number : " + phoneNumber);
    }
}
