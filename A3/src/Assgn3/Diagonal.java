package Assgn3;

public class Diagonal extends Square{
    private int[] elements;

    Diagonal(int r, int[] elements, int id) {
        super(r, null, id);
        if (r >= 0) System.arraycopy(elements, 0, this.elements, 0, r);
    }

    public static boolean isDiagonal(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                if (i!=j)
                {
                    if (A[i][j]!=0)
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        this.elements[i] = a;
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
                    ans[i][j] = this.elements[i];
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
        float product = 1;
        for (int i=0; i<this.getRows(); i++)
        {
            product*=this.elements[i];
        }
        return product;
    }

    @Override
    public int[][] transpose()
    {
        return this.getData();
    }

    @Override
    public float rowMean(int row)
    {
        return (float) (this.elements[row]/this.getRows());
    }

    @Override
    public float colMean(int col)
    {
        return (float) (this.elements[col]/this.getColumns());
    }

    @Override
    public float allMean()
    {
        int sum = 0;
        for (int element: elements)
        {
            sum+=element;
        }
        return (float)sum/this.getRows();
    }
}
