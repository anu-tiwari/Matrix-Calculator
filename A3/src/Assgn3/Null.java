package Assgn3;

public class Null extends Matrix{
    Null(int r, int c) {
        super(r, c);
    }

    @Override
    public int[][] getData() {
        return new int[0][];
    }

    @Override
    public int[][] add(Matrix other) {
        return null;
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
