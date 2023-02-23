package classes.exceptions;

public class InvalidСonfinesException extends RuntimeException {
    private Object min;
    private Object max;
    public InvalidСonfinesException(String message, Object min, Object max){
        super(message);
        this.max = max;
        this.min = min;
    }
}
