package ua.goit.java8.module8.libraries;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Taras on 06.09.2017.
 */
public class Library2 {
    private int peopleCount;
    private int maxAmount;
    private final Semaphore semaphore;
    private final Semaphore semaphoreDoor = new Semaphore(1,true);

    public Library2(int peopleCount, int maxAmount){
        this.peopleCount = peopleCount;
        this.maxAmount = maxAmount;
        semaphore = new Semaphore(maxAmount, true);
    }

    public void work() throws InterruptedException {
        for (int i = 1; i <= peopleCount; i++) {
            new Thread(new People(i)).start();
            Thread.sleep(400);
        }
    }

    public class People implements Runnable{
        private int peopleNumber;

        public People(int peopleNumber){
            this.peopleNumber = peopleNumber;
        }

        @Override
        public void run() {
            System.out.printf("Людина №%d підійшла до входу в бібліотеку.\n", peopleNumber);

            try {

                if (semaphore.availablePermits() == 0){
                    System.out.printf("Людина №%d чекає біля входу у бібліотеку.\n", peopleNumber);
                }
                semaphore.acquire();

                System.out.printf("Людина №%d підійшла до дверей з вулиці.\n", peopleNumber);

                if (semaphoreDoor.availablePermits() == 0){
                    System.out.printf("Людина №%d чекає біля дверей з вулиці.\n", peopleNumber);
                }

                semaphoreDoor.acquire();
                System.out.printf("Людина №%d проходить через двері всередину.\n", peopleNumber);
                Thread.sleep(500);
                System.out.printf("Людина №%d пройшла через двері всередину.\n", peopleNumber);
                semaphoreDoor.release();

                System.out.printf("Людина №%d зайшла у бібліотеку.\n", peopleNumber);

                System.out.printf("Людина №%d читає книгу.\n", peopleNumber);
                Random rand = new Random();
                Thread.sleep(rand.nextInt(4001) + 1000);       //читаєм книгу

                System.out.printf("Людина №%d підійшла до дверей зсередини.\n", peopleNumber);

                if (semaphoreDoor.availablePermits() == 0){
                    System.out.printf("Людина №%d чекає біля дверей зсередини.\n", peopleNumber);
                }

                semaphoreDoor.acquire();
                System.out.printf("Людина №%d проходить через двері назовні.\n", peopleNumber);
                Thread.sleep(500);
                System.out.printf("Людина №%d пройшла через двері назовні.\n", peopleNumber);
                semaphoreDoor.release();

                semaphore.release();
                System.out.printf("Людина №%d вийшла з бібліотеки.\n", peopleNumber);
            } catch (InterruptedException e) {
            }

        }
    }

}
