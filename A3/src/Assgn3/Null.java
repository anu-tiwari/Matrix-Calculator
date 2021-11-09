package Assgn3;

public class Null extends Matrix{
    Null(int r, int c, int id) {
        super(r, c, id);
    }

    public static boolean isNull(int[][] A, int r, int c)
    {
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                if (A[i][j]!=0)
                    return false;
            }
        }
        return true;
    }

    public static int[][] create(int r, int c)
    {
        return null;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {   return; }

    @Override
    public void edit()
    {
        System.out.println("This is a null matrix thus it can't be edited");
    }

    @Override
    public int[][] getData() {
        int[][] answer = new int[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                answer[i][j] = 0;
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
        return other.getData();
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
    public float[][] elementDiv(Matrix other) {
        if (this.getRows()!=other.getRows() || this.getColumns()!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't multiply element-wise");
            return null;
        }
        float[][] quo = new float[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                quo[i][j] = 0;
            }
        }
        return quo;
    }

    @Override
    public int[][] multiply(Matrix other)
    {
        if (this.getRows()!=other.getColumns() || this.getColumns()!=other.getRows())
        {
            System.out.println("Multiplication dimensions incorrect");
            return null;
        }

        return this.getData();
    }

    @Override
    public float rowMean(int row)
    {
        return 0;
    }

    @Override
    public float colMean(int col)
    {
        return 0;
    }

    @Override
    public float allMean()
    {
        return 0;
    }

    @Override
    public float[] eigenvalues()
    {
        float[] ans = new float[2];
        ans[0] = 0;
        ans[1] = 0;

        return ans;
    }

    @Override
    public float determinant()
    {
        if (this.getRows()!=this.getColumns())
        {
            System.out.println("This matrix is not square and determinant cannot be calculated");
            return Integer.MIN_VALUE;
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
