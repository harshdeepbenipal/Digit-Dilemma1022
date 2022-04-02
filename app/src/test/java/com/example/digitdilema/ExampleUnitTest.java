package com.example.digitdilema;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test_01(){
        Player a = new Player();
        a.setLevel(1);
        a.setName("Vincent");
        a.setDate();
        a.setScore(3);

        Player b = new Player();
        b.setLevel(1);
        b.setName("Khalia");
        b.setDate();
        b.setScore(5);

        Player c = new Player();
        c.setLevel(1);
        c.setName("Gurtaj");
        c.setDate();
        c.setScore(4);

        Player d = new Player();
        d.setLevel(1);
        d.setName("Harsh-Deep");
        d.setDate();
        d.setScore(2);

        ScoreBoard.addPlayer(a);
        ScoreBoard.addPlayer(b);
        ScoreBoard.addPlayer(c);
        ScoreBoard.addPlayer(d);

        assertNotEquals(b,c);
        assertEquals(d.getName(),ScoreBoard.getScoreboard(1)[0].getName());
        assertEquals("Vincent",a.getName());
        assertNull(ScoreBoard.getScoreboard(1)[5]);

        Player e = new Player();
        e.setLevel(1);
        e.setName("Vincent");
        e.setDate();
        e.setScore(1);

        ScoreBoard.addPlayer(e);

        assertEquals(e.getName(),ScoreBoard.getScoreboard(1)[0].getName());
        assertNull(ScoreBoard.getScoreboard(1)[5]);

    }
    @Test
    public void test_02(){
        ScoreBoard z = new ScoreBoard();
        Player a = new Player();
        a.setLevel(2);
        a.setName("Vincent");
        a.setDate();
        a.setScore(7);

        Player a2 = new Player(a);
        a2.setScore(2);

        Player b = new Player();
        b.setLevel(2);
        b.setName("Khalia");
        b.setDate();
        b.setScore(5);

        z.addPlayer(a);
        z.addPlayer(b);
        z.addPlayer(a2);

        assertNull(ScoreBoard.getScoreboard(2)[3]);

        Player c = new Player();
        c.setLevel(2);
        c.setName("Khalia");
        c.setDate();
        c.setScore(1);

        z.addPlayer(c);
        assertEquals(c.getName(),z.getScoreboard(2)[0].getName());

    }
    @Test
    public void test_03(){
        ScoreBoard a = new ScoreBoard();
        Player x = new Player();
        x.setLevel(3);
        x.setName("Gurtaj");
        x.setDate();
        x.setScore(4);
        a.addPlayer(x);

        assertEquals(null,a.getScoreboard(x.getLevel())[1]);
        assertEquals("Gurtaj",a.getScoreboard(x.getLevel())[0].getName());
    }
}