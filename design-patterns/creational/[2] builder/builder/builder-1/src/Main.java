//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = Student.builder()
                .setName("Siddharth")
                .setAge(25)
                .setPsp(56)
                .validate()
                .build();
        System.out.println(s1);
    }
}