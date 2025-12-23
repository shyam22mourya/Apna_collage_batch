package Java8Features;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class Test {

   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(13, 10, 1, 3, 3, 4, 5, 6, 7, 9);
      List<String> list2 = Arrays.asList("anand", "kundan", "khushi", "akansha");
      /*
       * // Q1 . Find all even numbers from a list of integers.
       * // System.out.println( list.stream().filter(x -> x%2==0).toList());
       * 
       * // Q2. Find all strings that start with a given letter from a list.\
       * // System.out.println(list2.stream().filter(x ->
       * x.startsWith("a")).toList());
       * 
       * // Q3. Count the number of elements in a list using streams.
       * // System.out.println(list.stream().count());
       * 
       * // Q4. all strings in a list to uppercase.
       * // System.out.println(list2.stream().map(String::toUpperCase).toList());
       * 
       * // Q5 . Sort a list of integers in ascending and descending order.
       * // System.out.println(list.stream().sorted( ).toList());
       * // System.out.println(list.stream().sorted( (x , y) -> x + y ).toList());
       * 
       * // Q5Find the maximum and minimum number in a list.
       * // System.out.println(list.stream().reduce((x, y) -> x < y ? x : y).get());
       * // System.out.println(list.stream().reduce((x, y) -> x > y ? x : y).get());
       * 
       * // Q 6 Remove duplicate elements from a list.
       * // System.out.println(list.stream().distinct().collect(Collectors.toList()));
       * // System.out.println(list.stream().collect(Collectors.groupingBy()));
       * 
       * // Count the number of unique elements in a list.
       * // System.out.println(list.stream().distinct().count());
       * // Find the first element of a stream (or return default if empty).
       * // System.out.println(list.stream().findFirst().get());
       * // Convert a list of strings into a list of their lengths.
       * // System.out.println(list2.stream().map(x -> x.length()).toList());
       * 
       */
      // Intermediate Coding Questions

      // Q11 .Find the sum of all elements in a list.
      // System.out.println(list.stream().reduce((x,y)->x+y).get());

      // Q12. Find the average of numbers in a list.
      IntSummaryStatistics data = list.stream().collect(Collectors.summarizingInt(x -> x));
      // System.out.println(data.getAverage());
      // System.out.println(data.getSum());
      // The code `list.stream().collect(Collectors.averagingInt(x -> x ));` is
      // calculating the
      // average of the numbers in the list using Java streams.
      // System.out.println(list.stream().collect(Collectors.averagingInt(x -> x )));

      //Q 13 Square every number in a list and filter numbers greater than 50.
        

      // Join a list of strings with a comma separator.

      // Partition a list of numbers into even and odd.

      // Group strings by their length.

      // Find all elements starting with "a" and ending with "z".

      // Count the frequency of each element in a list.

      // Count frequency of characters in a string.

      // The task "Reverse sort a list of numbers using streams" involves sorting a
      // list of numbers in
      // descending order using Java streams. Here's how you can achieve this:
      // Reverse sort a list of numbers using streams.
      /*
       * 
       * 
       * Employee/Custom Object Based Questions (Most common in interviews)
       * 
       * (Assume you have an Employee class with fields: id, name, department, salary,
       * age)
       * 
       * Find the employee with the maximum salary.
       * 
       * Find the employee with the minimum salary.
       * 
       * Get a list of all distinct department names.
       * 
       * Group employees by department.
       * 
       * Count employees in each department.
       * 
       * Find the average salary of each department.
       * 
       * Find the second-highest salary of employees.
       * 
       * Find the nth highest salary (generalized).
       * 
       * Sort employees by salary in descending order.
       * 
       * Find employees whose names start with "A".
       * 
       * Find the youngest employee in the company.
       * 
       * Find the oldest employee in each department.
       * 
       * Find employees older than 30 and sort them by name.
       * 
       * Find the top 3 highest-paid employees.
       * 
       * Check if all employees are above age 18.
       * 
       * Check if any employee has a salary greater than 1 lakh.
       * 
       * Get the list of employee names as a single comma-separated string.
       * 
       * Partition employees into two groups: salary > 50k and <= 50k.
       * 
       * Get the average age of employees per department.
       * 
       * Find the employee with the longest name.
       * 
       * Advanced / Tricky Stream Questions
       * 
       * Flatten a list of lists into a single list.
       * 
       * Find duplicate elements in a list using streams.
       * 
       * Remove duplicates from a string (e.g., "banana" -> "ban").
       * 
       * Find common elements between two lists.
       * 
       * Find elements present in list A but not in list B.
       * 
       * Merge two unsorted lists into one sorted list without duplicates.
       * 
       * Find the longest string in a list.
       * 
       * Find the shortest string in a list.
       * 
       * Sort a map by values using streams.
       * 
       * Sort a map by keys using streams.
       * 
       * Convert a list of strings into a map with string as key and length as value.
       * 
       * Find the first non-repeated character in a string using streams.
       * 
       * Find the first repeated character in a string using streams.
       * 
       * Check if two strings are anagrams using streams.
       * 
       * Given a list of transactions (id, amount, type), find the total amount by
       * type (credit/debit).
       */
   }
}