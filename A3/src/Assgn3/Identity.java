package Assgn3;

public class Identity extends Scalar{
    Identity(int r, int id) {
        super(r, 1, id);
    }

    @Override
    public int[][] getData()
    {
        int[][] ans = new int[this.getRows()][this.getColumns()];
        for(int i=0; i<this.getRows(); i++)
        {
            for(int j=0; j<this.getColumns(); j++)
            {
                if (i==j)
                {
                    ans[i][j] = 1;
                }
                else
                {
                    ans[i][j] = 0;
                }
            }
        }
        return ans;
    }

    @Override
    public float determinant()
    {
        return 1;
    }

    @Override
    public int[][] multiply(Matrix other)
    {
        return other.getData();
    }

    @Override
    public float[][] inverse()
    {
        float[][] ans = new float[this.getRows()][this.getColumns()];
        int[][] A = this.getData();
        for(int i=0; i<this.getRows(); i++)
        {
            for(int j=0; j<this.getColumns(); j++)
            {
                ans[i][j] = (float)A[i][j];
            }
        }
        return ans;
    }

    @Override
    public float rowMean(int row)
    {
        return (float) (1.0/this.getRows());
    }

    @Override
    public float colMean(int col)
    {
        return (float) (1.0/this.getRows());
    }

    @Override
    public float allMean()
    {
        return 1;
    }

    @Override
    public float[] eigenvalues()
    {
        float[] ans = new float[2];
        ans[0] = 1;
        ans[1] = 1;

        return ans;
    }
}
