package Assgn3;

public class Ones extends Matrix{
    Ones(int r, int c, int id) {
        super(r, c, id);
    }

    @Override
    public int[][] getData() {
        int[][] answer = new int[this.getRows()][this.getColumns()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                answer[i][j] = 1;
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

        int[][] sum = new int[this.getRows()][other.getColumns()];
        int[][] A = other.getData();

        for(int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                sum[i][j] = A[i][j]+1;
            }
        }
        return sum;
    }

    @Override
    public int[][] elementMul(Matrix other) {
        if (this.getRows()!=other.getRows() || this.getColumns()!=other.getColumns())
        {
            System.out.println("Dimensions not same so can't multiply element-wise");
            return null;
        }

        return this.getData();
    }
}