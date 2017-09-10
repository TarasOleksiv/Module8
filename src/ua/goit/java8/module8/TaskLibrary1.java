package ua.goit.java8.module8;


import ua.goit.java8.module8.libraries.Library1;

/**
 * Created by Taras on 06.09.2017.
 */
public class TaskLibrary1 {
    private static int peopleCount;
    private static int maxAmount;

    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        peopleCount = myScanner.getPeopleCount();
        maxAmount = myScanner.getMaxAmount();

        System.out.println();
        System.out.println("************* TaskLibrary1 ********************");
        System.out.println();
        Library1 library1 = new Library1(peopleCount,maxAmount);
        try {
            library1.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}