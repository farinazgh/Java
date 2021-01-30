package com.modernjava;

import java.util.stream.Stream;

public class ParallelStreams {
    /*
    This operation seems to be a good candidate to use parallelization,
    especially for large values of n.
    But where do you start?
    Do you synchronize on the result variable?
    How many threads do you use?
    Who does the generation of numbers?
    Who adds them up?
     */
    public static long sequentialSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(int n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(sequentialSum(10));
        System.out.println(parallelSum(10));
        /*
        Parallel streams internally use the default ForkJoinPool,
        which by default has as many threads as you have processors*/
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
