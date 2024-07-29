package algorithms;

// Java program to calculate the area 
// of a square using the concept of 
// data abstraction 

abstract class Shape {
    // abstract method 
    public abstract int area();
}

// square class inheriting 
// the Shape class 
class Square extends Shape {
    // private data member 
    private int side;

    // method of square class 
    public Square(int x) {
        side = x;
    }

    // overriding of the abstract method of Shape 
    // class using the override keyword 
    @Override
    public int area() {
        System.out.print("Area of Square: ");
        return (side * side);
    }
}

// Driver Class 
public class GFG {
    // Main Method 
    public static void main(String[] args) {
        // creating reference of Shape class 
        // which refer to Square class instance 
        Shape sh = new Square(4);

        // calling the method 
        int result = sh.area();

        System.out.print(result);
    }
}
