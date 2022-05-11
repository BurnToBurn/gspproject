package com.cygnus.gsp.api.function;

import com.cygnus.gsp.api.domain.model.DropSystem;
import com.cygnus.gsp.api.domain.model.Race;
import com.cygnus.gsp.api.domain.prototype.DropTotals;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

public class DetermineDrops {

    public void determineDriverDrops(@NotNull List<Race> raceList, @Min(1) Integer totalRacesInGroup, @NotNull DropSystem dropSystem) {
        HashMap<Long,List<DropTotals>> driverDropList = new HashMap<>();
        for(Race race : raceList) {
            ;
        }
    }

    public void determineManufacturerDrops(List<Race> raceList, Integer totalRacesInGroup, DropSystem dropSystem) {
        ;
    }
}
