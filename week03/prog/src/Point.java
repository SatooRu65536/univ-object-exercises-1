public class Point {
    double x;
    double y;

    public String getPrintString() {
        return String.format("(%.2f,%.2f)", x, y);
    }
}
