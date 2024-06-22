# Spring Boot + JUnit 5 + Mockito

Dla przykładowej aplikacji Spring Boot wykonaj zadania.

### 1. Testy Mockito

1. Spójrz na `FlightService.scheduleNewFlight()`. Napisz test jednostkowy z użyciem Mockito. Sprawdź, czy obiekt przekazany do metody `save` jest poprawnie skonstruowany.
2. Spójrz na `FlightService.findById()`. Napisz testy jednostkowe z użyciem Mockito. Sprawdź wszystkie możliwe scenariusze.
3. Spójrz na `FlightService.findAllFlights()`. Czy warto pisać do niej testy z użyciem Mockito?
4. Napisz testy do metody `AirportService.getAirportsName()`. Za'mock'uj odpowiedź z zewnętrznego API.
   1. Popraw możliwe błędy w kodzie, jeżeli wystąpi taka potrzeba.

### 2. Testy Spring

1. Napisz test dla `AirportController`. Za'mock'uj zachowanie bean'a RestTemplate (reszta ma pozostać bez zmian).
2. Napisz testy do `FlightController` dla każdej akcji opierając się na szablonie testu z za'mock'owanym serwisem.
   1. Wypełnij bazę danych testowymi danymi.
   2. Akcje zapisu zweryfikuj w bazie danych
   3. Pamiętaj o przeanalizowaniu wszystkich test-case'ów.
3. Napisz testy dla `FlightRepository`. Przetestuj działanie stworzonych metod. Pamiętaj, żeby nie testować metod stworzonych przez Springa.