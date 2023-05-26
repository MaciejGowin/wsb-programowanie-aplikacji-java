# Junit 5

### 1. Uruchomienie testów
1. Uruchom istniejące testy poprzez komendę `mvn test`. (pamiętaj o przejściu do poprawnego folderu)
2. Uruchom testy z poziomu Intellij oraz przeanalizuj wyniki. (ppm na folder **java** w **src/test** i opcja **Run 'all tests'**)

### 2. Testy w junit 5
W pakiecie `*.simple` znajduje się kilka klas, które wymagają napisania testów. Użyj asercji dostępnych w bibliotece AssertJ.
1. Napisz testy jednostkowe dla metod klasy `CustomStringUtils`. Spróbuj przeanalizować wszystkie możliwe przypadki użycia danej metody i do każdego z nich napisać odpowiedni test.
2. Spójrz na klasę `Calculator` oraz test `CalculatorTest`. Spróbuj napisać implementację metody w taki sposób, aby test przechodził.
3. Rozszerz klasę `Calculator` o kolejne funkcjonalności:
   1. mnożenie
   2. dzielenie
   3. dodawanie
   4. odejmowanie  

Dopisz testy jednostkowe. Pamiętaj o wszystkich możliwościach użycia metod.
4. Otwórz klasę `InternalCache`. Napisz testy jednostkowe dla method znajdujących się w tej klasie. Sprawdzaj czy ilość elementów w cache zgadza się z Twoimi założeniami. Pamiętaj o inicjalizacji i czyszczeniu cache przed i po każdym teście.

### 3. Testy parametryzowane w junit 5
W pakiecie `*.parameterized` znajduje się klasa `CurrencyConversion` oraz test `CurrencyConversionParametrizedTest`.
1. Popraw funkcję `CurrencyConversion.convert` tak, aby zaokrąglała w dół, do 2 miejsc po przecinku w następujący sposób: 1.6 -> 1, 1.5 -> 1, 1.1 -> 1, 1.0 -> 1
2. Dodaj więcej przypadków testowych. Pamiętaj o scenariuszach negatywnych - niepoprawne dane, błędy

### 4. Testy Mockito
W pakiecie `*.mvc` znajduje się przykładowa aplikacja napisana z użyciem Spring Boot.
1. Spójrz na `FlightService.scheduleNewFlight()`. Napisz test jednostkowy z użyciem Mockito. Sprawdź czy obiekt przekazany do metody `save` jest poprawnie skonstruowany
2. Spójrz na `FlightService.findById()`. Napisz testy jednostkowe z użyciem Mockito. Sprawdź wszystkie możliwe scenariusze.
3. Spójrz na `FlightService.findAllFlights()`. Czy warto pisać do niej testy z użyciem Mockito?
4. Napisz testy do metody `AirportService.getAirportsName()`. Zamokuj odpowiedź z zewnętrznego API.
   1. Popraw możliwe błędy w kodzie jeżeli wystąpi taka potrzeba.

### 5. Testy Spring
W pakiecie `*.mvc` znajduje się przykładowa aplikacja napisana z użyciem Spring Boot.
1. Napisz test dla `AirportController`. Zamokuj zachowanie beana RestTemplate (reszta ma pozostać bez zmian)
2. Napisz testy do `FlightController` dla każdej akcji.
   1. Wypełnij bazę danych testowymi danymi.
   2. Akcje zapisu zweryfikuj w bazie danych
   3. Pamiętaj o przeanalizowaniu wszystkich test-case'ów
3. Napisz testy dla `FlightRepository`. Przetestuj działanie stworzonych metod. Nie tesuj metod stworzonych przez Springa.