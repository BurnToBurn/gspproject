package com.cygnus.gsp.api.domain.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DropTotals implements Comparable<DropTotals> {

    private final Long id;
    private final Integer rank;
    private final Long raceId;

    @Override
    public int compareTo(DropTotals o) {
        return this.rank.compareTo(o.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DropTotals that = (DropTotals) o;
        return id.equals(that.id) && rank.equals(that.rank) && raceId.equals(that.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, raceId);
    }
}
