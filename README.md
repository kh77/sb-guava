## Spring Boot - Guava Example

- ### Create User
        curl --location --request POST 'http://localhost:8080/users' \
        --header 'accept: */*' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "name": "hello world",
        "email": "hello@hotmail.com"
        }'

- ### Find By User Id
        curl --location --request GET 'http://localhost:8080/users/1' \
        --header 'accept: */*' \
        --header 'Content-Type: application/json' \
        --data-raw ''


- ### Find All Users
        curl --location --request GET 'http://localhost:8080/users' \
        --header 'accept: */*' \
        --header 'Content-Type: application/json' \
        --data-raw ''