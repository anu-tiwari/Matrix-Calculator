package Assgn3;

public class Scalar extends Diagonal{
    private int element;

    Scalar(int r, int element, int id) {
        super(r, null, id);
        this.element = element;
    }

    public static boolean isScalar(int[][] A, int r, int c)
    {
        if (!Diagonal.isDiagonal(A, r, c))
            return false;

        if (r==1 && c==1)
            return true;
        else if(r==2 && c==2) {
            return A[0][0] == A[1][1];
        }
        else if (r==3 && c==3)
        {
            return A[0][0] == A[1][1] && A[1][1] == A[2][2];
        }
        return false;
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
                    ans[i][j] = this.element;
                }
                else
                {
                    ans[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public float determinant()
    {
        return (float) Math.pow(this.element, this.getRows());
    }

    @Override
    public float rowMean(int row)
    {
        return (float) (this.element/this.getRows());
    }

    @Override
    public float colMean(int col)
    {
        return (float) (this.element/this.getRows());
    }

    @Override
    public float allMean()
    {
        return this.element;
    }
}
