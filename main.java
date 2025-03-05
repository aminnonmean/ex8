import java.util.Random;
import java.util.Scanner;

public class main {
    public static final int SIZE = 8;

    public static void main (String[] args) {
        int[][] numbers = new int[SIZE][SIZE];
        int[][] finalNums = new int[SIZE][SIZE];
        int[][] result = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                numbers[i][j] = random.nextInt(256);
            }
        }
        outPut(numbers);
        System.out.println("Выберите функцию:\n " +
                "1)Развернуть на 90 градусов\n " +
                "2)Развернуть на 180 градусов\n " +
                "3) Развернуть на 270 градусов\n");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        switch (answer) {
            case "1":
                result = turn90(numbers, finalNums);

            case "2":
                finalNums = turn90(numbers,finalNums);
                result = turn90(finalNums, numbers);
            case "3":
                finalNums = turn90(numbers,finalNums);
                result = turn90(finalNums,numbers);
                result = turn90(result, finalNums);
        }


        System.out.println();
        outPut(result);
    }

    public static void outPut(int[][] numbers) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%4d", numbers[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] turn90(int[][] numbers, int[][] finalNums) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int a = i;
                int b = j;
                finalNums[b][7 - a] = numbers[i][j];
            }
        }
        return finalNums;
    }
}
