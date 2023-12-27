public class Rectangle implements Comparable<Rectangle> {

    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getArea() {
        return a * b;
    }

    @Override
    public int compareTo(Rectangle other) {
        return getArea() - other.getArea();
    }

    @Override
    public String toString() {
        return String.format("Rectangle: area(%d)", getArea());
    }
}
