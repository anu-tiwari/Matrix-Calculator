package Assgn3;

public class Rectangular extends Matrix{

    Rectangular(int r, int c) {
        super(r, c);
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
