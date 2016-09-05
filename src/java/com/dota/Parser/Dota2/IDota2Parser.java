/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dota.Parser.Dota2;

import com.dota.ParserInfo.IDota2ParserInfo;
import com.dota.Models.Dota2Info;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface IDota2Parser {
    List<Dota2Info> getDota2Infos();
    void setDota2ParseInfo(IDota2ParserInfo info);
}
