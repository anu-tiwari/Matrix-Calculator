package Assgn3;

public class Ones extends Matrix{
    Ones(int r, int c) {
        super(r, c);
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
