### To authenticate

```shell
curl --location 'localhost:8080/accountLogin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "test1@coderbrother.com",
    "password": "test1"
}'
```

### To get profile
```shell
curl --location 'localhost:8080/profile' \
--header 'Authorization: <ACCOUNT_LOGIN_GENERATED_TOKEN>'
```
