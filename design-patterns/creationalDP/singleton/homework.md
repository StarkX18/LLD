STILL problems!
Serialization / Deserialization issue:
Converting an object into a stream of bytes / and back.
python: pickle - save ML models.

volatile variable??? => https://www.geeksforgeeks.org/volatile-keyword-in-java/
- reads and writes happen directly from the main memory, no registers or local caches(for threads) involved
- volatile vs static: static is shared across all objects but present only at one place in main memory. No such thing with colatile.
- volatile vs synchronised: synchronised gives mutual exclusion + visibility ie 
    - mutual exclusion means only one threads can do something at one point 
    - visibility: changes made to shared resource are visible to all
    - volatile provides visibility but not atomicity. Multiple threads can access it but
    - since each read anf write is happening from the main memory, and not their own caches etc
    - its not the same as synchronous!
    - it also has very limited use-cases.

Issue: existence of two objects at the same time!
------------------------------------------------------------------------------------------------------------
Solution:: Learn how to implement singletons using enums

homework:

1. Singleton using enum - best implementation
2. Visit the links
3. Code singleton DB yourself.

links:
https://stackoverflow.com/questions/137975/what-are-drawbacks-or-disadvantages-of-singleton-pattern
https://refactoring.guru/design-patterns/singleton
https://github.com/Naman-Bhalla/lldSept2022/tree/master/src/main/java/designpatterns/singleton
https://twitter.com/Piwai/status/1530057291549921282/photo/1
-----------------------------------------------------------------------------------------------------------
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


- enum fields are compile time constants, but they are instances of their enum type. And, they're constructed when the enum type is referenced for the first time.
- The private modifier has no meaning for an enum constructor and is entirely redundant.

singleton with enum:
- https://www.geeksforgeeks.org/advantages-and-disadvantages-of-using-enum-as-singleton-in-java/
- https://stackoverflow.com/questions/26285520/implementing-singleton-with-an-enum-in-java

singletons with enum:
- thread safe
- easy to implement
- serialization is guaranteed by the JVM
- deserialize the singleton object safely


- An enum type has no instances other than those defined by its enum constants. It is a compile-time error to attempt to explicitly instantiate an enum type. 
- The final clone method in Enum ensures that enum constants can never be cloned, and the special treatment by the serialization mechanism ensures that duplicate instances are never created as a result of deserialization. 
- Reflective instantiation of enum types is prohibited. 
- Together, these four things ensure that no instances of an enum type exist beyond those defined by the enum constants.
------------------------------------------------------------------------------------------------------------