package Assgn3;

public class Singular extends Square{
    Singular(int r, int[][] data, int id) {
        super(r, data, id);
    }

    @Override
    public float determinant()
    {
        return 0;
    }

    @Override
    public float[][] inverse()
    {
        System.out.println("Singular matrices do not have an inverse");
        return null;
    }
}
