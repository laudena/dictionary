## Creating MySQL database
### Creating docker container with mysql server
docker run --name dictionary_db -e MYSQL_ROOT_PASSWORD=an_excellent_password -d mysql:latest

### Setting up the user and database
docker exec -it the_docker_container_id /bin/bash
inside the container, use mysql with password access:
mysql --user=root -p

SHOW DATABASES

USE mysql;
CREATE USER 'api_user'@'%' IDENTIFIED BY 'a_good_password';
GRANT SELECT ON *.* TO 'api_user'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE dictionary;
use dictionary;

### Configuring the spring application
in application.properties file, set the properties under spring.datasource and spring.jpa.

## Using the api
### Requesting entries based on a title
 http://localhost:8181/api/v1/entry/title/ [ query ]

The output would be an array of titles that starts with the requested query

request:

curl http://localhost:8181/entry/title/ad

Response:

[{"title":"ad"},{"title":"adi"}]

### Requesting an entry data
curl http://localhost:8181/entry/ [ id ] 


Request:

curl http://localhost:8181/entry/2

Response:

{"id":2,"title":"ad","file_name":"images/final/ad.png","translation":"until"}
