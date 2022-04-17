package com.cygnus.gsp.api.function;

import com.cygnus.gsp.api.domain.model.PointSystem;
import com.cygnus.gsp.api.domain.model.Race;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class CalculatePoints {

    private static final int MIN_EVENT_SIZE = 1;
/*
    public void getSeasonPoints(Season season){
        //getlist of drivers from season
        season.getRaceList().stream()
                .flatMap(race -> race.getFinishedPositionList().stream()
                        .map(finishedPosition -> finishedPosition.getDriver().getDriverId()))
                .map(id -> getDriverPoints(season,id))
                .collect(Collectors.toSet());


    }
    public BigDecimal getDriverPoints(Season season, Long driverIdList) {

        if(season.getScheduledEvents() > MIN_EVENT_SIZE){

            int splitRace = season.getScheduledEvents() / season.getPointSystem().getDropSystem().getDropMethod().getSplit();


            if(DropSystem.Method.HALF.equals(season.getPointSystem().getDropSystem().getDropMethod())){
                List<List<Race>> segmentList = new ArrayList<>();
                segmentList.add(season.getRaceList().stream()
                        .filter(race -> race.getRound() <= splitRace)
                        .collect(Collectors.toList()));
                segmentList.add(season.getRaceList().stream()
                        .filter(race -> race.getRound() > splitRace)
                        .collect(Collectors.toList()));

                List<BigDecimal> valueList = segmentList.stream()
                        .map(segment -> calculateDriverPointsForRaces(season.getPointSystem(), segment,driverIdList))
                        .collect(Collectors.toList());

            }

            //calculateDriverPointsForRaces(season.getPointSystem(),season.getRaceList());

        }
        return null;
    }
*/
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
    private BigDecimal calculateDriverPointsForRaces(PointSystem pointSystem, List<Race> raceList,Set<Long> driverIdList) {



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
