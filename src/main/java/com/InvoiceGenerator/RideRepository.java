package com.InvoiceGenerator;

import java.util.*;

public class RideRepository {

    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    //to add rides to a map by their user ids
    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideArrayList = this.userRides.get(userId);
        if(rideArrayList == null){
            this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    //to get the arrays of the rides of a user
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
