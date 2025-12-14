/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.inheritancepolymorphism;

/**
 *
 * @author vrund
 */

public class Tester {
    public static void main(String[] args) {

        // 1) Create a Student
        Student s1 = new Student("Vrund", 21, "N01710067");

        // 2) Enroll at least 6 courses
        s1.enrollCourse("CPAN211");
        s1.enrollCourse("CPAN212");
        s1.enrollCourse("CPAN214");
        s1.enrollCourse("CPAN215");
        s1.enrollCourse("MATH101");
        s1.enrollCourse("COMM201");

        // 3) Print list
        System.out.println();
        s1.printCourses();

        // 4) Drop one course
        System.out.println();
        s1.dropCourse("CAPN-213");

        // 5) Print updated list
        System.out.println();
        s1.printCourses();

        // (Extra) Try dropping a course not enrolled (required edge case)
        System.out.println();
        s1.dropCourse("CPAN-209");

        // 6) Polymorphism: Person reference to Student object
        System.out.println("\n--- Polymorphism Demo ---");
        Person p1 = s1;       // upcasting
        p1.introduce();       // calls Student.introduce() at runtime

        // 7) Repeat similar with Professor
        Professor prof = new Professor("Horia Humaila", 50, "CROSS PLATFORM APPLICATION DEVELOPMENT");
        Person p2 = prof;     // upcasting
        p2.introduce();
    }
}
