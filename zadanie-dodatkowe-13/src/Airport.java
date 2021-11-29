import java.util.Objects;

public class Airport {
    private final String code;

    public Airport(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return code;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)  {
            return true;
        }
        if (!(o instanceof Airport)) {
            return false;
        }

        Airport other = (Airport) o;

        return Objects.equals(code, other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
