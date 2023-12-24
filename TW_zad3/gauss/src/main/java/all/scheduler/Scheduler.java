package all.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import all.operations.AOperation;
import all.operations.AbstractOperation;
import all.operations.BOperation;
import all.operations.COperation;
// Klasa służy do wykonywania operacji według FNF
public class Scheduler {
    private double[][] matrix;
    private double[][] mMatrix;
    private double[][] nMatrix;
    private List<List<AbstractOperation>> operations;

    public Scheduler(double[][] matrix, List<List<AbstractOperation>> operations) {
        this.matrix = matrix;
        this.operations = operations;
        int n = matrix.length;
        mMatrix = new double[n+1][n+1];
        nMatrix = new double[n+1][n+1];
    }

    public double[][] runAll() throws InterruptedException{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(List<AbstractOperation> operationPacket: operations){
            for(AbstractOperation operation:operationPacket){
                operation.setMatrix(this.matrix);
                if(operation instanceof AOperation){
                    ((AOperation) operation).setmMatrix(mMatrix);
                }
                if(operation instanceof COperation){
                    ((COperation) operation).setnMatrix(nMatrix);
                }
                if(operation instanceof BOperation){
                    ((BOperation) operation).setnMatrix(nMatrix);
                    ((BOperation) operation).setmMatrix(mMatrix);
                }
            }
        }
        for(List<AbstractOperation> operationPacket: operations){
            List<Future<double[][]>> s = executorService.invokeAll(operationPacket);
            while(executorService.awaitTermination(1, TimeUnit.SECONDS));
        }
        executorService.shutdownNow();
        return matrix;
    }
}
