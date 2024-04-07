### MongoDB - zadanie
* Utwórz nowe konto na stronie: https://www.mongodb.com/atlas-signup-from-mlab
* Zweryfikuj swój adres email. Sprawdź skrzynkę odbiorczą oraz kliknij "verify email"
* Utwórz klaster poprzez kliknięcie "Create cluster". Wybierz wersję darmową "M0 Free". Pozostaw ustawienia domyślne.
* Zapisz ustawienia połączenie oraz użytkownika. Wybierz utworzenie użytkownika
* Wybierz połączenie Atlas SQL.
* Przejrzyj zadania zaproponowane przez konfigurator dla testowej bazy `sample_mflix`.
* Wybierz "Database" z menu po lewej stronie oraz "Collections" z listy opcji.
* Wybierz kolekcję `sample_mflix > movies` oraz wykonaj przykładowe zapytania

```
{genres : ["Drama", "Fantasy"]}
{runtime: {$gt: 120}}
```

* Dodaj nowy dokument, wybierając opcję "Insert document"
* Zmodyfikuj/usuń wybrany dokument
* Zapoznaj się z innymi dostępnymi opcjami
