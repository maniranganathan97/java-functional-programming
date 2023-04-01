package org.example.FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Person person = new Person("test 1", "23568975");
        greetCustomer(person);
        personConsumer.accept(person);
        personConsumer2.accept(person, false);
    }

    static Consumer<Person> personConsumer = person -> {
        System.out.println(" Hi " + person.name + " thank you for registering your number " + person.number);
    };
    static BiConsumer<Person, Boolean> personConsumer2 = (person, showNumber) -> {
        System.out.println(" Hi " + person.name + " thank you for registering your number " + ( showNumber ? person.number : "*******") );
    };

    static void greetCustomer(Person person) {
        System.out.println(" Hi " + person.name + " thank you for registering your number " + person.number);
    }
    static class Person{
        private String name;
        private String number;

        public Person(String name, String number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}
