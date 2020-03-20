# TWITTER INDEXER 

---


This project is a POC for playing with Spring Kafka, ElasticSearch, and Twitter API.


## Usage


- `docker-compose -f docker/docker-compose.yml up --build`
- `zookeeper-server-start config/zookeeper.properties`
- `kafka-server-start config/server.properties`
- //FIXME: dockerize app itself 



```
Note: environment variables are required to fire the service up! env-vars.tpl file contains all of them to show an
example about them. That means that you need a Twitter developer account with a Twitter App.
```

## Tech Stack

- Spring Boot (2.2.5)
- Liquibase
- Postgres
- ElasticSearch
- Twitter developed HBC API
- SchedLock
- Spring Kafka
- Docker
- Maven
