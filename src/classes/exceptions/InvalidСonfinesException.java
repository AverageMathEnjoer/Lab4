package classes.exceptions;

public class Invalid–°onfinesException extends RuntimeException {
    private Object min;
    private Object max;
    public Invalid–°onfinesException(String message, Object min, Object max){
        super(message);
        this.max = max;
        this.min = min;
    }
}
