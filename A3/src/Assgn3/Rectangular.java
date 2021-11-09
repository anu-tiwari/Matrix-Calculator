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

    public static int[][] create(int r, int c)
    {
        int[][] arr = new int[r][c];
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                arr[i][j] = random.nextInt(20);
            }
        }
        return arr;
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
