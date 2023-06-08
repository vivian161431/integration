package final2023.integration;

import midterm2122.com.poly.ArrayPoly;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return -1;
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
//        return coefficents;
        return Arrays.copyOf(coefficents, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            enlarge();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index > size || index < 0) { //note
            return this;
        }
        if (size == coefficents.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficient(i - 1);
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index >= size || index < 0) { //note
            return this;
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return size <= 1 ? 0 : size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
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
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        result.coefficents = differentiate();
        result.size = coefficents.length;
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        double[] resultCoefficients = Arrays.copyOf(coefficients(), Math.max(degree(), another.degree()) + 1);
        for (int i = 0; i <= another.degree(); i++) {
            resultCoefficients[i] += another.coefficient(i);
        }
        coefficents = resultCoefficients;
        size = coefficents.length;
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        double[] resultCoefficients = Arrays.copyOf(coefficients(), Math.max(degree(), another.degree()) + 1);
        for (int i = 0; i <= another.degree(); i++) {
            resultCoefficients[i] -= another.coefficient(i);
        }
        coefficents = resultCoefficients;
        size = coefficents.length;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        double[] resultCoefficients = new double[degree() + another.degree() + 1];
        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                resultCoefficients[i + j] += coefficient(i) * another.coefficient(j);
            }
        }
        coefficents = resultCoefficients;
        size = coefficents.length;
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        coefficents = Arrays.copyOf(coefficents, size * 2);
    }
}
