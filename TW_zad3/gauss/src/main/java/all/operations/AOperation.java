package all.operations;

// Klasa reprezentująca operację A
public class AOperation extends AbstractOperation{
//    mMatrix służy do przechowywania cząstkowych wartości obliczeń m
    private double[][] mMatrix;
    public AOperation(int i, int k) {
        super(i, k);
    }

    public void setmMatrix(double[][] mMatrix) {
        this.mMatrix = mMatrix;
    }

    @Override
    public double[][] call() {
        mMatrix[k][i] = matrix[k][i]/matrix[i][i];
        return matrix;
    }



}
