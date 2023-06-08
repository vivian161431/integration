package final2023.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        System.out.println("testArrayPolynomial");
        testArrayPolynomial();

        System.out.println("\n================================\ntestListPolynomial");
        testListPolynomial();

        System.out.println("\n================================\ntestIntegrationCalculator");
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(1);
        poly1.insert(0.5, 0);
        poly1.insert(1.5, 2);
        poly1.set(2, 2);
        poly1.set(2, 3);

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.append(0.5);
        poly2.append(-1);
        poly2.append(3);

        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        System.out.println("==============================\n");

        System.out.println("plus: " + poly1.plus(poly2));
        System.out.println("minus: " + poly1.minus(poly2));
        System.out.println("multiply: " + poly1.multiply(poly2));

        System.out.println("==============================\n");
        System.out.println("poly2 evaluate with x = 2: " + poly2.evaluate(2));
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(1);
        poly1.insert(0.5, 0);
        poly1.insert(1.5, 2);
        poly1.set(2, 2);
        poly1.set(2, 3);

        ListPolynomial poly2 = new ListPolynomial();
        poly2.append(0.5);
        poly2.append(-1);
        poly2.append(3);

        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        System.out.println("==============================\n");

        System.out.println("plus: " + poly1.plus(poly2));
        System.out.println("minus: " + poly1.minus(poly2));
        System.out.println("multiply: " + poly1.multiply(poly2));

        System.out.println("==============================\n");
        System.out.println("poly2 evaluate with x = 2: " + poly2.evaluate(2));
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        testIntegration(new MidpointRule(1e-10, 100));
        testIntegration(new SimpsonRule(1e-10, 100));
        testIntegration(new TrapezoidRule(1e-10, 100));
    }

    private static void testIntegration(Integrator integrator) {
        System.out.print("Test " + integrator.getClass().getSimpleName() +": ");
        // x^2
        // 0 -> 1
        ListPolynomial polynomial = new ListPolynomial();
        polynomial.append(0);
        polynomial.append(0);
        polynomial.append(1);
        System.out.println(integrator.integrate(polynomial, 0, 1));
    }
}
