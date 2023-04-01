package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Person> people = List.of(
                new Person("test1", Gender.MALE),
                new Person("test2", Gender.MALE),
                new Person("test3", Gender.FEMALE),
                new Person("test4", Gender.MALE),
                new Person("test5", Gender.FEMALE)
        );

        // imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person: people){
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        System.out.println(females);

        // declarative approach
        System.out.println("Results from declarative approach");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

    }

    static class Person{
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person name = " + this.name + " and Gender = " + this.gender;
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}
