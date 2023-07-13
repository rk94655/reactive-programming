package io.javabrains.reactiveworkshop;


import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        //Aproach 1
//        ReactiveSources.intNumbersFluxWithException().subscribe(
//          number -> System.out.println(number),
//          err -> System.out.println("ERROR HAPPENED "+ err.getMessage())
//        );

        //Approach 2 where error will be thrown but if something is to be done on error then it can be done
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println("Error Happened "+ err.getMessage()))
//                        .subscribe(number -> System.out.println(number));

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, item) -> {
//                    System.out.println("Error happened "+ err.getMessage());
//                    System.out.println("item on which error happened "+item);
//                }
//                )
//                        .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err->
                        {
                            System.out.println(err);
                            return Flux.just(-1,-2);
                        }
                )
                .subscribe(System.out::println);

        System.out.println("Press a key to end");


        System.in.read();
    }

}
