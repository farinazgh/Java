import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Supplier<String> task = () -> "asynchronous thread name: " + Thread.currentThread().getName();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(task);

        System.out.println(completableFuture.get());
        completableFuture.complete(null);
    }
}
