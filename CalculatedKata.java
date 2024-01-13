package Kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatedKata {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CalculatedKata.calc(scanner.nextLine());
    }

    public static String calc(String input) throws Exception {

        Map<String, Integer> rimNumbers = new HashMap<>();
        rimNumbers.put("I", 1);
        rimNumbers.put("II", 2);
        rimNumbers.put("III", 3);
        rimNumbers.put("IV", 4);
        rimNumbers.put("V", 5);
        rimNumbers.put("VI", 6);
        rimNumbers.put("VII", 7);
        rimNumbers.put("VIII", 8);
        rimNumbers.put("IX", 9);
        rimNumbers.put("X", 10);
        rimNumbers.put("XL", 40);
        rimNumbers.put("L", 50);
        rimNumbers.put("XC", 90);
        rimNumbers.put("C", 100);


        String[] massive = input.split(" ");
        if (massive.length > 3) {
            throw new Exception();
        }
        int result = 0;
        String rimOutput = "";
        int num1, num2;
        StringBuilder rimResult = new StringBuilder();
        String rimNum1 = "", rimNum2 = "";

        if (!(rimNumbers.containsKey(massive[0]) || !(rimNumbers.containsKey(massive[2])))) {
            throw new Exception();
        }

        if (massive[0].matches("[-+]?\\d+") && massive[2].matches("[-+]?\\d+") || rimNumbers.containsKey(massive[0]) && rimNumbers.containsKey(massive[2])) {

            if (rimNumbers.containsKey(massive[0]) && rimNumbers.containsKey(massive[2])) {
                num1 = rimNumbers.get(massive[0]);
                num2 = rimNumbers.get(massive[2]);
                rimNum1 = massive[0];
                rimNum2 = massive[2];

            } else {
                num1 = Integer.parseInt(massive[0]);
                num2 = Integer.parseInt(massive[2]);
            }

            if (num1 > 10 || num2 > 10 || num1 == 0 || num2 == 0) {
                throw new Exception();
            }

            switch (massive[1]) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    if(!(rimNum1.isEmpty() && rimNum2.isEmpty()) && num1 < num2) {
                        throw new Exception();
                    }
                    result = num1 - num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
            }
            if ( rimNumbers.containsKey(rimNum1) && rimNumbers.containsKey(rimNum2)) {

                if (result >= 40 && result < 50) {
                    rimResult.append("XL");
                    result -= 40;
                }

                if ( result != 90 && result != 100 ) {

                    if (result - 50 >= 0) {
                        result -= 50;
                        rimResult.append("L");
                    }

                    while (result - 10 >= 0) {
                        result -= 10;
                        rimResult.append("X");
                    }

                }

                for (Map.Entry<String, Integer> temp : rimNumbers.entrySet()) {
                    if (result == temp.getValue()) {
                        rimOutput = temp.getKey();
                        rimResult.append(rimOutput);
                        break;
                    }
                }
                System.out.println(rimResult.toString());
                return rimResult.toString();

            } else {
                System.out.println(result);
                return Integer.toString(result);
            }
        } else {
            throw new Exception();
        }
    }
}

