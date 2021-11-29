import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Route> routes = new HashSet<>();
        routes.add(new Route(new Airport("Krakow"), new Airport("Wroclaw")));
        routes.add(new Route(new Airport("Krakow"), new Airport("Dublin")));
        routes.add(new Route(new Airport("Wroclaw"), new Airport("Dublin")));
        routes.add(new Route(new Airport("Wroclaw"), new Airport("Krakow")));
        routes.add(new Route(new Airport("Warsawa"), new Airport("Krakow")));

        // Build all possible routes
        Map<Airport, Set<Airport>> arrivalsPerDeparture = new HashMap<>();
        for (Route route: routes) {
            arrivalsPerDeparture.putIfAbsent(route.getDeparture(), new HashSet<>());
            arrivalsPerDeparture.get(route.getDeparture()).add(route.getArrival());
        }

        // Show results
        for (Map.Entry<Airport, Set<Airport>> e : arrivalsPerDeparture.entrySet()) {
            System.out.printf("Departure: %s: arrivals: %s%n", e.getKey(), e.getValue());
        }
    }
}
