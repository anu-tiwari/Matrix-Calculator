package Assgn3;

public class Null extends Matrix{
    Null(int r, int c, int id) {
        super(r, c, id);
    }

    @Override
    public int[][] getData() {
        int[][] answer = new int[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                answer[i][j] = 0;
            }
        }
        return answer;
    }

    @Override
    public int[][] add(Matrix other) {
        if (this.getRows()!=other.getRows() || this.getColumns()!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't add");
            return null;
        }
        return other.getData();
    }

    @Override
    public int[][] elementMul(Matrix other) {
        return new int[0][];
    }

    @Override
    public float[][] elementDiv(Matrix other) {
        return new float[0][];
    }
}
