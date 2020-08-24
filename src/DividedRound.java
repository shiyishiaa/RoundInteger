import java.math.BigDecimal;

public class DividedRound extends Thread {
    private final int part;
    private final BigDecimal radius;
    private final int x;
    private final int y;
    private final BigDecimal precision;

    public DividedRound(BigDecimal radius, int part, BigDecimal precision) {
        this.x = 0;
        this.y = 0;
        this.radius = radius;
        this.part = part;
        this.precision = precision;
    }

    public Point[] integerPoint(BigDecimal precision) {
        double step;
        String regex = "0+\\.0*1";
        if (precision.stripTrailingZeros().toPlainString().matches(regex))
            if (precision.compareTo(new BigDecimal("0.001")) < 0) {
                System.out.println("Too precise to calculate, which will take ages to finish!" +
                        "\nSet precise 0.001 by default.");
                step = 0.001;
            } else
                step = 1.0 / Math.pow(10, precision.toPlainString().split("\\.")[1].length());
        else {
            System.out.println("Error precision!");
            return null;
        }
        PolarPoint targetPolarPoints = new PolarPoint(radius.doubleValue(), 0.0);
        BigDecimal minSumMinDistance = new BigDecimal(Double.MAX_VALUE);
        for (int i = 0; i < 1 / step; i++) {
            PolarPoint spinPolarPoint = new PolarPoint(radius.doubleValue(), i / step);
            BigDecimal nowSumMinDistance = new BigDecimal(Double.MAX_VALUE);
            for (int j = 0; j < part; j++) {
                nowSumMinDistance = nowSumMinDistance.add(spinPolarPoint.toPoint().minDistanceToGrid().negate());
                spinPolarPoint.spin(new Number(360.0 / part));
                if (nowSumMinDistance.compareTo(minSumMinDistance) >= 0) {
                    targetPolarPoints = spinPolarPoint;
                    minSumMinDistance = nowSumMinDistance;
                    break;
                }
            }
        }
        Point[] points = new Point[part];
        for (int j = 0; j < part; j++) {
            points[j] = targetPolarPoints.toPoint();
            targetPolarPoints.spin(new Number(360.0 / part));
        }
        return points;
    }

    @Override
    public void run() {
        Point[] point = this.integerPoint(precision);
        for (Point p : point)
            p.print();
    }
}
