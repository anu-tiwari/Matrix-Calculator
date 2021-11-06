package Assgn3;

public class Rectangular extends Matrix{
    private int[][] data;

    Rectangular(int r, int c, int[][] data, int id) {
        super(r, c, id);
        this.data = new int[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            System.arraycopy(data[i], 0, this.data[i], 0, this.getColumns());
        }
    }

    @Override
    public int[][] getData() {
        return new int[0][];
    }
}
