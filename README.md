# ExchangeRateChecker

This is a microservice which pulls the exchange rate from euro to dollar from an API, 
and writes it to a DB. The exchange rates can be accessed via two REST endpoints. One returns
the most recent exchange rate and the other returns all exchange rates in between
two timestamps.

## How to run

* get the JDK of your choice (would recommend 9 or higher tho)
* install Postgres (https://www.postgresql.org/download/)
* this is optional but Id recommend using a Postgres client like Postico
(https://eggerapps.at/postico/) to interact with Postgres
* setup your Postgres user (https://wiki.postgresql.org/wiki/First_steps)
* create a DB named exchange_rates
* create a Table within exchange_rates as follows: 
```
CREATE TABLE "public"."timestamps_and_rates" (
                    "date_time" timestamp without time zone,
                    "rate" real,
                    PRIMARY KEY ("date_time"));
```
* if you want to change the DB / table / column names make sure to adjust the SQL queries
aswell
* clone/fork this repo

## Tech Choices

* Maven for managing libraries, executing tests and building the application
* Spring for dependency injection, DB access, scheduling and so forth
* Postgres for the DB because its open source, object relational and
I have some minor experience with it already.
* JUnit for unit testing
