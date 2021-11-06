package Assgn3;

public class LowerTrian extends Square{
    LowerTrian(int r, int[][] data, int id) {
        super(r, data, id);
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
