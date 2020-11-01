package lab1;

public class MatrixManager {
    MatrixManager() {
    }
    //Инициализация матрицы
    double[][] Initialize(int n, int m) {
        try {
            if ((n <= 0) || (m <= 0))
                throw new IllegalArgumentException("Размер матрицы должен быть хотя бы 1х1");
            double[][] matrix = new double[n][m];
            return matrix;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return null;
        }
    }
    //Просмотр элемента
    double ViewElement(double[][] matrix, int i, int j) {
        try {
            return matrix[i][j];
        }
    catch (IndexOutOfBoundsException e)
    {
        System.out.println(e);
        return 0;
    }
    }
    //Замена элемента
   void SetElement(double[][]  matrix, int i, int j, double new_element) {
       try {
           matrix[i][j] = new_element;
       }
       catch (ArrayIndexOutOfBoundsException e)
       {
           System.out.println(e);
           return;
       }
    }
    //Получение размера
   int[] GetSize (double[][] matrix)
    {
        int[] size = {matrix.length, matrix[0].length};
        return size;
    }
    //Просмотр размера
    String ViewSize (double[][] matrix)
    {
         int [] size = GetSize(matrix);
        return "Размер матрицы: " + size[0] + "x" + size[1];
    }
    //Умножение на число
    void MultiplyByNumber(double[][] matrix, double number)
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * number;
            }
    }
    //Перемножение двух матриц
    double[][] MultiplyMatrixes(double[][] matrix1, double[][] matrix2)
    {
        try
        {
            if (matrix1[0].length!= matrix2.length)
                throw new IllegalArgumentException("Число столбцов первой матрицы не совпадает с числом строк второй");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return null;
        }
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    //Сложение двух матриц
    double[][] AddMatrixes (double[][] matrix1, double[][] matrix2)
    {
        try
        {
            if ((matrix1.length!= matrix2.length)||(matrix1[0].length!= matrix2[0].length))
                throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return null;
        }
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    //Вычитание второй матрицы из первой
    double[][] SubtractMatrixes (double[][] matrix1, double[][] matrix2)
    {
        try
        {
            if ((matrix1.length!= matrix2.length)||(matrix1[0].length!= matrix2[0].length))
                throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return null;
        }
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    //Определитель
    double Determinant (double[][] matrix)
    {
        try
        {
            if (matrix.length != matrix[0].length)
                throw new IllegalArgumentException("Матрица не квадратная");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return 0;
        }
        int n = matrix.length;
        double determinant = 0;
        double[][] submatrix = new double[n-1][n-1];
        if (n == 1) return matrix[0][0];
        if (n == 2)
            return matrix[1][1]*matrix[0][0] - matrix[0][1]* matrix[1][0];
        int sign = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n-1; j++) {
                int a = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i) continue;
                    submatrix[j][a] = matrix[j+1][k];
                    a++;
                }
            }
            determinant += Math.pow(-1, i) * matrix[0][i]*Determinant(submatrix);
        }
        return  determinant;
    }
    //toString
    String toString (double[][] matrix)
    {
        String StringMatrix = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                StringMatrix += String.format("%10.2f", matrix[i][j]);
            }
            StringMatrix += "\n";
        }
        return StringMatrix;
    }
    //Сравнегние матриц
    boolean Equals(double[][] matrix1, double[][] matrix2)
    {
        if ((matrix1.length!= matrix2.length)||(matrix1[0].length!= matrix2[0].length))
            return false;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
               if (matrix1[i][j]!=matrix2[i][j]) return false;
            }
        }
        return true;
    }
}