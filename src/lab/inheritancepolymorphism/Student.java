/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.inheritancepolymorphism;
import java.util.Arrays;

/**
 *
 * @author vrund
 */

public class Student extends Person {
    private String studentId;

    // Enrollment System Extension (array of course IDs)
    private String[] courses;
    private int courseCount;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;

        this.courses = new String[6];   // start capacity (can grow)
        this.courseCount = 0;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + getName()
                + ", I am " + getAge()
                + " years old, and my student ID is " + studentId + ".");
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void enrollCourse(String courseId) {
        if (courseId == null || courseId.trim().isEmpty()) {
            System.out.println("Cannot enroll: course ID is empty.");
            return;
        }

        courseId = courseId.trim().toUpperCase();

        // prevent duplicates
        for (int i = 0; i < courseCount; i++) {
            if (courseId.equals(courses[i])) {
                System.out.println("Already enrolled in: " + courseId);
                return;
            }
        }

        // grow array if needed
        if (courseCount == courses.length) {
            courses = Arrays.copyOf(courses, courses.length * 2);
        }

        courses[courseCount] = courseId;
        courseCount++;
        System.out.println("Enrolled in: " + courseId);
    }

    public void dropCourse(String courseId) {
        if (courseId == null || courseId.trim().isEmpty()) {
            System.out.println("Cannot drop: course ID is empty.");
            return;
        }

        courseId = courseId.trim().toUpperCase();

        int index = -1;
        for (int i = 0; i < courseCount; i++) {
            if (courseId.equals(courses[i])) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // handle "not enrolled" case (required)
            System.out.println("Cannot drop: not enrolled in " + courseId);
            return;
        }

        // Shift left using System.arraycopy (allowed by lab)
        int elementsToMove = courseCount - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(courses, index + 1, courses, index, elementsToMove);
        }

        courses[courseCount - 1] = null;
        courseCount--;
        System.out.println("Dropped: " + courseId);
    }

    public void printCourses() {
        System.out.println("Courses for " + getName() + " (" + studentId + "):");
        if (courseCount == 0) {
            System.out.println("  (No courses enrolled)");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            System.out.println("  - " + courses[i]);
        }
    }
}
