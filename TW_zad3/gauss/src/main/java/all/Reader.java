package all;


import all.operations.AOperation;
import all.operations.AbstractOperation;
import all.operations.BOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    public static List<List<AbstractOperation>> readFoata() throws IOException {
        List<List<AbstractOperation>> operations = new LinkedList<>();
        String file = "src/main/resources/foata.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String foataLine = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("\\([^\\)]+\\)");
        Matcher mainMatcher = pattern.matcher(foataLine);
        while(mainMatcher.find()){
            List<AbstractOperation> partFoata = new LinkedList<>();
            String part = mainMatcher.group(0);
            part = part.substring(1);
            part = part.substring(0, part.length() - 1);
            String[] operationStrings = part.split("\\|");
            for (int j = 0; j < operationStrings.length; j++) {
                int a, b, c;
                String[] operationElements = operationStrings[j].split(",");
                switch (operationElements[0].charAt(0)) {
                    case 'A':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[2]);
                        partFoata.add(new AOperation(a, b));
                        break;
                    case 'B':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[2]);
                        c = Integer.parseInt(operationElements[3]);
                        partFoata.add(new BOperation(a, b, c));
                        break;

                    case 'C':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[2]);
                        c = Integer.parseInt(operationElements[3]);
                        partFoata.add(new BOperation(a, b, c));
                        break;

                }
            }
            operations.add(partFoata);
        }
        return operations;
    }
//    public static double[][] readTest(){
//
//    }
}
