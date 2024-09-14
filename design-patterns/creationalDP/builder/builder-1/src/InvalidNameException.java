public class InvalidNameException extends RuntimeException {
    InvalidNameException(){}
    InvalidNameException(String message){
        System.out.println("Invalid Name: " + message);
    }
}
