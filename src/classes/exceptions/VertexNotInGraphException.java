package classes.exceptions;

public class VertexNotInGraphException extends Exception{
    private Object vertex;

    public Object getVertex() {
        return vertex;
    }
    public VertexNotInGraphException(String message, Object vertex){
        super(message);
        this.vertex = vertex;
    }
}
