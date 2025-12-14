/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.inheritancepolymorphism;

/**
 *
 * @author vrund
 */
public class Professor extends Person {
    private String department;

    public Professor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + getName()
                + ", I am " + getAge()
                + " years old, and I work in the " + department + " department.");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
