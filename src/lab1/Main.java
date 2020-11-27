package lab1;


public class Main {

    public static void main(String[] args)
	{
	MatrixManager m = new MatrixManager();

	Matrix matrix1 = m.Initialize(4,4);
	Matrix matrix2 = m.Initialize(4,4);
	Matrix matrix3;
	Matrix matrix4;
	Matrix matrix5;
	int counter = 0;
	for (int i = 0; i < m.GetSize(matrix1)[0]; i++) {
		for (int j = 0; j < m.GetSize(matrix1)[1]; j++) {
			counter++;
			m.SetElement(matrix1, i, j, i+j);
			m.SetElement(matrix2, i, j, counter);
			}
		}
	try {
		m.SetElement(matrix2, 1, 2, 4);
	}
	catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
	try {
		m.SetElement(matrix2, 3, 3, 1);
	}
	catch (ArrayIndexOutOfBoundsException e)
	{
		System.out.println(e);
	}
		try {
			m.SetElement(matrix2, 3, -3, 1);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
	try {
		matrix3 = m.AddMatrixes(matrix1, matrix2);
	}
	catch (IllegalArgumentException e)
	{
		System.out.println(e);
		matrix3 = new Matrix(1,1);
	}
	try {
		matrix4 = m.SubtractMatrixes(matrix1, matrix2);
	}
	catch (IllegalArgumentException e) {
		System.out.println(e);
		matrix4 = new Matrix(1, 1);
	}
	try {
		matrix5 = m.MultiplyMatrixes(matrix3, matrix4);
	}
	catch (IllegalArgumentException e) {
		System.out.println(e);
		matrix5 = new Matrix(1, 1);
	}
	matrix5 = m.MultiplyMatrixes(matrix3, matrix4);
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
