package lab1;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;
    Matrix(int n, int m) {
        matrix = new double[n][m];
    }
    public double getElement(int i, int j) throws ArrayIndexOutOfBoundsException{
        return matrix[i][j];
    }
    void setElement(int i, int j, double element) throws ArrayIndexOutOfBoundsException{
        matrix[i][j] = element;
    }

    int[] getSize()
    {
        int[] size = {matrix.length, matrix[0].length};
        return size;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Matrix matrix1 = (Matrix) obj;
        if ((matrix.length!= matrix1.matrix.length)||(matrix[0].length!= matrix1.matrix[0].length))
            return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]!=matrix1.matrix[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = matrix.length * 29 + matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               hash = hash * 29 + (int) matrix[i][j];
            }
        }
        return hash; //Arrays.hashCode(matrix);
    }
}