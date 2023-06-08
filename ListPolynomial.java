package final2023.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            return -1;
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     *
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficient(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficients.size()) {//note
            return this;
        }
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {//note
            return this;
        }
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() <= 1 ? 0 : coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        double powX = 1;
        for (int i = 0; i <= degree(); i++) {
            result = result + coefficient(i) * powX;
            powX *= x;
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        result.coefficients = arrayToList(differentiate());
        return result;
    }

    private List<Double> arrayToList(double[] array) {
        List<Double> list = new ArrayList<>();
        for (double number : array) {
            list.add(number);
        }
        return list;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        double[] resultCoefficients = Arrays.copyOf(coefficients(), Math.max(degree(), another.degree()) + 1);
        for (int i = 0; i <= another.degree(); i++) {
            resultCoefficients[i] += another.coefficient(i);
        }
        coefficients = arrayToList(resultCoefficients);
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        double[] resultCoefficients = Arrays.copyOf(coefficients(), Math.max(degree(), another.degree()) + 1);
        for (int i = 0; i <= another.degree(); i++) {
            resultCoefficients[i] -= another.coefficient(i);
        }
        coefficients = arrayToList(resultCoefficients);
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        double[] resultCoefficients = new double[degree() + another.degree() + 1];
        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                resultCoefficients[i + j] += coefficient(i) * another.coefficient(j);
            }
        }
        coefficients = arrayToList(resultCoefficients);
        return this;
    }
}
