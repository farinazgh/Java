import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnotherThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        /*
        java.lang.ThreadGroup[name=main,maxpri=10]
        1
        main
        5
        RUNNABLE
         */

        Runnable task =()->{
            System.out.println("hello world!");
        };
        //this is obselete relace it with ExecutorService
        Thread thread=new Thread(task);
        thread.start();
        System.out.println(thread.getThreadGroup());
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());
        /*
        java.lang.ThreadGroup[name=main,maxpri=10]
        15
        Thread-0
        5
        RUNNABLE
        hello world!
         */
        ExecutorService service= Executors.newSingleThreadExecutor();
        Runnable exec =()->{
            System.out.println("hello Executors!");
        };
        service.submit(exec);
        System.out.println(service.isTerminated());
    }
}
