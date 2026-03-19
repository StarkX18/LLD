/*
    resources:
    enums in java:
    - https://www.geeksforgeeks.org/enum-in-java/
    
    important points in enums in java:
    - enums are used to define a collection of constants
    - these are internally defined as a class and can have methods, constructors, etc
    - public static final constants initialisation for each constant defined

    example:
    enum Color {
        RED,
        GREEN,
        BLUE;
    }

    internally above enum Color is converted to
    class Color
    {
        public static final Color RED = new Color();
        public static final Color BLUE = new Color();
        public static final Color GREEN = new Color();
    }

    - Every enum constant is always implicitly public static final. Since it is static, we can access it by using the enum Name. Since it is final, we can’t create child enums.
    - We can declare the main() method inside the enum. Hence we can invoke enum directly from the Command Prompt.
    - enum can implement many interfaces.
    - enum can contain a constructor and it is executed separately for each enum constant at the time of enum class loading.
    - We can’t create enum objects explicitly and hence we can’t invoke enum constructor directly.

    singleton with enum:
    - https://www.geeksforgeeks.org/advantages-and-disadvantages-of-using-enum-as-singleton-in-java/
    - https://stackoverflow.com/questions/26285520/implementing-singleton-with-an-enum-in-java

    singletons with enum:
    - thread safe
    - easy to implement
    - lazy loading and dynamic configurations!
    - serialization is guaranteed by the JVM
    - deserialize the singleton object safely
    - can define explicit constructors and parameterised methods
*/

enum singleton{
    INSTANCE;
    private singleton() {
        System.out.println("Here");
    }  
    public static void main(String[] args) {
        System.out.println(MySingleton.INSTANCE); // prints INSTANCE
    }
}

/*
enum fields are compile time constants, but they are instances of their enum type. And, they're constructed when the enum type is referenced for the first time.
*/