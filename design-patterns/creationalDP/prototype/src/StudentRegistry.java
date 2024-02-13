import java.util.HashMap;

public class StudentRegistry {
    private HashMap<String, Student> studentRegistry;

    public StudentRegistry(){
        this.studentRegistry = new HashMap<>();
    }

    public Student add(Student prototype){
        studentRegistry.put(prototype.getModuleName(), prototype);
        return prototype;
    }

    public Student get(String module){
        return studentRegistry.get(module);
    }
}
