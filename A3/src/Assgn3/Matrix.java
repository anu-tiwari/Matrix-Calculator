package Assgn3;

public abstract class Matrix {
    private int rows;
    private int columns;
    //int[][] entries;

    Matrix(int r, int c)
    {
        this.rows = r;
        this.columns = c;
//        entries = new int[this.rows][this.columns];
//
//        for (int i=0; i<this.rows; i++)
//        {
//            System.arraycopy(arr[i], 0, entries[i], 0, this.columns);
//        }
    }

    public abstract int[][] getData();
    public abstract void add(Matrix other);

    public int getRows()
    {
        return this.rows;
    }

    public int getColumns()
    {
        return this.columns;
    }

    public int[][] division(Matrix other)
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
        Matrix B = new Square(other.getRows(), other.getColumns(), other.getData());
        //int[][] B = other.inverse();

        return this.multiply(B.inverse());
    }

    public int[][] multiply(Matrix other)
    {
        if (this.getRows()!=other.getColumns() || this.getColumns()!=other.getRows())
        {
            System.out.println("Multiplication dimensions incorrect");
            return null;
        }
        if (other instanceof Column)
        {
            other.postMultiply(this);
        }
        int[][] product = new int[this.rows][other.getColumns()];
        int productRows = this.rows;
        int productColumns = other.getColumns();
        int answer = 0;
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

    public abstract int[][] elementMul(Matrix other);
    public abstract int[][] elementDiv(Matrix other);

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

    public float allMean(int col)
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

    public int[][] solveEq(Matrix other)
    {
//        if (other instanceof Column==false)
//        {
//            System.out.println("The second matrix is not a column matrix");
//            return null;
//        }
//        if (other.getRows()!=this.rows)
//        {
//            System.out.println("The second matrix does not have same number of rows as first");
//            return null;
//        }
//        return other.postMultiply(this.inverse());
        System.out.println("This matrix is not square and hence linear equation can't be solved");
        return null;
    }

    public int[][] inverse()
    {
        System.out.println("This matrix is not square and inverse cannot be calculated");
        return null;
    }

    public int determinant()
    {
        System.out.println("This matrix is not square and determinant cannot be calculated");
        return 0;
    }
}
