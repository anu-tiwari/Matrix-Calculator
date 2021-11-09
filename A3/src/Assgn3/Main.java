package Assgn3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static ArrayList<Matrix> matrices;
    private static int count;
    public static void main(String[] args)
    {
        matrices = new ArrayList<>();
        count = 0;
        int ch1;
        int exit=0;
        do
        {
            displayMainMenu();
            ch1 = scan.nextInt();
            switch (ch1) {
                case 1 -> enterMatrix();
                case 2 -> createMatrix();
                case 3 -> editMatrix();
                case 4 -> displayLabels();
                case 5 -> operations();
                case 6 -> elementWiseOperations();
                case 7 -> transpose();
                case 8 -> inverse();
                case 9 -> means();
                case 10 -> determinant();
                case 11 -> singletonAsScalar();
                case 12 -> APlusAt();
                case 13 -> eigen();
                case 14 -> solveEq();
                case 15 -> retrieve();
                case 16 -> exit = 1;
            }
        } while(exit==0);
    }

    public static void retrieve() {
        System.out.println("Choose a matrix: ");
        Matrix A = displayAllandChoose();
        ArrayList<String> l = A.getLabels();
        for (String lab: l)
        {
            System.out.println(lab);
        }
    }

    public static void solveEq() {
        System.out.println("Choose a square matrix: ");
        Matrix A = displayAllandChoose();
        System.out.println("Choose a column matrix: ");
        Matrix B = displayAllandChoose();
        float[][] res = A.solveEq(B);
        if(res==null)
            return;
        System.out.println("The result is: ");
        for (float[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j]);
            }
            System.out.println();
        }
    }

    public static void eigen() {
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        float[] res = A.eigenvalues();
        if(res==null)
            return;
        System.out.println("The eigenvalues are: "+res[0]+" "+res[1]);
    }

    public static void APlusAt() {
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        int[][] res = A.APlusAt();
        if(res==null)
            return;
        System.out.println("A+At is: ");
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j]);
            }
            System.out.println();
        }
    }

    public static void singletonAsScalar() {
        System.out.println("Which operation do you want to perform?");
        System.out.println("1. Multiplication");
        System.out.println("2. Division");
        int ch1;
        ch1 = scan.nextInt();
        System.out.println("Choose the first matrix: ");
        Matrix A = displayAllandChoose();
        System.out.println("Choose a singleton matrix: ");
        Matrix B = displayAllandChoose();
        float[][] res = B.SingletonAsScalar(A, ch1);
        if(res==null)
            return;
        System.out.println("The result is: ");
        for (float[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j]);
            }
            System.out.println();
        }
    }

    public static void determinant() {
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        float res = A.determinant();
        if(res==Integer.MIN_VALUE)
            return;
        System.out.println("The determinant is: "+res);
    }

    public static void means() {
        System.out.println("Which operation do you want to perform?");
        System.out.println("1. Row Mean");
        System.out.println("2. Column Mean");
        System.out.println("3. Mean of all elements");
        int ch1;
        ch1 = scan.nextInt();
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        if (ch1==1) {
            System.out.print("Which row? ");
            int ch2 = scan.nextInt();
            float res = A.rowMean(ch2);
            System.out.println("The mean is: "+res);
        }
        else if (ch1==2) {
            System.out.print("Which column? ");
            int ch2 = scan.nextInt();
            float res = A.colMean(ch2);
            System.out.println("The mean is: "+res);
        }
        else if (ch1==3) {
            float res = A.allMean();
            System.out.println("The mean is: "+res);
        }
        else {
            System.out.println("Wrong number selected.");
        }
    }

    public static void inverse() {
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        float[][] res = A.inverse();
        if(res==null)
            return;
        System.out.println("The inverse is: ");
        for (float[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j]);
            }
            System.out.println();
        }
    }

    public static void transpose() {
        System.out.println("Choose the matrix: ");
        Matrix A = displayAllandChoose();
        int[][] res = A.transpose();
        System.out.println("The transpose is: ");
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j]);
            }
            System.out.println();
        }
    }

    public static void elementWiseOperations() {
        System.out.println("Which operation do you want to perform?");
        System.out.println("1. Multiplication");
        System.out.println("2. Division");
        int ch1;
        ch1 = scan.nextInt();
        System.out.println("Choose the first matrix: ");
        Matrix A = displayAllandChoose();
        System.out.println("Choose the second matrix: ");
        Matrix B = displayAllandChoose();
        if (ch1==1) {
            int[][] res = A.elementMul(B);
            if(res==null)
                return;
            System.out.println("The product is: ");
            for (int[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else if (ch1==2) {
            float[][] res = A.elementDiv(B);
            if(res==null)
                return;
            System.out.println("The quotient is: ");
            for (float[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Wrong number selected.");
        }
    }

    public static void operations() {
        System.out.println("Which operation do you want to perform?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int ch1;
        ch1 = scan.nextInt();
        System.out.println("Choose the first matrix: ");
        Matrix A = displayAllandChoose();
        System.out.println("Choose the second matrix: ");
        Matrix B = displayAllandChoose();
        if (ch1==1) {
            int[][] res = A.add(B);
            if(res==null)
                return;
            System.out.println("The sum is: ");
            for (int[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else if (ch1==2) {
            int[][] res = A.subtract(B);
            if(res==null)
                return;
            System.out.println("The difference is: ");
            for (int[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else if (ch1==3) {
            int[][] res = A.multiply(B);
            if(res==null)
                return;
            System.out.println("The product is: ");
            for (int[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else if (ch1==4) {
            float[][] res = A.division(B);
            if(res==null)
                return;
            System.out.println("The quotient is: ");
            for (float[] re : res) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.print(re[j]);
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Wrong number selected.");
        }
    }

    public static void displayLabels() {
        Matrix M = displayAllandChoose();
        ArrayList<String> l = M.getLabels();
        System.out.println("The labels of this matrix are:");
        for (String s : l) {
            System.out.println(s);
        }
    }

    public static void editMatrix() {
        Matrix M = displayAllandChoose();
        M.edit();
    }

    public static void createMatrix() {
        System.out.println("Choose which type of matrix you want to create:");
        System.out.println("1. Square");
        System.out.println("2. Rectangular");
        System.out.println("3. Ones");
        System.out.println("4. Null");
        System.out.println("5. Symmetric");
        System.out.println("6. Skew-Symmetric");
        System.out.println("7. Upper Triangular");
        System.out.println("8. Lower Triangular");
        System.out.println("9. Singular");
        System.out.println("10. Singleton");
        System.out.println("11. Diagonal");
        System.out.println("12. Scalar");
        System.out.println("13. Identity");
        System.out.println("14. Row");
        System.out.println("15. Column");
        int ch1 = scan.nextInt();
        System.out.print("Enter number of rows:");
        int r = scan.nextInt();
        System.out.print("Enter number of columns:");
        int c = scan.nextInt();

        int[][] arr = null;
        if (ch1==1)
        {
            arr = Square.create(r, c);
        }
        if (ch1==1)
        {
            arr = Rectangular.create(r, c);
        }
    }

    public static Matrix displayAllandChoose()
    {
        int[][] A;
        for (Matrix mat: matrices)
        {
            A = mat.getData();
            System.out.println("Matrix "+mat.getId());
            for(int i=0; i<mat.getRows(); i++)
            {
                for (int j=0; j<mat.getColumns(); j++)
                {
                    System.out.print(A[i][j]+"    ");
                }
                System.out.println();
            }
        }
        System.out.print("Which matrix do you want to choose? ");
        int ch1;
        ch1 = scan.nextInt();
        return matrices.get(ch1-1);
    }
    public static void enterMatrix() {
        int rows;
        int cols;
        System.out.print("Enter number of rows: ");
        rows = scan.nextInt();
        System.out.print("Enter number of columns: ");
        cols = scan.nextInt();
        System.out.print("Enter the elements row-wise");
        int[][] arr = new int[rows][cols];
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                arr[i][j] = scan.nextInt();
            }
        }
        Matrix mat = assignTypeandLabels(arr, rows, cols);
        addMatrix(mat);
    }

    private static void addMatrix(Matrix M)
    {
        matrices.add(M);
    }

    private static Matrix assignTypeandLabels(int[][] arr, int r, int c) {
        Matrix mat = null;
        ArrayList<String> labels = new ArrayList<>();

        if (Null.isNull(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Null(r, c, ++count);
            }
            else
            {
                labels.add("Null");
            }
        }
        if (Ones.isOnes(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Ones(r, c, ++count);
            }
            else
            {
                labels.add("Ones");
            }
        }
        if (Singleton.isSingleton(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Singleton(arr[0][0], ++count);
            }
            else
            {
                labels.add("Singleton");
            }
        }
        if (Row.isRow(arr, r, c))
        {
            if (mat==null)
            {
                int[] ele = new int[c];
                System.arraycopy(arr[0], 0, ele, 0, c);
                mat = new Row(c, ele, ++count);
            }
            else
            {
                labels.add("Row");
            }
        }
        if (Column.isColumn(arr, r, c))
        {
            if (mat==null)
            {
                int[] ele = new int[c];
                for (int i=0; i<r; i++)
                {
                    ele[i] = arr[i][0];
                }
                mat = new Column(r, ele, ++count);
            }
            else
            {
                labels.add("Column");
            }
        }
        if (Identity.isIdentity(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Identity(r, ++count);
            }
            else
            {
                labels.add("Identity");
            }
        }
        if (Scalar.isScalar(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Scalar(r, arr[0][0], ++count);
            }
            else
            {
                labels.add("Scalar");
            }
        }
        if (Diagonal.isDiagonal(arr, r, c))
        {
            if (mat==null)
            {
                int[] ele = new int[c];
                for (int i=0; i<r; i++)
                {
                    ele[i] = arr[i][i];
                }
                mat = new Diagonal(r, ele, ++count);
            }
            else
            {
                labels.add("Diagonal");
            }
        }
        if (UpperTrian.isUpperTrian(arr, r, c))
        {
            if (mat==null)
            {
                mat = new UpperTrian(r, arr, ++count);
            }
            else
            {
                labels.add("Upper Triangular");
            }
        }
        if (LowerTrian.isLowerTrian(arr, r, c))
        {
            if (mat==null)
            {
                mat = new LowerTrian(r, arr, ++count);
            }
            else
            {
                labels.add("Lower Triangular");
            }
        }
        if (Symmetric.isSymmetric(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Symmetric(r, arr, ++count);
            }
            else
            {
                labels.add("Symmetric");
            }
        }
        if (SkewSymmetric.isSkewSymmetric(arr, r, c))
        {
            if (mat==null)
            {
                mat = new SkewSymmetric(r, arr, ++count);
            }
            else
            {
                labels.add("Skew-Symmetric");
            }
        }
        if (Singular.isSingular(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Singular(r, arr, ++count);
            }
            else
            {
                labels.add("Singular");
            }
        }
        if (Square.isSquare(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Square(r, arr, ++count);
            }
            else
            {
                labels.add("Square");
            }
        }
        if (Rectangular.isRectangular(arr, r, c))
        {
            if (mat==null)
            {
                mat = new Rectangular(r, c, arr, ++count);
            }
            else
            {
                labels.add("Rectangular");
            }
        }
        assert mat != null;
        mat.setLabels(labels);
        return mat;
    }

    public static void displayMainMenu()
    {
        System.out.println("Choose among the following tasks:");
        System.out.println("1. Enter matrix");
        System.out.println("2. Create matrix of requested type");
        System.out.println("3. Edit matrix");
        System.out.println("4. Display labels of a matrix");
        System.out.println("5. Perform addition, subtraction, multiplication & division");
        System.out.println("6. Perform element-wise operations");
        System.out.println("7. Transpose matrix");
        System.out.println("8. Invert matrix");
        System.out.println("9. Compute means: row-wise mean, column-wise mean, mean of all the elements");
        System.out.println("10. Compute determinant");
        System.out.println("11. Use singleton matrices as scalars");
        System.out.println("12. Compute A+AT for a matrix A");
        System.out.println("13. Compute Eigen vectors and values");
        System.out.println("14. Solve sets of linear equations using matrices");
        System.out.println("15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels");
        System.out.println("16. Exit");
    }
}
