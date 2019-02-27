# ExchangeRateChecker

This is a possible solution to a Java Developer Interview Task I came across.

The task would be to write a service which constantly checks the exchange rate between two currencies. 
* The period in between checks has to be configurable.
* The check results have to be stored in a DB.
* The exchange rate/s have to be accessible via two endpoints:
    * one to get the lastest exchange rate
    * one to get the exchange rates from a start date to an end date

In the following i'll explain the reasoning behind my tech and design choices.
<h2> Tech Choices </h2>

<h2> Design Choices </h2>
<h4> HealthController </h4> 
I added a third endpoint which returns a message to show whether the service is accessible or not.
This is helpful in case the service is still running but not handling requests anymore.

An explanation on the concept can be found here: https://microservices.io/patterns/observability/health-check-api.html

<h4> Dividing into packages </h4>
Went with package by layer over package by feature because this is only a really small service.
Normally i'd recommend using package by feature because of higher cohesion, modularity e.g.

An overview of the topic can be found here: http://www.javapractices.com/topic/TopicAction.do?Id=205





