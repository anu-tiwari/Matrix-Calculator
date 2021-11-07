package Assgn3;

public class Rectangular extends Matrix{
    private int[][] data;

    Rectangular(int r, int c, int[][] data, int id) {
        super(r, c, id);
        if (data!=null) {
            this.data = new int[this.getRows()][this.getColumns()];

            for (int i = 0; i < this.getRows(); i++) {
                System.arraycopy(data[i], 0, this.data[i], 0, this.getColumns());
            }
        }
        else
        {
            this.data = null;
        }
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        this.data[i][j] = a;
    }

    public static boolean isRectangular(int[][] A, int r, int c)
    {
        return r != c;
    }

    @Override
    public void edit() {

    }

    @Override
    public int[][] getData() {
        return data;
    }
}
