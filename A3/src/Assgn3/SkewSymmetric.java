package Assgn3;

public class SkewSymmetric extends Square{
    SkewSymmetric(int r, int[][] data, int id) {
        super(r, data, id);
    }

    public static boolean isSkewSymmetric(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (A[i][j]!=(-1)*A[j][i])
                    return false;
            }
        }
        return true;
    }

    @Override
    public int[][] APlusAt()
    {
        Null temp = new Null(this.getRows(), this.getColumns(), -1);
        int[][] tr = temp.getData();
        temp = null;
        return tr;
    }

    @Override
    public int[][] transpose()
    {
        int[][] t = new int[this.getRows()][this.getColumns()];
        int[][] A = this.getData();

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                t[i][j] = (-1)*A[i][j];
            }
        }
        return t;
    }
}
