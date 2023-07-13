package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(number-> number<5).forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(number -> number>5).
                skip(1).
                limit(2).
                forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Optional<Integer> find = StreamSources.intNumbersStream().filter(number -> number>5).findFirst();
        if(find.isPresent()){
            System.out.println(find.get());
        }
        else{
            System.out.println(-1);
        }

        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream().forEach(number ->
                StreamSources.userStream().filter(user -> user.getId()==number).forEach(user -> System.out.println(user.getFirstName())));
    }

}
