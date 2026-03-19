public class InvalidAgeException extends RuntimeException{
    InvalidAgeException(){}
    InvalidAgeException(String message){
        System.out.println("Invalid age: " + message);
    }
}
