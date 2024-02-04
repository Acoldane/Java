package ShapesWithDrawables;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Constructor
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Implementing the abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }

    // Implementing the draw method from the interface
    @Override
    public void drawShape() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public void displayShapeType() {
        System.out.println("It's a Rectangle");
    }
}
