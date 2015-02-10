/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.util.List;

/**
 *
 * @author Jun
 */
public class Ai {

    public void getNewAiPath(int from, int to) {
        Dijkstra ai = new Dijkstra();
        switch (AllData.currentplayingPlayer) {
            case 0:
                AllData.playerAI1 = ai.Spath(from, to);
                break;
            case 1:
                AllData.playerAI2 = ai.Spath(from, to);
                break;
            case 2:
                AllData.playerAI3 = ai.Spath(from, to);
                break;
            case 3:
                AllData.playerAI4 = ai.Spath(from, to);
                break;
            case 4:
                AllData.playerAI5 = ai.Spath(from, to);
                break;
            case 5:
                AllData.playerAI6 = ai.Spath(from, to);
                break;
        }
    }

    public void initAI() {
        Dijkstra ai = new Dijkstra();
        switch (AllData.players) {
            case 6:
                if (AllData.realPlayers[5] == false) {
                    AllData.playerAI6 = ai.Spath(AllData.playerCardIndex[5][0], AllData.playerCardIndex[5][1]);
                    AllData.playerAI6.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[5][1], AllData.playerCardIndex[5][2]);
                     List b=ai.Spath(AllData.playerCardIndex[5][2], AllData.playerCardIndex[5][3]);
                     List c=ai.Spath(AllData.playerCardIndex[5][3], AllData.playerCardIndex[5][4]);
                     List d=ai.Spath(AllData.playerCardIndex[5][4], AllData.playerCardIndex[5][5]);
                     List e=ai.Spath(AllData.playerCardIndex[5][5], AllData.playerCardIndex[5][6]);
                     List f=ai.Spath(AllData.playerCardIndex[5][6], AllData.playerCardIndex[5][7]);
                     List g=ai.Spath(AllData.playerCardIndex[5][7], AllData.playerCardIndex[5][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI6.addAll(a);
                    AllData.playerAI6.addAll(b);
                    AllData.playerAI6.addAll(c);
                    AllData.playerAI6.addAll(d);
                    AllData.playerAI6.addAll(e);
                    AllData.playerAI6.addAll(f);
                    AllData.playerAI6.addAll(g);
                    System.out.println("AI player 6 total path = "+ AllData.playerAI6);
                    
                }
            case 5:
                if (AllData.realPlayers[4] == false) {
                     AllData.playerAI5 = ai.Spath(AllData.playerCardIndex[4][0], AllData.playerCardIndex[4][1]);
                    AllData.playerAI5.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[4][1], AllData.playerCardIndex[4][2]);
                     List b=ai.Spath(AllData.playerCardIndex[4][2], AllData.playerCardIndex[4][3]);
                     List c=ai.Spath(AllData.playerCardIndex[4][3], AllData.playerCardIndex[4][4]);
                     List d=ai.Spath(AllData.playerCardIndex[4][4], AllData.playerCardIndex[4][5]);
                     List e=ai.Spath(AllData.playerCardIndex[4][5], AllData.playerCardIndex[4][6]);
                     List f=ai.Spath(AllData.playerCardIndex[4][6], AllData.playerCardIndex[4][7]);
                     List g=ai.Spath(AllData.playerCardIndex[4][7], AllData.playerCardIndex[4][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI5.addAll(a);
                    AllData.playerAI5.addAll(b);
                    AllData.playerAI5.addAll(c);
                    AllData.playerAI5.addAll(d);
                    AllData.playerAI5.addAll(e);
                    AllData.playerAI5.addAll(f);
                    AllData.playerAI5.addAll(g);
                    System.out.println("AI player 5 total path = "+ AllData.playerAI5);
                    
                }
            case 4:
                if (AllData.realPlayers[3] == false) {
                AllData.playerAI4 = ai.Spath(AllData.playerCardIndex[3][0], AllData.playerCardIndex[3][1]);
                    AllData.playerAI4.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[3][1], AllData.playerCardIndex[3][2]);
                     List b=ai.Spath(AllData.playerCardIndex[3][2], AllData.playerCardIndex[3][3]);
                     List c=ai.Spath(AllData.playerCardIndex[3][3], AllData.playerCardIndex[3][4]);
                     List d=ai.Spath(AllData.playerCardIndex[3][4], AllData.playerCardIndex[3][5]);
                     List e=ai.Spath(AllData.playerCardIndex[3][5], AllData.playerCardIndex[3][6]);
                     List f=ai.Spath(AllData.playerCardIndex[3][6], AllData.playerCardIndex[3][7]);
                     List g=ai.Spath(AllData.playerCardIndex[3][7], AllData.playerCardIndex[3][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI4.addAll(a);
                    AllData.playerAI4.addAll(b);
                    AllData.playerAI4.addAll(c);
                    AllData.playerAI4.addAll(d);
                    AllData.playerAI4.addAll(e);
                    AllData.playerAI4.addAll(f);
                    AllData.playerAI4.addAll(g);
                    System.out.println("AI player 4 total path = "+ AllData.playerAI4);
                    
                }
            case 3:
                if (AllData.realPlayers[2] == false) {
                     AllData.playerAI3 = ai.Spath(AllData.playerCardIndex[2][0], AllData.playerCardIndex[2][1]);
                    AllData.playerAI3.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[2][1], AllData.playerCardIndex[2][2]);
                     List b=ai.Spath(AllData.playerCardIndex[2][2], AllData.playerCardIndex[2][3]);
                     List c=ai.Spath(AllData.playerCardIndex[2][3], AllData.playerCardIndex[2][4]);
                     List d=ai.Spath(AllData.playerCardIndex[2][4], AllData.playerCardIndex[2][5]);
                     List e=ai.Spath(AllData.playerCardIndex[2][5], AllData.playerCardIndex[2][6]);
                     List f=ai.Spath(AllData.playerCardIndex[2][6], AllData.playerCardIndex[2][7]);
                     List g=ai.Spath(AllData.playerCardIndex[2][7], AllData.playerCardIndex[2][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI3.addAll(a);
                    AllData.playerAI3.addAll(b);
                    AllData.playerAI3.addAll(c);
                    AllData.playerAI3.addAll(d);
                    AllData.playerAI3.addAll(e);
                    AllData.playerAI3.addAll(f);
                    AllData.playerAI3.addAll(g);
                    System.out.println("AI player 3 total path = "+ AllData.playerAI3);
                    
                }
            case 2:
                if (AllData.realPlayers[1] == false) {
                    AllData.playerAI2 = ai.Spath(AllData.playerCardIndex[1][0], AllData.playerCardIndex[1][1]);
                    AllData.playerAI2.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[1][1], AllData.playerCardIndex[1][2]);
                     List b=ai.Spath(AllData.playerCardIndex[1][2], AllData.playerCardIndex[1][3]);
                     List c=ai.Spath(AllData.playerCardIndex[1][3], AllData.playerCardIndex[1][4]);
                     List d=ai.Spath(AllData.playerCardIndex[1][4], AllData.playerCardIndex[1][5]);
                     List e=ai.Spath(AllData.playerCardIndex[1][5], AllData.playerCardIndex[1][6]);
                     List f=ai.Spath(AllData.playerCardIndex[1][6], AllData.playerCardIndex[1][7]);
                     List g=ai.Spath(AllData.playerCardIndex[1][7], AllData.playerCardIndex[1][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI2.addAll(a);
                    AllData.playerAI2.addAll(b);
                    AllData.playerAI2.addAll(c);
                    AllData.playerAI2.addAll(d);
                    AllData.playerAI2.addAll(e);
                    AllData.playerAI2.addAll(f);
                    AllData.playerAI2.addAll(g);
                    System.out.println("AI player 2 total path = "+ AllData.playerAI2);
                    
                }
            case 1:
                if (AllData.realPlayers[0] == false) {
                    AllData.playerAI1 = ai.Spath(AllData.playerCardIndex[0][0], AllData.playerCardIndex[0][1]);
                    AllData.playerAI1.remove(0);
                    List a=ai.Spath(AllData.playerCardIndex[0][1], AllData.playerCardIndex[0][2]);
                     List b=ai.Spath(AllData.playerCardIndex[0][2], AllData.playerCardIndex[0][3]);
                     List c=ai.Spath(AllData.playerCardIndex[0][3], AllData.playerCardIndex[0][4]);
                     List d=ai.Spath(AllData.playerCardIndex[0][4], AllData.playerCardIndex[0][5]);
                     List e=ai.Spath(AllData.playerCardIndex[0][5], AllData.playerCardIndex[0][6]);
                     List f=ai.Spath(AllData.playerCardIndex[0][6], AllData.playerCardIndex[0][7]);
                     List g=ai.Spath(AllData.playerCardIndex[0][7], AllData.playerCardIndex[0][0]);
                    a.remove(0);
                    b.remove(0);
                    c.remove(0);
                    d.remove(0);
                    e.remove(0);
                    f.remove(0);
                    g.remove(0);
                    AllData.playerAI1.addAll(a);
                    AllData.playerAI1.addAll(b);
                    AllData.playerAI1.addAll(c);
                    AllData.playerAI1.addAll(d);
                    AllData.playerAI1.addAll(e);
                    AllData.playerAI1.addAll(f);
                    AllData.playerAI1.addAll(g);
                    System.out.println("AI player 1 total path = "+ AllData.playerAI1);
                    
                }
        }
    }

}
