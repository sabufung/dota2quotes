/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dota.DAO;

import com.dota.Models.Dota2Info;
import com.dota.Parser.Dota2.Dota2ParserImpl;
import com.dota.Parser.Dota2.IDota2Parser;
import com.dota.ParserInfo.Dota2ParserInfoImpl;
import com.dota.ParserInfo.IDota2ParserInfo;
import java.util.List;

/**
 *
 * @author MyPC
 */
public class Dota2DAO {
    
    public List<Dota2Info> getData(){
        IDota2ParserInfo info = new Dota2ParserInfoImpl();
        IDota2Parser parser = new Dota2ParserImpl();
        
        parser.setDota2ParseInfo(info);
        
        List<Dota2Info> resultList = parser.getDota2Infos();
        
        return resultList;
    }
    
}
