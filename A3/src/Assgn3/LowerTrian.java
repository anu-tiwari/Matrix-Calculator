package Assgn3;

public class LowerTrian extends Square{
    LowerTrian(int r, int[][] data, int id) {
        super(r, data, id);
    }

    public static boolean isLowerTrian(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        for (int i=0; i<r; i++)
        {
            for (int j=i+1; j<c; j++)
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
    public float determinant()
    {
        int[][] A = this.getData();
        float d = 1;
        for (int i=0; i<this.getRows(); i++)
        {
            d*=A[i][i];
        }
        return d;
    }
}
