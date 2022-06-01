package model;

public class Student {
    private String code;
    private String name;
    private int age;
    private String gender;
    private String address;
    private int averageSubject;

    public Student() {
    }

    public Student(String code, String name, int age, String gender, String address, int averageSubject) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageSubject = averageSubject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAverageSubject() {
        return averageSubject;
    }

    public void setAverageSubject(int averageSubject) {
        this.averageSubject = averageSubject;
    }
    public String write(){
        return code + "," + name + "," + age + "," + gender + "," + address + "," + averageSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", averageSubject=" + averageSubject +
                '}';
    }
}
