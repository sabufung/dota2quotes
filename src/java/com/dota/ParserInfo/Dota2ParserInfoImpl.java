/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dota.ParserInfo;

/**
 *
 * @author MyPC
 */
public class Dota2ParserInfoImpl implements IDota2ParserInfo{

    @Override
    public String getDate() {
        return "//div[8]/div/div[1][not(contains(@style, 'min-width:75px'))]";
    }

    @Override
    public String getTime() {
        return "//div[8]/div/div[2][not(contains(@style, 'min-width:82px'))]";
    }

    @Override
    public String getPlayer() {
        return "//div[8]/div/div[4][span]";
    }

    @Override
    public String getTeam() {
        return "//div[8]/div/div[5][span]";
    }

    @Override
    public String getAction() {
        return "//div[8]/div/div[6][not(contains(text(), 'Action'))]";
    }

    @Override
    public String getWebPage() {
        return "http://www.dota2.com/majorsregistration/list";
    }

    @Override
    public String getParsePage() {
        return "http://www.dota2.com/majorsregistration/list";
    }

    @Override
    public String getId() {
         return "//div[8]/div/div[5][span]";
    }
    
}
