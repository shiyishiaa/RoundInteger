import java.math.BigDecimal;

public class Point {
    Number x, y;

    Point(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    Point(Double x, Double y) {
        this.x = new Number(x);
        this.y = new Number(y);
    }

    public BigDecimal distanceToOrigin() {
        return Number.squareRoot(Number.square(x.getBigDecimal()).add(Number.square(y.getBigDecimal())));
    }

    public BigDecimal minDistanceToGrid() {
        return Number.squareRoot(Number.square(Number.minDistanceToInteger(x.getDecimal())).add(Number.square(Number.minDistanceToInteger(y.getDecimal()))));
    }

    public PolarPoint toPolar() {
        Number rho, theta;
        rho = new Number(this.distanceToOrigin());
        theta = new Number(BigDecimal.valueOf(Math.toDegrees(Math.atan2(y.getBigDecimal().doubleValue(), x.getBigDecimal().doubleValue()))));
        return new PolarPoint(rho, theta);
    }

    @Override
    public String toString() {
        return "Point{" +
                "\tx=" + x.getBigDecimal() +
                ", \ty=" + y.getBigDecimal() +
                '}';
    }

    public void print() {
        System.out.println(this.toString());
    }
}