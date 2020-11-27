package lab1;

public class MatrixManager {
    MatrixManager() {
    }
    //Инициализация матрицы
    Matrix Initialize(int n, int m) throws  IllegalArgumentException{
            if ((n <= 0) || (m <= 0)) {
                throw new IllegalArgumentException ("Matrix should at least be sized 1х1");
            }
            return new Matrix (n, m);
    }
    //Просмотр элемента
    double ViewElement(Matrix matrix, int i, int j) throws ArrayIndexOutOfBoundsException{
            return matrix.getElement(i, j);
    }
    //Замена элемента
   void SetElement(Matrix  matrix, int i, int j, double new_element) throws ArrayIndexOutOfBoundsException {
           matrix.setElement(i, j, new_element);
    }
    //Получение размера
   int[] GetSize (Matrix matrix)
    {
        return matrix.getSize();
    }
    //Просмотр размера
    String ViewSize (Matrix matrix)
    {
         int [] size = matrix.getSize();
        return "Размер матрицы: " + size[0] + "x" + size[1];
    }
    //Умножение на число
    void MultiplyByNumber(Matrix matrix, double number)
    {
        for (int i = 0; i < matrix.getSize()[0]; i++)
            for (int j = 0; j < matrix.getSize()[1]; j++) {
                matrix.setElement(i, j, matrix.getElement(i, j)* number);
            }
    }
    //Перемножение двух матриц
    Matrix MultiplyMatrixes(Matrix matrix1, Matrix matrix2) throws IllegalArgumentException
    {
            if (matrix1.getSize()[1]!= matrix2.getSize()[0])
                throw new IllegalArgumentException("The number of culumns is not equal to the second matix's number of raws");
        int n = matrix1.getSize()[0],  m = matrix2.getSize()[1];
        Matrix result = new Matrix (n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < matrix2.getSize()[0]; k++) {
                    result.setElement(i, j, matrix1.getElement(i, k) * matrix2.getElement(k, j));
                }
            }
        }
        return result;
    }
    //Сложение двух матриц
    Matrix AddMatrixes (Matrix matrix1, Matrix matrix2) throws IllegalArgumentException
    {
            if ((matrix1.getSize()[0]!= matrix2.getSize()[0])||(matrix1.getSize()[1]!= matrix2.getSize()[1]))
                throw new IllegalArgumentException("The matrixes have different sizes");
            int n = matrix1.getSize()[0], m = matrix1.getSize()[1];
        Matrix result = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.setElement(i, j, matrix1.getElement(i, j) + matrix2.getElement(i, j));
            }
        }
        return result;
    }
    //Вычитание второй матрицы из первой
    Matrix SubtractMatrixes (Matrix matrix1, Matrix matrix2) throws IllegalArgumentException
    {
        if ((matrix1.getSize()[0]!= matrix2.getSize()[0])||(matrix1.getSize()[1]!= matrix2.getSize()[1]))
            throw new IllegalArgumentException("The matrixes have different sizes");
        int n = matrix1.getSize()[0], m = matrix1.getSize()[1];
        Matrix result = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.setElement(i, j, matrix1.getElement(i, j) - matrix2.getElement(i, j));
            }
        }
        return result;
    }
    //Определитель
    double Determinant (Matrix matrix) throws IllegalArgumentException
    {
            if (matrix.getSize()[0] != matrix.getSize()[1])
                throw new IllegalArgumentException("The matrix is not square");
        int n = matrix.getSize()[0];
        double determinant = 0;
        Matrix submatrix = new Matrix(n-1,n-1);
        if (n == 1) return matrix.getElement(0,0);
        if (n == 2)
            return matrix.getElement(1,1)*matrix.getElement(0,0) - matrix.getElement(0,1)* matrix.getElement(1,0);
        int sign = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n-1; j++) {
                int a = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i) continue;
                    submatrix.setElement(j, a, matrix.getElement(j+1,k));
                    a++;
                }
            }
            determinant += Math.pow(-1, i) * matrix.getElement(0,i)*Determinant(submatrix);
        }
        return  determinant;
    }
    //toString
    String toString (Matrix matrix)
    {
        String StringMatrix = "";
        for (int i = 0; i < matrix.getSize()[0]; i++) {
            for (int j = 0; j < matrix.getSize()[1]; j++) {
                StringMatrix += String.format("%10.2f", matrix.getElement(i, j));
            }
            StringMatrix += "\n";
        }
        return StringMatrix;
    }

    //Сравнение матриц
    boolean Equals(Matrix matrix1, Matrix matrix2)
    {
        return matrix1.equals(matrix2);
    }
}