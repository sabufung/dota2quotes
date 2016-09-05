/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dota.Models;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class Dota2Info {

    private String Date;
    private String Time;
    private String Player;
    private String Team;
    private String Action;
    private String Id;

    public Dota2Info(String Date, String Time, String Player, String Team, String Action, String Id) {
        this.Date = Date;
        this.Time = Time;
        this.Player = Player;
        this.Team = Team;
        this.Action = Action;
        this.Id = Id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        try {
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Time timeValue = new Time(formatter.parse(Time.replace("PDT", "")).getTime());
            return timeValue.toString();
        } catch (ParseException ex) {
            return Time.replace("PDT", "");
        }
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getPlayer() {
        return Player.replace("()", "");
    }

    public void setPlayer(String Player) {
        this.Player = Player;
    }

    public String getTeam() {
        return Team.substring(0, Team.indexOf("("));
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public String getId() {
        return Id.substring(Id.indexOf("(")+5,Id.indexOf(")"));
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
    
}
