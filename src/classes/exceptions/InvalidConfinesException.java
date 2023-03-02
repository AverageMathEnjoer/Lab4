package classes.exceptions;

public class InvalidConfinesException extends IllegalArgumentException {
    private Object min;
    private Object max;
    public InvalidConfinesException(String message, Object min, Object max){
        super(message);
        this.max = max;
        this.min = min;
    }
}
