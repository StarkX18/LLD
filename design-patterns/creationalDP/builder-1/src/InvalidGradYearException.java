public class InvalidGradYearException extends RuntimeException{
    InvalidGradYearException(){}
    InvalidGradYearException(String message){
        System.out.println("Invalid GradYear: " + message);
    }
}
