import PersonInfo.Education;
import PersonInfo.Person;
import PersonInfo.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }


        System.out.println("Количество несовершеннолетних: " +
                "\n" + persons.stream().filter(x -> x.getAge() < 18).count());


        System.out.println("\nCписок фамилий призывников: " +
                "\n" + persons.stream()
                .filter(x -> x.getAge() >= 18 & x.getAge() <= 27)
                .map(e -> e.getFamily())
                .collect(Collectors.toList()));


        System.out.println("\nCписок потенциально работоспособных людей с высшим образованием: " +
                "\n" + persons.stream().filter(x -> {
                    if (x.getSex() == Sex.WOMAN & x.getAge() >= 18 & x.getAge() <= 60) return true;
                    else if (x.getSex() == Sex.MAN & x.getAge() >= 18 & x.getAge() <= 65) return true;
                    return false;
                })
                .filter(w -> w.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(e -> e.getFamily()))
                .map(e -> e.getFamily())
                .collect(Collectors.toList()));


    }
}