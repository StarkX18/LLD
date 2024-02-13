public class Student implements Prototype<Student>{
    private String name;
    private int age;
    private String phone;
    private String yearEnrolled;
    private String module;
    private String instructor;
    public Student(String name, int age, String phone, String yearEnrolled, String module, String instructor){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.yearEnrolled = yearEnrolled;
        this.module = module;
        this.instructor = instructor;
    }
    // copy constructor - creates deep copies for fixed attributes
    public Student(Student student){
        this.yearEnrolled = student.yearEnrolled;
        this.module = student.module;
        this.instructor = student.instructor;
    }

    public Student clone(){
        return new Student(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", yearEnrolled='" + yearEnrolled + '\'' +
                ", module='" + module + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }

    public String getModuleName() {
        return this.module;
    }
}
