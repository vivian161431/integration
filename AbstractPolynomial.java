package final2023.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        String s = "[";
        for (int i = 0; i <= degree(); i++) {
            if (coefficient(i) != 0) {
                if (i == 0) {
                    s += coefficient(i);
                } else {
                    if (s.charAt(s.length() - 1) != '[') {
                        if (coefficient(i) > 0) {
                            s += " + ";
                        } else {
                            s += " - ";
                        }
                    }
                    s += Math.abs(coefficient(i));
                    if (i == 1) {
                        s += "x";
                    } else {
                        s += "x^" + i;
                    }
                }
            }
        }
        s += "]";
        return s;
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        if (degree() == 0) {
            return new double[]{0};
        }
        double[] diff = new double[degree()];
        for (int i = 0; i < degree(); i++) {
            diff[i] = coefficient(i + 1) * (i + 1);
        }
        return diff;
    }
}
