package com.InvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideStorage {

    Map<String, ArrayList<RideDetails>> userRides = new HashMap<>();

    public void addRides(String userId, RideDetails[] rides) {
        ArrayList<RideDetails> rideList = this.userRides.get(userId);
        this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    public RideDetails[] getRiders(String userId) {
        return this.userRides.get(userId).toArray(new RideDetails[0]);
    }
}
