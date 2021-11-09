package Assgn3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public abstract class Matrix {
    private final int id;
    private final int rows;
    private final int columns;
    private ArrayList<String> labels;
    protected static Scanner scan = new Scanner(System.in);
    protected Random random = new Random();

    Matrix(int r, int c, int i)
    {
        this.rows = r;
        this.columns = c;
        this.id = i;
        labels = null;
    }

    private void addLabel(String s)
    {
        this.labels.add(s);
    }

    protected boolean checkLabels(int[][] temp, int r, int c) {
        ArrayList<String> labels = this.getLabels();
        if (labels.contains("Square"))
        {
            if (!Square.isSquare(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Rectangular"))
        {
            if (!Rectangular.isRectangular(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Ones"))
        {
            if (!Ones.isOnes(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Null"))
        {
            if (!Null.isNull(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Row"))
        {
            if (!Row.isRow(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Column"))
        {
            if (!Column.isColumn(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Upper Triangular"))
        {
            if (!UpperTrian.isUpperTrian(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Lower Triangular"))
        {
            if (!LowerTrian.isLowerTrian(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Symmetric"))
        {
            if (!Symmetric.isSymmetric(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Skew-Symmetric"))
        {
            if (!SkewSymmetric.isSkewSymmetric(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Singular"))
        {
            if (!Singular.isSingular(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Singleton"))
        {
            if (!Singleton.isSingleton(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Diagonal"))
        {
            if (!Diagonal.isDiagonal(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Scalar"))
        {
            if (!Scalar.isScalar(temp, r, c))
            {
                return false;
            }
        }
        if (labels.contains("Identity"))
        {
            if (!Identity.isIdentity(temp, r, c))
            {
                return false;
            }
        }
        return true;
    }

    private void updateLabels() {
        ArrayList<String> labels = this.getLabels();
        int[][] temp = this.getData();
        int r = this.getRows();
        int c = this.getColumns();

        if (!labels.contains("Square"))
        {
            if (Square.isSquare(temp, r, c))
            {
                this.addLabel("Square");
            }
        }
        if (!labels.contains("Rectangular"))
        {
            if (Rectangular.isRectangular(temp, r, c))
            {
                this.addLabel("Rectangular");
            }
        }
        if (!labels.contains("Ones"))
        {
            if (Ones.isOnes(temp, r, c))
            {
                this.addLabel("Ones");
            }
        }
        if (!labels.contains("Null"))
        {
            if (Null.isNull(temp, r, c))
            {
                this.addLabel("Null");
            }
        }
        if (!labels.contains("Row"))
        {
            if (Row.isRow(temp, r, c))
            {
                this.addLabel("Row");
            }
        }
        if (!labels.contains("Column"))
        {
            if (Column.isColumn(temp, r, c))
            {
                this.addLabel("Column");
            }
        }
        if (!labels.contains("Upper Triangular"))
        {
            if (UpperTrian.isUpperTrian(temp, r, c))
            {
                this.addLabel("Upper Triangular");
            }
        }
        if (!labels.contains("Lower Triangular"))
        {
            if (LowerTrian.isLowerTrian(temp, r, c))
            {
                this.addLabel("Lower Triangular");
            }
        }
        if (!labels.contains("Symmetric"))
        {
            if (Symmetric.isSymmetric(temp, r, c))
            {
                this.addLabel("Symmetric");
            }
        }
        if (!labels.contains("Skew-Symmetric"))
        {
            if (SkewSymmetric.isSkewSymmetric(temp, r, c))
            {
                this.addLabel("Skew-Symmetric");
            }
        }
        if (!labels.contains("Singular"))
        {
            if (Singular.isSingular(temp, r, c))
            {
                this.addLabel("Singular");
            }
        }
        if (!labels.contains("Singleton"))
        {
            if (Singleton.isSingleton(temp, r, c))
            {
                this.addLabel("Singleton");
            }
        }
        if (!labels.contains("Diagonal"))
        {
            if (Diagonal.isDiagonal(temp, r, c))
            {
                this.addLabel("Diagonal");
            }
        }
        if (!labels.contains("Scalar"))
        {
            if (Scalar.isScalar(temp, r, c))
            {
                this.addLabel("Scalar");
            }
        }
        if (!labels.contains("Identity"))
        {
            if (Identity.isIdentity(temp, r, c))
            {
                this.addLabel("Identity");
            }
        }
    }

    protected abstract void changeValue(int i, int j, int a);

    public void edit() {
        int[][] A = this.getData();
        int[][] temp = new int[this.getRows()][this.getColumns()];

        Matrix.arrayCopy(temp, A);

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                System.out.println(A[i][j]);
            }
        }
        int r, c, a, ch = 0;
        do{
            System.out.println("Which element do you want to change?");
            System.out.print("Row: ");
            r = scan.nextInt();
            System.out.print("Column: ");
            c = scan.nextInt();
            if (r>=A.length || c>=A[0].length)
            {
                System.out.print("Out of bounds row and column entered. Try again!");
                continue;
            }
            System.out.print("Enter the element: ");
            a = scan.nextInt();
            temp[r][c] = a;
            if (this.checkLabels(temp, this.getRows(), this.getColumns()))
            {
                this.changeValue(r, c, a);
                A = this.getData();
                System.out.print("Edited successfully!");
                this.updateLabels();
            }
            else{
                System.out.print("Making this change will change the type of the matrix. Cannot edit!");
            }
            Matrix.arrayCopy(temp, A);
            System.out.print("Do you want to continue editing? (1 for yes / 2 for no)");
            ch = scan.nextInt();
        } while(ch==1);
    }

    public static void arrayCopy(int[][] des, int[][] src)
    {
        for (int i=0; i<src.length; i++)
        {
            System.arraycopy(src[i], 0, des[i], 0, src[i].length);
        }
    }

    public void setLabels(ArrayList<String> list)
    {
        if (labels==null) {
            labels = list;
        }
    }
    public ArrayList<String> getLabels()
    {
        return labels;
    }

    public int getId()
    {
        return this.id;
    }

    public abstract int[][] getData();

    public int[][] add(Matrix other)
    {
        if(other instanceof Ones || other instanceof Null || other instanceof Diagonal)
        {
            return other.add(this);
        }

        if (this.rows!=other.getRows() || this.columns!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't add");
            return null;
        }

        int[][] sum = new int[this.rows][this.columns];
        int[][] A = this.getData();
        int[][] B = other.getData();

        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }
        return sum;
    }

    public int[][] subtract(Matrix other)
    {
        if (this.rows!=other.getRows() || this.columns!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't add");
            return null;
        }

        int[][] diff = new int[this.rows][this.columns];
        int[][] A = this.getData();
        int[][] B = other.getData();

        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                diff[i][j] = A[i][j] + B[i][j];
            }
        }
        return diff;
    }

    public int getRows()
    {
        return this.rows;
    }

    public int getColumns()
    {
        return this.columns;
    }

    public float[][] division(Matrix other)
    {
        if (other instanceof Rectangular)
        {
            System.out.println("Cannot divide by rectangular matrix");
            return null;
        }
        if (other instanceof Singular)
        {
            System.out.println("Cannot divide by singular matrix");
            return null;
        }
        //int[][] A = this.getData();
        //Matrix B = new Square(other.getRows(), other.getColumns(), other.getData());
        //int[][] B = other.inverse();
        float[][] temp = new float[this.rows][this.columns];
        int[][] A = this.getData();
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                temp[i][j] =(float)A[i][j];
            }
        }
        return multiply2D(temp, other.inverse(), this.getRows(), this.getColumns(), other.getRows(), other.getColumns());
    }

    public int[][] multiply(Matrix other)
    {
        if (this.getRows()!=other.getColumns() || this.getColumns()!=other.getRows())
        {
            System.out.println("Multiplication dimensions incorrect");
            return null;
        }
        if (other instanceof Null || other instanceof Identity)
        {
            return other.multiply(this);
        }
        if (other instanceof Column)
        {
            return ((Column) other).postMultiply(this);
        }
        int[][] product = new int[this.rows][other.getColumns()];
        int productRows = this.rows;
        int productColumns = other.getColumns();
        int answer;
        int[][] A = this.getData();
        int[][] B = other.getData();

        for (int i=0; i<productRows; i++)
        {
            for (int j=0; j<productColumns; j++)
            {   answer = 0;
                for (int k=0; k<this.columns; k++)
                {
                    answer+=A[i][k]*B[k][j];
                }
                product[i][j] = answer;
            }
        }
        return product;
    }

    public int[][] elementMul(Matrix other)
    {
        if (other instanceof Ones || other instanceof Null)
        {
            return other.elementMul(this);
        }
        if (this.rows!=other.getRows() || this.columns!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't do element-wise multiplication");
            return null;
        }

        int[][] ans = new int[this.rows][this.columns];
        int[][] A = this.getData();
        int[][] B = other.getData();

        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                ans[i][j] = A[i][j]*B[i][j];
            }
        }
        return ans;
    }
    public float[][] elementDiv(Matrix other)
    {
        if (other instanceof Null)
        {
            System.out.println("Can't divide element-wise by null matrix");
            return null;
        }

        if (other instanceof Ones)
        {
            float[][] ans = new float[this.rows][this.columns];
            return null;
        }

        if (this.rows!=other.getRows() || this.columns!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't do element-wise division");
            return null;
        }

        float[][] ans = new float[this.rows][this.columns];
        int[][] A = this.getData();
        int[][] B = other.getData();

        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                ans[i][j] = (float)A[i][j]/(float)B[i][j];
            }
        }
        return ans;
    }

    public int[][] transpose()
    {
        int[][] transpose = new int[this.columns][this.rows];
        int[][] A = this.getData();
        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }

    public float rowMean(int row)
    {
        int[][] A = this.getData();
        float answer = 0;

        for (int i=0; i<this.columns; i++)
        {
            answer+=A[row][i];
        }
        answer/=this.columns;
        return answer;
    }

    public float colMean(int col)
    {
        int[][] A = this.getData();
        float answer = 0;

        for (int i=0; i<this.rows; i++)
        {
            answer+=A[i][col];
        }
        answer/=this.rows;
        return answer;
    }

    public float allMean()
    {
        int[][] A = this.getData();
        float answer = 0;

        for (int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; i++)
            {
                answer+=A[i][j];
            }
        }
        answer=answer/(this.rows*this.columns);
        return answer;
    }

    public int[][] APlusAt()
    {
        int[][] A = this.getData();
        int[][] B = this.transpose();

        int[][] answer = new int[this.rows][this.columns];

        for(int i=0; i<this.rows; i++)
        {
            for (int j=0; j<this.columns; j++)
            {
                answer[i][j] = A[i][j]+B[i][j];
            }
        }
        return answer;
    }

    public float[][] solveEq(Matrix other)
    {
        System.out.println("The first matrix is not square and hence linear equation can't be solved");
        return null;
    }

    public float[][] inverse()
    {
        System.out.println("This matrix is not square and inverse cannot be calculated");
        return null;
    }

    public float determinant()
    {
        System.out.println("This matrix is not square and determinant cannot be calculated");
        return Integer.MIN_VALUE;
    }

    public static float[][] multiply2D(float[][] A, float[][] B, int Ar, int Ac, int Br, int Bc)
    {
        if (Ar!=Bc || Ac!=Br)
        {
            System.out.println("Multiplication dimensions incorrect");
            return null;
        }
        float[][] product = new float[Ar][Bc];
        int answer;

        for (int i = 0; i< Ar; i++)
        {
            for (int j = 0; j< Bc; j++)
            {   answer = 0;
                for (int k=0; k<Ac; k++)
                {
                    answer+=A[i][k]*B[k][j];
                }
                product[i][j] = answer;
            }
        }

        return product;
    }

    public static float[][] multiplybyScalar(float[][] A, float B, int r, int c)
    {
        float[][] answer = new float[r][c];
        for(int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                answer[i][j] = A[i][j]/B;
            }
        }
        return answer;
    }

    public float[][] SingletonAsScalar(Matrix other, int mode)
    {
        if (this.getRows()==1 && this.getColumns()==1)
        {
            if(this.getData()[0][0]==1) {
                Singleton S = new Singleton(1, -1);
                float[][] res = S.SingletonAsScalar(other, mode);
                S = null;
                return res;
            }
            if(this.getData()[0][0]==0) {
                Singleton S = new Singleton(0, -1);
                float[][] res = S.SingletonAsScalar(other, mode);
                S = null;
                return res;
            }
        }
        System.out.println("The matrix is not singleton hence this operation cannot be performed");
        return null;
    }

    public float[] eigenvalues()
    {
        System.out.println("The matrix is not square hence this eigenvalues cannot be found");
        return null;
    }
}
