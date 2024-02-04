package ShapesWithDrawables;

public class Square extends Shape{

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(String color, double side) {
        super(color);
        this.side=side;
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing a Square");
    }

    @Override
    public double calculateArea() {
        return side*side;
    }

    @Override
    public void displayShapeType() {
        System.out.println("It's a Square");
    }
}
