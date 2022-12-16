# Project : SPORTS COMPETITIONS

This is a project from the object-oriented design course consisting of the creation of sports competitions (leagues, tournaments, Masters) against a list of competitors.

* `The leagues` are played in a round robin format. Each competitor meets twice each other competitor of the league. At the end of the league, the winner is the competitor with the most victories.

* `Tournaments` are single elimination and take place over several rounds. Only competitors who have won their match in one round participate in the next round. The winners of each match play each other until there is only one winner left. The winner of the tournament has won as many matches as the number of rounds played. The organization of such tournaments requires a number of competitors power of 2.

* `The Masters` are a combination of several leagues, here called the group stage, and a final knockout tournament.

    The intermediate passage from the pool phase to the final phase is animated by a selection of finalists whose method is defined at the beginning of the competition (Master). Regardless of the selection method used, the number of competitors reaching the final phase must be a power of 2. There are 3 selection methods: the method of selecting the first of all pools, the method of selecting the first two of each pool and the method of selecting the first two of each pool as well as the best two thirds of all pools combined.

    The winner of the Master is the competitor who finishes first in the final phase.  It is not necessarily the competitor with the most wins who wins the tournament, since a competitor can finish first in his pool with fewer points than the first in another pool.

In addition, journalists and bookmakers can be included in the competition.

Journalists attend the competitions and post the results for each match. The bookmakers, on the other hand, change the odds of the competitors according to the results of the matches in the competition. They maintain a list of competitors' odds that they display and change according to wins (decrease in odds) and losses (increase in odds).

## Unit tests

In order to pass the unit tests, we start by compiling them by running the following two commands :

```
javac -d classes/ -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java

javac -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java
```

Then, we can execute the different tests :

```
java -jar test-1.7.jar competition.CompetitorTest

java -jar test-1.7.jar competition.MatchTest

java -jar test-1.7.jar competition.TournamentTest

java -jar test-1.7.jar competition.LeagueTest

java -jar test-1.7.jar competition.MasterTest

java -jar test-1.7.jar competition.SelectFirstTest

java -jar test-1.7.jar competition.SelectFirstTwoTest

java -jar test-1.7.jar competition.SelectFirstTwoAndBestThirdsTest
```

## Project execution

To run the programs :

* League :

		java -jar League.jar

* Tournament :

		java -jar Tournament.jar
		
* Master :

		java -jar Master.jar


You can also run an `automatic version` of the project by using the command :

```
java -jar MainObserver.jar
```