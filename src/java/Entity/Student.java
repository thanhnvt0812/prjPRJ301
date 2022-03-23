/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Student {
    private String  rollnumber;
    private String name;
    private String username;
    private String email;
    private boolean gender;
    private String dob;

    public Student() {
    }

    public Student(String rollnumber, String name, String username, String email, boolean gender, String dob) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "rollnumber=" + rollnumber + ", name=" + name + ", username=" + username + ", email=" + email + ", gender=" + gender + ", dob=" + dob + '}';
    }

    
    
}
