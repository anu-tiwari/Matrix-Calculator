package Assgn3;

public class Ones extends Matrix{
    Ones(int r, int c, int id) {
        super(r, c, id);
    }

    public static boolean isOnes(int[][] A, int r, int c)
    {
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                if (A[i][j]!=1)
                    return false;
            }
        }
        return true;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
    }

    @Override
    public void edit()
    {
        System.out.println("This is a ones matrix thus it can't be edited");
    }

    @Override
    public int[][] getData() {
        int[][] answer = new int[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                answer[i][j] = 1;
            }
        }
        return answer;
    }

    @Override
    public int[][] add(Matrix other) {
        if (this.getRows()!=other.getRows() || this.getColumns()!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't add");
            return null;
        }

        int[][] sum = new int[this.getRows()][other.getColumns()];
        int[][] A = other.getData();

        for(int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                sum[i][j] = A[i][j]+1;
            }
        }
        return sum;
    }

    @Override
    public int[][] elementMul(Matrix other) {
        if (this.getRows()!=other.getRows() || this.getColumns()!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't multiply element-wise");
            return null;
        }

        return this.getData();
    }

    @Override
    public float rowMean(int row)
    {
        return 1;
    }

    @Override
    public float colMean(int col)
    {
        return 1;
    }

    @Override
    public float allMean()
    {
        return 1;
    }

    @Override
    public float determinant()
    {
        if (this.getRows()!=this.getColumns())
        {
            System.out.println("This matrix is not square and determinant cannot be calculated");
            return Integer.MIN_VALUE;
        }
        if (this.getRows()==1 && this.getColumns()==1)
        {
            return 1;
        }
        return 0;
    }

    public float[][] inverse()
    {
        if (this.getRows()!=this.getColumns())
        {
            System.out.println("This matrix is not square and inverse cannot be calculated");
            return null;
        }
        System.out.println("This matrix is not singular and inverse cannot be calculated");
        return null;
    }

    public float[][] solveEq(Matrix other)
    {
        if (this.getRows()!=this.getColumns())
        {
            System.out.println("The first matrix is not square and hence linear equation can't be solved");
            return null;
        }
        System.out.println("The first matrix is singular and hence linear equation can't be solved");
        return null;
    }
}
