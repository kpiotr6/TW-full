package all;


import all.operations.AbstractOperation;
import all.scheduler.Scheduler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<List<AbstractOperation>> foata = Reader.readFoata();
        double[][] matrix = Reader.readTest();
        Scheduler s = new Scheduler(matrix,foata);
        s.runAll();
        for(double[] m:matrix){
            System.out.println(Arrays.toString(m));
        }
        Reader.writeTest(matrix);

    }
}