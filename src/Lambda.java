import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description:
 * @author:panguangyi
 * @date: 2018-3-12
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("use Inner anonymous Interface.");
            }
        }).start();
        new Thread(() -> System.out.println("use lambda expression.")).start();
        List<String> programLanguages = Arrays.asList("C","C++","Java","Python","Go");
        //使用内循环替代外循环
        programLanguages.forEach(n -> System.out.println(n));
        programLanguages.stream().filter(p -> p.startsWith("C")).forEach(p -> System.out.println(p));
        //使用method reference
        //programLanguages.forEach(System.out::println);
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jack",20,Person.Sex.MAIL,LocalDate.of(1998,1,2),"jack@gmail.com"));
        persons.add(new Person("Mary",22,Person.Sex.FEMAIL,LocalDate.of(1996,2,2),"mary@123.com"));
        persons.add(new Person("Mike",16,Person.Sex.MAIL,LocalDate.of(2002,6,6),"mike@hotmail.com"));
        persons.add(new Person("John",26,Person.Sex.MAIL,LocalDate.of(1992,12,2),"john@iclound.com"));
        printPersons(persons,(Person p) -> p.getGender() == Person.Sex.MAIL
                    && p.getAge() >= 18 && p.getAge() <= 25);

        //使用map接受lambda表达式作参数转换输出值
        persons.stream().filter(p -> p.getGender() == Person.Sex.MAIL && p.getAge() >= 20 && p.getAge() <= 26).map(p -> p.getEmail()).forEach(System.out::println);
    }
    //使用filter过滤列表，使用Predicate判断条件
    public static void printPersons(List<Person> roster,Predicate<Person> tester){
        roster.stream().filter(p -> tester.test(p)).forEach(Person::printPerson);
    }
}

class Person{
    public enum Sex{
        MAIL,FEMAIL
    }
    String name;
    int age;
    Sex gender;
    LocalDate birthday;
    String emailAddress;

    public int getAge(){
        return age;
    }

    public Sex getGender(){
        return gender;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public String getEmail(){
        return emailAddress;
    }

    public void printPerson(){
        System.out.println("Person Name:" + name + " Age:" + age + " gender:" + gender);
    }

    public Person(String name,int age,Sex gender,LocalDate birthday,String emailAddress){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
    }
}
