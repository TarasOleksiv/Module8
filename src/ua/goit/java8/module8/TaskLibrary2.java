package ua.goit.java8.module8;


import ua.goit.java8.module8.libraries.Library2;

/**
 * Created by Taras on 06.09.2017.
 */
public class TaskLibrary2 {
    private static int peopleCount;
    private static int maxAmount;

    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner();
        peopleCount = myScanner.getPeopleCount();
        maxAmount = myScanner.getMaxAmount();

        System.out.println();
        System.out.println("************* TaskLibrary2 ********************");
        System.out.println();
        Library2 library2 = new Library2(peopleCount,maxAmount);
        try {
            library2.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
