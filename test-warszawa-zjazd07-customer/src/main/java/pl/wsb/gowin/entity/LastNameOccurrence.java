package pl.wsb.gowin.entity;

public class LastNameOccurrence {

    private Object count;
    private Object lastName;

    public LastNameOccurrence(Object lastName, Object count) {
        this.count = count;
        this.lastName = lastName;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return lastName + ": " + count;
    }
}
