/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dota.Parser.Dota2;

import com.dota.ParserInfo.IDota2ParserInfo;
import com.dota.Models.Dota2Info;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author MyPC
 */
public class Dota2ParserImpl implements IDota2Parser {

    private IDota2ParserInfo info;
    private WebClient webClient;

    public Dota2ParserImpl() {
        LogFactory.getFactory()
                .setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        webClient = new WebClient(BrowserVersion.FIREFOX_17);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    }

    @Override
    public List<Dota2Info> getDota2Infos() {
        try {
            List<Dota2Info> dota2Infos = new ArrayList<>();

            HtmlPage page = webClient.getPage(info.getWebPage());

            List<HtmlElement> dates = (List<HtmlElement>) page.getByXPath(info.getDate());

            for (int i = 0; i < dates.size(); i++) {
                String date = dates.get(i).getTextContent();
                List<HtmlElement> times = (List<HtmlElement>) page.getByXPath(info.getTime());
                List<HtmlElement> players = (List<HtmlElement>) page.getByXPath(info.getPlayer());
                List<HtmlElement> teams = (List<HtmlElement>) page.getByXPath(info.getTeam());
                List<HtmlElement> actions = (List<HtmlElement>) page.getByXPath(info.getAction());
                List<HtmlElement> ids = (List<HtmlElement>) page.getByXPath(info.getId());

                String time = times.get(i).getTextContent();
                String player = players.get(i).getTextContent().trim();
                String team = teams.get(i).getTextContent().trim();
                String action = actions.get(i).getTextContent().trim();
                String id = ids.get(i).getTextContent().trim();

                Dota2Info dota2Info = new Dota2Info(date, time, player, team, action, id);
                dota2Infos.add(dota2Info);
            }
            return dota2Infos;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FailingHttpStatusCodeException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setDota2ParseInfo(IDota2ParserInfo info) {
        this.info = info;
    }

}
