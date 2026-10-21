package programs;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * How many male and female employees are there in an organization?
 *
 */

public class Java8StreamInterviewQuestions {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Heena", "Female", "IT", 70000),
                new Employee(2, "Rajesh", "Male", "HR", 50000),
                new Employee(3, "Priya", "Female", "IT", 80000),
                new Employee(4, "Amit", "Male", "Finance", 60000),
                new Employee(5, "Rahul", "Male", "IT", 90000)
        );

        // Q How many male and female employees are there in an organization?
        Map<String, Long> genderCount = employees.stream().collect(Collectors
                .groupingBy(Employee ::getGender,Collectors.counting()));

        System.out.println(genderCount); // output {Male=3, Female=2}

        //Q Given a list of integers, separate odd and even numbers? using java 8

        List<Integer> evenOddNumbersList = Arrays.asList(10,15,20,25,30,35,75,80,41);
        Map<Boolean, List<Integer>> resultmap = evenOddNumbersList.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));
        System.out.println("********resultmap for evenodd " +resultmap);

        System.out.println( "Even Numbers are " + resultmap.get(true));
        System.out.println( "ODD Numbers are " + resultmap.get(false));

        //How do you remove duplicate elements from a list using Java 8 streams?
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> listOfUniqueStrings = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println("ListOfUnique string is" +listOfUniqueStrings);

        // Most imp Q - How do you find frequency of each character in a string using Java 8 streams?

        String string = "Programming";
        Map <Character, Long>  charFrequency =  string.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println( charFrequency);
        // to preserv insertion order of string
        Map <Character, Long>  charFrequencyWithOrderMAintained =  string.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println( charFrequencyWithOrderMAintained);

        //4) How do you find frequency of each element in an array or a list?

        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

        Map <String, Long>  stationeryCountMap =  stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println( stationeryCountMap);

     //5) How do you sort the given list of decimals in reverse order?

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //  Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?

        List<String> listOfStringss = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String joinedList = listOfStringss.stream().collect(Collectors.joining("," , "[", "]"));

        System.out.println("JoinedList is  " +joinedList);

        //7) From the given list of integers, print the numbers which are multiples of 5?
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().filter(i -> i%5==0).forEach(System.out::println);


        //Java 8 program to check if two strings are anagrams or not?
        String s1 ="Listen";
        String s2 ="Silent";
        String str1 = Arrays.stream(s1.replaceAll("\\s+", "")
                        .toLowerCase()
                        .split(""))
                .sorted()
                .collect(Collectors.joining());

        String str2 = Arrays.stream(s2.replaceAll("\\s+", "")
                        .toLowerCase()
                        .split(""))
                .sorted()
                .collect(Collectors.joining());

        System.out.println("isStringAnagram  Listne and silent*****"+str1.equals(str2));







    }

    public static class Employee {

        private int id;
        private String name;
        private String gender;
        private String department;
        private double salary;

        public Employee(int id, String name, String gender, String department, double salary) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
        // Constructors, Getters and Setters
    }

}
