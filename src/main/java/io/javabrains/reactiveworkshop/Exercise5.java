package io.javabrains.reactiveworkshop;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err),
                () -> System.out.println("Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(){
        System.out.println("Subscribed");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println("value received "+value);
    }

    public void hookOnComplete(){
        System.out.println("Completed MySubscriber");
    }
}