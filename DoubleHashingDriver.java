package rsn170330.sp07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DoubleHashingDriver {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc;
        File file = new File(args[0]);
        sc = new Scanner(file);
        String operation;
        int operand;
        long modValue = 1000000009;
        long result = 0;

        Timer timer = new Timer();
        Set<Integer> set = new HashSet<>();
        while (!((operation = sc.next()).equals("End"))) {
            switch (operation) {
                case "Add": {
                    operand = sc.nextInt();
                    if(set.add(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                case "Remove": {
                    operand = sc.nextInt();
                    if (set.remove(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                case "Contains":{
                    operand = sc.nextInt();
                    if (set.contains(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println();
        System.out.println("HashSet result : "+ result);
        System.out.println("HashSet size : "+ set.size());
        System.out.println(timer.end());

        file = new File(args[0]);
        sc = new Scanner(file);
        result = 0;

        timer.start();
        DoubleHashing<Integer> dm = new DoubleHashing<>();
        while (!((operation = sc.next()).equals("End"))) {
            switch (operation) {
                case "Add": {
                    operand = sc.nextInt();
                    if(dm.add(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                case "Remove": {
                    operand = sc.nextInt();
                    if (!dm.remove(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                case "Contains":{
                    operand = sc.nextInt();
                    if (dm.contains(operand)) {
                        result = (result + 1) % modValue;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println();
        System.out.println("Double Hashing result : "+ result);
        System.out.println("Double Hashing size : "+ dm.size());
        System.out.println(timer.end());

    }
}