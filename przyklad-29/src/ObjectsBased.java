import java.util.Objects;

public class ObjectsBased {
    private int id;
    private String value;

    public ObjectsBased(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
