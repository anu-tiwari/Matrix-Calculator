package Assgn3;

public class UpperTrian extends Square{
    UpperTrian(int r, int[][] data, int id) {
        super(r, data, id);
    }

    public static boolean isUpperTrian(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (A[i][j]!=0)
                    return false;
            }
        }
        return true;
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
