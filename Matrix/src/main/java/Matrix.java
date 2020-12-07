import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private int horElemSize;
    private int vertElemSize;
    private double[][] matrix;

    public Matrix(int horSize, int vertElemSize, double[][] matrix) throws IllegalArgumentException {
        if (!checker(matrix, horSize, vertElemSize))
            throw new IllegalArgumentException("Invalid matrix input!");
        this.horElemSize = horSize;
        this.vertElemSize = vertElemSize;


        this.matrix = matrix.clone();
    }

    public int getHorSize() {
        return horElemSize;
    }

    public int getVertSize() {
        return vertElemSize;
    }

    public double getEl(int i, int j) {
        if (i >= this.horElemSize || j >= this.vertElemSize)
            throw new IllegalArgumentException("Элемент по данному индексу отсутствует!");
        return matrix[i][j];
    }

    public void changeEl(int i, int j, double element) throws IllegalArgumentException {
        if (i >= horElemSize || j >= vertElemSize)
            throw new IllegalArgumentException("Элемент по данному индексу отсутствует!");
        matrix[i][j] = element;
    }

    public void addition(Matrix other_Matrix) throws IllegalArgumentException {
        if ((horElemSize != other_Matrix.horElemSize) && (vertElemSize != other_Matrix.vertElemSize))
            throw new IllegalArgumentException("Размер матриц не совпадает!");
        else {
            for (int i = 0; i < horElemSize; ++i)
                for (int j = 0; j < vertElemSize; ++j)
                    matrix[i][j] += other_Matrix.matrix[i][j];
        }
    }

    public void difference(Matrix other_Matrix) throws IllegalArgumentException {
        if ((horElemSize != other_Matrix.horElemSize) && (vertElemSize != other_Matrix.vertElemSize))
            throw new IllegalArgumentException("Размер матриц не совпадает!");
        else {
            for (int i = 0; i < horElemSize; ++i)
                for (int j = 0; j < vertElemSize; ++j)
                    matrix[i][j] -= other_Matrix.matrix[i][j];
        }
    }

    public void multiplication(Matrix other_Matrix) throws IllegalArgumentException {
        if (horElemSize != other_Matrix.vertElemSize)
            throw new IllegalArgumentException("Количество столбцов в первой матрице не совпадает с количеством строк во второй матрице!");
        else {
            double[][] res_Matrix = new double[other_Matrix.horElemSize][other_Matrix.vertElemSize];
            for (int i = 0; i < horElemSize; ++i)
                for (int j = 0; j < vertElemSize; ++j) {
                    for (int k = 0; k < other_Matrix.horElemSize; ++k) {
                        res_Matrix[i][j] += matrix[i][k] * other_Matrix.matrix[k][j];
                    }
                }
            matrix = res_Matrix;
        }
    }

    public void mulByScalar(double scalar) {
        for (int i = 0; i < this.horElemSize; ++i)
            for (int j = 0; j < this.vertElemSize; ++j)
                matrix[i][j] *= scalar;
    }


    public double getDet() throws IllegalArgumentException {
        if (horElemSize != vertElemSize)
            throw new IllegalArgumentException("Матрица не является квадратичной!");
        else
            return this.determinantHelper(matrix, this.horElemSize);
    }

    private double[][] generateSubArray(double matrix[][], int N, int j1) {
        double[][] m = new double[N - 1][];
        for (int k = 0; k < (N - 1); k++)
            m[k] = new double[N - 1];

        for (int i = 1; i < N; i++) {
            int j2 = 0;
            for (int j = 0; j < N; j++) {
                if (j == j1)
                    continue;
                m[i - 1][j2] = matrix[i][j];
                j2++;
            }
        }
        return m;
    }

    private double determinantHelper(double matrix[][], int N) {
        double res;
        if (N == 1) res = matrix[0][0];
        else if (N == 2) res = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        else {
            double[][] m = null;
            res = 0;
            for (int j1 = 0; j1 < N; j1++) {
                m = generateSubArray(matrix, N, j1);
                res += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * determinantHelper(m, N - 1);
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        if (this.vertElemSize == matrix1.vertElemSize && this.horElemSize == matrix1.horElemSize) {
            for (int i = 0; i < this.horElemSize; ++i)
                for (int j = 0; j < this.vertElemSize; ++j)
                    if (this.matrix[i][j] != matrix1.matrix[i][j])
                        return false;
        } else return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(horElemSize, vertElemSize);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < horElemSize; ++i) {
            for (int j = 0; j < vertElemSize; ++j)
                str.append(new Double(matrix[i][j]).toString() + ' ');
            str.append('\n');
        }
        return str.toString();
    }

    private boolean checker(double[][] matrix, int horSize, int vertElemSize) {
        int length = matrix[0].length;
        for (int i = 1; i < vertElemSize; ++i) {
            if (matrix[i].length != horSize)
                return false;
        }
        return true;
    }
}