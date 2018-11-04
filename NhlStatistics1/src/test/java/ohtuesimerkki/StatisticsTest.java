/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jaakko
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
   
    
    @Test
    public void test1(){
        assertEquals("Kurri",stats.search("Kurri").getName());
    }
    
    @Test
    public void test2(){
        assertEquals(null,stats.search("Kekkonen"));
    }
    
    @Test
    public void test3(){
        assertEquals("Yzerman",stats.team("DET").get(0).getName());
    }
    
    @Test
    public void test4(){
        assertEquals(0,stats.team("LOL").size());
    }
    
    @Test
    public void test5(){
        assertEquals(4,stats.topScorers(3).size());
    }
    
    @Test
    public void test6(){
        assertEquals("Gretzky",stats.topScorers(1).get(0).getName());
    }
}
