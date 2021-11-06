package Assgn3;

public class Symmetric extends Square{
    Symmetric(int r, int[][] data, int id) {
        super(r, data, id);
    }

    public static boolean isSymmetric(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (A[i][j]!=A[j][i])
                    return false;
            }
        }
        return true;
    }

    @Override
    public int[][] transpose()
    {
        return this.getData();
    }

    @Override
    public int[][] APlusAt()
    {
        int[][] t = new int[this.getRows()][this.getColumns()];
        int[][] A = this.getData();

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                t[i][j] = 2*A[i][j];
            }
        }
        return t;
    }
}
