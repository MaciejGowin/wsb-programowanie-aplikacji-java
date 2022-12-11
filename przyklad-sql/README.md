Wykonanie zapytań z pliku z poziomu command line.

```mysql -uroot -p < booking_system.sql ```

Wykonanie zapytań z pliku z poziomu SQL command line.
```
mysql> source booking_system.sql 
```

Wygenerowanie zrzutu bazy danych ze strukturą i danymi.
```
mysqldump -uroot -p booking_system
```

Wygenerowanie zrzutu bazy danych ze strukturą i danymi do pliku.
```
mysqldump -uroot -p booking_system > file.sql
```
