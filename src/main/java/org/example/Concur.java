package org.example;

import java.util.concurrent.*;

public class Concur {


    public static void main(String ...args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CompletableFuture<Integer> even = CompletableFuture.supplyAsync(()->{
            Integer value = 0;

            for(Integer i = 0; i < 10000; i += 2 ){
                System.out.println("even: " +i);
                value += i;

            }


            return value;
        },executorService);


        CompletableFuture<Integer> odd = CompletableFuture.supplyAsync(()->{
            Integer value = 0;

            for(Integer i = 1; i < 10000; i += 2 ){
                System.out.println("odd: " + i);
                value += i;

            }


            return value;
        },executorService);


        CompletableFuture<Integer> result = CompletableFuture.allOf(even, odd).thenApply((x)->{
            Integer sumEven = null;
            try {
                sumEven = even.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Integer  sumOdd = null;
            try {
                sumOdd = odd.get();
            } catch ( Exception e) {
                throw new RuntimeException(e);
            }

            Integer total = sumEven + sumOdd;

               return total;


                }
        );


        System.out.println("final: " +result.get());



    }




}
