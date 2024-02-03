public class Student implements Prototype<Student>{
    private String name;
    private String email;
    private String phone;
    private String university;
    private String batch;
    private String instructor;
    private Integer yearOfJoining;

    // need to define default constructor separately if we want to implement copy constructor
    public Student(){}

    // copy constructor that initialises common set of values for clone Student
    public Student(Student s){
        this.batch = s.batch;
        this.instructor = s.instructor;
        this.yearOfJoining = s.yearOfJoining;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }
}
