package classes;

import enums.Status;

import java.util.Objects;

public abstract class Statused{
    protected String name;
    protected Status status;
    public Statused(String name, Status status){
        this.name = name;
        this.status = status;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statused)) return false;
        Statused statused = (Statused) o;
        return Objects.equals(getName(), statused.getName()) && getStatus() == statused.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStatus());
    }
}
