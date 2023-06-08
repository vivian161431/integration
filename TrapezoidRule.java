package final2023.integration;

public class TrapezoidRule implements Integrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     *
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        /* TODO */
        int n = 2;
        int iteration = 0;
        double before = integrate(poly, lower, upper, n);
        double current = 0;
        while (iteration < maxIterations) {
            n *= 2;
            current = integrate(poly, lower, upper, n);
            if (Math.abs(current - before) < precision) {
                break;
            }
            before = current;
            iteration++;
        }
        return current;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     *
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.5 * (poly.evaluate(lower) + poly.evaluate(upper));
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + h * i;
            sum += poly.evaluate(x);
        }
        return sum * h;
    }
}
