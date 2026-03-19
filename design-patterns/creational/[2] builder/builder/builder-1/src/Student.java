public class Student {
    private String name;
    private String university;
    private int gradYear;
    private float psp;
    private String phone;
    private int age;

    private Student(){}
    private Student(String name, String university, int gradYear, float psp, String phone, int age){
        this.name = name;
        this.university = university;
        this.gradYear = gradYear;
        this.psp = psp;
        this.phone = phone;
        this.age = age;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "name=" + name +
                ", university=" + university +
                ", gradYear=" + gradYear +
                ", psp=" + psp +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }

    public static class StudentBuilder{
        private String name;
        private String university;
        private int gradYear;
        private float psp;
        private String phone;
        private int age;

        public StudentBuilder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public StudentBuilder setPsp(float psp) {
            this.psp = psp;
            return this;
        }

        public StudentBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder validate() {
            if (this.age < 24) {
                throw new InvalidAgeException("you are too young");
            }
            if (this.gradYear > 2020) {
                throw new InvalidGradYearException("you are not eligible yet");
            }
            if (this.name == null) {
                throw new InvalidNameException("please enter your name first");
            }
            return this;
        }

        public Student build(){
             return new Student(this.name, this.university, this.gradYear, this.psp, this.phone, this.age);
        }
    }
}
