package com.cygnus.gsp.api.function;

import com.cygnus.gsp.api.domain.model.Driver;
import com.cygnus.gsp.api.domain.model.DropSystem;
import com.cygnus.gsp.api.domain.model.Season;

import java.math.BigDecimal;


public class CalculatePoints {

    public BigDecimal getDriverPoints(Season season, Driver driver) {
        if(season.getPointSystem().getDropSystem().getDropMethod().equals(DropSystem.Method.HALF))
        {
            int splitRace = season.getScheduledEvents() / 2;
            BigDecimal totalPoints;
            totalPoints = calculatePointsForRaces(0,splitRace,season,driver);
            totalPoints = totalPoints.add(calculatePointsForRaces(splitRace + 1,season.getScheduledEvents(),season,driver));
            return totalPoints;
        }
        else
        {
            return calculatePointsForRaces(0,season.getScheduledEvents(),season,driver);
        }
    }

    /* todo:
        calculate drops:
        make arraylist of points for driver
        loop through races, add points for each race to arraylist
        loop through arraylist, removing MIN value DROP number of times
        add remaining items in arraylist together to get race points
        add pole points for those races
        add flap points for those races
        return combined value
     */
    private BigDecimal calculatePointsForRaces(Integer startingRace,Integer endingRace, Season season, Driver driver) {
        /*season.getRaceList().stream().filter(race -> race.getRound() >= startingRace && race.getRound() <= endingRace)
                .filter(race -> race.getFinishedPositionList().stream()
                        .filter(finishedPosition -> finishedPosition.getDriver().equals(driver))
                        .map(finishedPosition -> season.getPointSystem().getPointPosition(finishedPosition.getRank())).reduce()



        for(Race race : season.getRaceList())
        {
            List<Integer> points = new ArrayList<>();
            if(race.getRound() >= startingRace && race.getRound() <= endingRace) {
                race.getFinishedPositionList().stream().filter(finishedPosition -> finishedPosition.getDriver().equals(driver)).findFirst()
            }
        }

*/
        return BigDecimal.ZERO;
    }
}
