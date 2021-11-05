package Assgn3;

public class Square extends Matrix{
    int[][] data;

    Square(int r, int c, int[][] data)
    {
        super(r,c);
        this.data = data;
    }

    @Override
    public int[][] getData() {
        return new int[0][];
    }

    @Override
    public void add(Matrix other) {

    }

    @Override
    public int[][] elementMul(Matrix other) {
        return new int[0][];
    }

    @Override
    public int[][] elementDiv(Matrix other) {
        return new int[0][];
    }
}
