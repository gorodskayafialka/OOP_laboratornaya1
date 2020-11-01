package lab1;


public class Main {

    public static void main(String[] args)
	{
	MatrixManager m = new MatrixManager();
	double[][] matrix1 = m.Initialize(4,4);
	double[][] matrix2 = m.Initialize(4,4);
	int counter = 0;
	for (int i = 0; i < m.GetSize(matrix1)[0]; i++) {
		for (int j = 0; j < m.GetSize(matrix1)[1]; j++) {
			counter++;
			m.SetElement(matrix1, i, j, i+j);
			m.SetElement(matrix2, i, j, counter);
			}
		}
	m.SetElement(matrix2, 1, 2, 4);
	m.SetElement(matrix2, 3, 3, 1);
	double[][] matrix3 = m.AddMatrixes(matrix1, matrix2);
	double[][] matrix4 = m.SubtractMatrixes(matrix1, matrix2);
	double[][] matrix5 = m.MultiplyMatrixes(matrix3, matrix4);
	m.MultiplyByNumber(matrix1, m.Determinant(matrix2));
	if (!m.Equals(matrix1, matrix2)) {
		System.out.println(m.toString(matrix1));
		System.out.println(m.toString(matrix2));
		System.out.println(m.toString(matrix3));
		System.out.println(m.toString(matrix4));
		System.out.println(m.toString(matrix5));
		System.out.println(m.ViewSize(matrix1));
	}
    }
}
