package ShapesWithDrawables;

public class Circle extends Shape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Constructor
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementing the abstract method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayShapeType() {
        System.out.println("it's a Circle");
    }

    // Implementing the draw method from the interface
    @Override
    public void drawShape() {
        System.out.println("Drawing a Circle");
    }
}
