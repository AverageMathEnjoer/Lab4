package classes;

import enums.Status;

public abstract class Statused{
    protected String name;
    protected Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
    boolean itsExist(){
        return status != Status.NONEXISTENENT;
    }
}
