import java.math.BigDecimal;

public class PolarPoint {
    private final Number rho;
    private Number theta;

    PolarPoint(Number rho, Number theta) {
        this.rho = rho;
        this.theta = theta;
        refreshDegree();
    }

    public PolarPoint(Double rho, Double theta) {
        this(new Number(rho), new Number(theta));
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PolarPoint{" +
                "rho=" + rho.getBigDecimal() +
                ", theta=" + theta.getBigDecimal() +
                '}';
    }

    public void spin(Number degree) {
        theta = theta.add(degree);
        refreshDegree();
    }

    private void refreshDegree() {
        while (theta.getBigDecimal().compareTo(new BigDecimal(360)) >= 0)
            theta = theta.add(new Number(-360.0));
        while (theta.getBigDecimal().compareTo(BigDecimal.ZERO) < 0)
            theta = theta.add(new Number(360.0));
    }

    public Point toPoint() {
        Number x, y;
        x = rho.multiply(new Number(Math.cos(Math.toRadians(theta.getBigDecimal().doubleValue()))));
        y = rho.multiply(new Number(Math.sin(Math.toRadians(theta.getBigDecimal().doubleValue()))));
        return new Point(x, y);
    }
}
