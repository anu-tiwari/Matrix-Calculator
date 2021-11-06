package Assgn3;

public class Symmetric extends Square{
    Symmetric(int r, int[][] data, int id) {
        super(r, data, id);
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
