public class Standard {
    private int id;
    private String value;

    public Standard(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }
}
