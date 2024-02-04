package ShapesWithDrawables;

public class Triangle extends  Shape{
    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Triangle(String color, double base, double height) {
        super(color);
        this.base=base;
        this.height=height;
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public double calculateArea() {
        return (this.height*this.base)/2;
    }

    @Override
    public void displayShapeType() {
        System.out.println("It's a Triangle");
    }
}
