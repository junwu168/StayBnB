package com.laioffer.staybooking.model;

import javax.persistence.*;

@Entity
@Table(name = "stay_reserved_date")
public class StayReservedDate {
    @EmbeddedId
    private StayReservedDateKey id;
    @MapsId("stay_id")
    @ManyToOne //can have many reserved dates to one stay
    private Stay stay;

    public StayReservedDate() {
    }

    public StayReservedDate(StayReservedDateKey id, Stay stay) {
        this.id = id;
        this.stay = stay;
    }

    public StayReservedDateKey getId() {
        return id;
    }

    public Stay getStay() {
        return stay;
    }


}
