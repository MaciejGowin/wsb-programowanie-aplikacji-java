import java.util.Objects;

public class Route {
    private final Airport departure;
    private final Airport arrival;

    public Route(Airport departure, Airport arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)  {
            return true;
        }
        if (!(o instanceof Route)) {
            return false;
        }

        Route other = (Route) o;

        return Objects.equals(departure, other.departure)
                && Objects.equals(arrival, other.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }
}
