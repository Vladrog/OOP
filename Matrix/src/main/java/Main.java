public class Main {
    public static void main(String[] args) {

        try {

            Matrix a = new Matrix(2, 2, new double[][]{{1, 2}, {2, 4}});
            Matrix b = new Matrix(2, 2, new double[][]{{4, 2}, {2, 3}});
            Matrix c = new Matrix(2, 2, new double[][]{{1, 2}, {2, 4}});
            Matrix d = new Matrix(2, 3, new double[][]{{1, 2}, {2, 4}, {2, 3}});
            double[][] arr = {{2.0, 3.0}, {1.0, 1.0, 0.0}};
            //Matrix e = new Matrix(2, 3, arr);
             a.multiplication(b);

            // a.printMatrix();

            //System.out.println(b.equals(c));

            //a.mulByScalar(3);
            System.out.println(b.toString());
            System.out.println(a.getDet());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
