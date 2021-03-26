import java.util.concurrent.CompletableFuture;

public class CompletableFutureRunnable {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> System.out.println("asynchronous thread name: " + Thread.currentThread().getName());
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(task);
        completableFuture.complete(null);
    }
}
    /*
    instead of Future future = executor.submit()
    Callable <String> task = () -> "hello completableFuture with callable!";
    executor.submit(task);
    does not work with Callable
    asynchronous thread name: ForkJoinPool.commonPool-worker-19
    */