public class IntellijGenerated {
    private int id;
    private String value;

    public IntellijGenerated(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int hashCode() {
        int result = id ^ (id >>> 32);
        result = 31 * result + value.hashCode();
        return result;
    }
}
