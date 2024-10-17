package com.example.kulb_lab1;

public class coachAppointment {
    private int playerId;
    private String playerName;
    private String coachName;
    private int coachRoom;

    public coachAppointment(int playerId, String playerName, String coachName, int coachRoom) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.coachName = coachName;
        this.coachRoom = coachRoom;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getCoachRoom() {
        return coachRoom;
    }

    public void setCoachRoom(int coachRoom) {
        this.coachRoom = coachRoom;
    }
}