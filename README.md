# TWITTER INDEXER 

---


This project is a POC for playing with Spring Kafka, ElasticSearch, and Twitter API.
Docker is multi-stage with the layered spring boot jar.


## Usage via docker

### Twitter-indexer

- `cd twitter-indexer-producer`
- `./mvnw clean install`
- `docker-compose -f docker/docker-compose.yml up --build`
- create & fill out the `docker/.env` file with the missing secrets based on the env-vars.tpl template file
- `docker-compose -f docker/twitter-indexer-compose.yml up --build`

### Twitter-consumer

- `cd twitter-consumer`
- `./mvnw clean install`
- `docker-compose -f docker/docker-compose.yml up --build`
- `docker-compose -f docker/twitter-consumer-compose.yml up --build`


```
Note: twitter api secrets are required to fire the service up! env-vars.tpl file contains all of them to show an
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

## Inspirations

- [ElasticSearch doc](https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html#docker-prod-cluster-composefile)
- [Spring Kafka batch listener config](https://docs.spring.io/autorepo/docs/spring-kafka-dist/1.1.1.BUILD-SNAPSHOT/reference/htmlsingle/#_batch_listeners)
- [Multi-stage Dockerfile](https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1)
- [Multi-stage Dockerfile with Spring-boot](https://medium.com/@tariqul.islam.rony/spring-boot-and-multi-stage-dockerized-image-with-mysql-in-docker-compose-part-3-2999b2bdf6aa)
