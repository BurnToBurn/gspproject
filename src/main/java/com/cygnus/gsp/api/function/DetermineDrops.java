package com.cygnus.gsp.api.function;

import com.cygnus.gsp.api.domain.model.DropSystem;
import com.cygnus.gsp.api.domain.model.FinishedPosition;
import com.cygnus.gsp.api.domain.model.Race;
import com.cygnus.gsp.api.domain.prototype.DropTotals;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetermineDrops {

    public List<Race> determineDriverDrops(@NotNull List<Race> raceList, @Min(1) Integer totalRacesInGroup, @NotNull DropSystem dropSystem) {

        HashMap<Long, Set<DropTotals>> driverDropList = new HashMap<>();
        for(Race race : raceList) {
            for(FinishedPosition finishedPosition: race.getFinishedPositionList()){
                if(driverDropList.containsKey(finishedPosition.getDriver().getDriverId())){
                    Set<DropTotals> toolList = driverDropList.get(finishedPosition.getDriver().getDriverId());
                    toolList.add(new DropTotals(finishedPosition.getDriver().getDriverId(),finishedPosition.getRank(),race.getRaceId()));
                    driverDropList.put(finishedPosition.getDriver().getDriverId(),toolList);
                }else{
                    Set<DropTotals> dropTotalsList = new HashSet<>();
                    dropTotalsList.add(new DropTotals(finishedPosition.getDriver().getDriverId(),finishedPosition.getRank(),race.getRaceId()));
                    driverDropList.put(finishedPosition.getDriver().getDriverId(),dropTotalsList);
                }

            }
        }

        //sort list
        //determine how many drops based on the number of races in list vs the number of expected races
        //flag races based on ((extected race - total race) - drop race)
        //update racelist
        return null;
    }

    public void determineManufacturerDrops(List<Race> raceList, Integer totalRacesInGroup, DropSystem dropSystem) {
    }

    private int getDropTotal(Integer nbrRaceDrop,Integer expectedNbrRace,Integer nbrOfRace){
        return Math.max(nbrRaceDrop - (expectedNbrRace - nbrOfRace), 0);
    }
}
