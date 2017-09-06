package ua.goit.java8.module8;

import java.util.Scanner;

/**
 * Created by Taras on 06.09.2017.
 */
public class MyScanner {
    private int peopleCount;
    private int maxAmount;

    public MyScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість відвідувачів бібліотеки:");
        peopleCount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть вмістимість бібліотеки:");
        maxAmount = scanner.nextInt();
        scanner.nextLine();
    }

    public int getPeopleCount(){
        return peopleCount;
    }

    public int getMaxAmount(){
        return maxAmount;
    }
}
