package Assgn3;

public abstract class Matrix {
    private final int id;
    private final int rows;
    private final int columns;
    //int[][] entries;

    Matrix(int r, int c, int i)
    {
        this.rows = r;
        this.columns = c;
        this.id = i;
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
        return 0;
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
        System.out.println("The matrix is not singleton hence this operation cannot be performed");
        return null;
    }

    public float[] eigenvalues()
    {
        System.out.println("The matrix is not square hence this eigenvalues cannot be found");
        return null;
    }
}
