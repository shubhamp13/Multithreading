package future.methods;

import java.util.concurrent.*;

public class GetDemo {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {  // Optimized prime check
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        // Use optimal thread count based on CPU cores
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numThreads);

        // Divide work equally across multiple tasks
        Callable<Integer> task1 = () -> countPrimesInRange(1, 100000);
        Callable<Integer> task2 = () -> countPrimesInRange(100001, 200000);
        Callable<Integer> task3 = () -> countPrimesInRange(200001, 300000);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);
        Future<Integer> future3 = service.submit(task3);

        int totalPrimes = future1.get() + future2.get() + future3.get();

        long endTime = System.currentTimeMillis();
        System.out.println("Total prime numbers: " + totalPrimes);
        System.out.println("Execution time: " + (endTime - startTime) + "ms");

        service.shutdown();
    }

    private static int countPrimesInRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
}
