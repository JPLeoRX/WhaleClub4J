package com.tekleo.whaleclub4j.rest.responses;

public class Payoff {
    private String duration;
    private double payoff;

    public Payoff(String duration, double payoff) {
        this.duration = duration;
        this.payoff = payoff;
    }

    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getDuration() {
        return duration;
    }

    public double getPayoff() {
        return payoff;
    }
    //------------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Payoff{" +
                "duration='" + duration + '\'' +
                ", payoff=" + payoff +
                '}';
    }
}