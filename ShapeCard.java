public class ShapeCard {
    public enum Color {RED, BLUE, GREEN}
    public enum Shape {SQUARE, TRIANGLE, CIRCLE}
    public enum Number {ONE, TWO, THREE}

    public Color color;
    public Shape shape;
    public Number number;

    public ShapeCard(Color color, Shape shape, Number number){
        this.color = color;
        this.shape = shape;
        this.number = number;
    }
    
}
