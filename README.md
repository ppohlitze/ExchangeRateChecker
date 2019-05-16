# ExchangeRateChecker

This is a microservice which pulls the exchange rate from euro to dollar from an API, 
and writes it to a DB. The exchange rates can be accessed via two endpoints. One returns
the most recent exchange rate and the other returns all exchange rates in between
two timestamps.


<h2> How to run <h2>


<h2> Tech Choices </h2>

* Maven for managing libraries, executing tests and building the application
* Spring for dependency injection, DB access, scheduling and so forth
* Postgres for the DB because its open source, object relational and
I have some minor experience with it already.
* JUnit for unit testing
