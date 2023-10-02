package source.part1;

// Class definition
class MyClass {
	int value;

	// Constructor
	public MyClass(int value) {
		this.value = value;
	}

	// Method to modify the object's property
	public void modifyValue(int newValue) {
		this.value = newValue;
	}
}

public class References {
	// Method that modifies the object's property
	public static void modifyObject(MyClass obj, int newValue) {
		obj.modifyValue(newValue);
	}

	public static void main(String[] args) {
		// Create an object of MyClass
		MyClass obj = new MyClass(10);

		// Assign the reference of obj to two different variables
		MyClass reference1 = obj;
		MyClass reference2 = obj;

		// Print the initial value
		System.out.println("Initial value: " + obj.value); // Should be 10

		// Change the object's property using reference1
		reference1.modifyValue(20);

		// Check if the change influenced obj and reference2
		System.out.println("Value after using reference1: " + obj.value); // Should be 20
		System.out.println("Value after using reference2: " + reference2.value); // Should also be 20

		// Create a new object of MyClass
		MyClass newObj = new MyClass(30);

		// Call a method with the object as an argument
		modifyObject(newObj, 40);

		// Check the object's property outside the method
		System.out.println("Value after using method argument: " + newObj.value); // Should be 40
	}
}
