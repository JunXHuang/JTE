/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Jun
 */
public class Dijkstra {

    public static Vertex[] allCities = new Vertex[CSV.inc2];

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);

                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    public static void initPath() {
        int counter = 0;
        int counter1 = 0;
        int counter2 = 0;
        int total = 0;
        //  int gg=0;

        for (int i = 0; i < CSV.inc2; i++) {
            allCities[i] = new Vertex(CSV.mapName[i]);
        }
        for (int i = 0; i < CSV.inc2; i++) {
            counter = 0;
            counter1 = 0;
            counter2 = 0;
            // System.out.println(CSV.mapName[i]);
            for (int jj = 0; jj < CSV.inc3; jj++) {
                if (CSV.mapName[i].equals(CSV.flightCityName[jj])) {
                    //  System.out.println("jj="+(++gg));

                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (jjj != jj) {
                            if (CSV.flightCityQ[jjj] == CSV.flightCityQ[jj]) {
                                counter2++;
                            }
                        }
                    }
                    switch (CSV.flightCityQ[jj]) {
                        case 1:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 2) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 4) {
                                    counter2++;
                                }
                            }
                            break;
                        case 2:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 1) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 3) {
                                    counter2++;
                                }
                            }
                            break;
                        case 3:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 2) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 4) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 6) {
                                    counter2++;
                                }
                            }
                            break;
                        case 4:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 1) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 3) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 5) {
                                    counter2++;
                                }
                            }
                            break;
                        case 5:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 6) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 4) {
                                    counter2++;
                                }
                            }
                            break;
                        case 6:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 3) {
                                    counter2++;
                                } else if (CSV.flightCityQ[jjj] == 5) {
                                    counter2++;
                                }
                            }
                            break;
                    }

                }
            }
            for (int j = 0; j < CSV.inc2; j++) {
                if (CSV.mapName[i].equals(XMLParser.ctNames[j])) {
                    for (int k = 0; k < XMLParser.nLand[j]; k++) {
                        if ((k + 1) % 2 == 0) {
                            for (int l = 0; l < CSV.inc2; l++) {
                                if (CSV.mapName[l].equals(XMLParser.ctLand[j][k])) {
                                    counter++;
                                }
                            }
                        }
                    }
                    for (int k = 0; k < XMLParser.nSea[j]; k++) {
                        if ((k + 1) % 2 == 0) {
                            for (int l = 0; l < CSV.inc2; l++) {
                                if (CSV.mapName[l].equals(XMLParser.ctSea[j][k])) {
                                    counter1++;
                                }
                            }
                        }
                    }
                }
            }
            total = counter + counter1;
            total += counter2;
            // System.out.println("total = "+total+"   i = "+i);
            if (total > 0) {
                allCities[i].adjacencies = new Edge[total];
            }
        }
        for (int i = 0; i < CSV.inc2; i++) {
            counter = 0;
            for (int jj = 0; jj < CSV.inc3; jj++) {
                if (CSV.mapName[i].equals(CSV.flightCityName[jj])) {
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (jjj != jj) {
                            if (CSV.flightCityQ[jjj] == CSV.flightCityQ[jj]) {
                                for (int jk = 0; jk < CSV.inc2; jk++) {
                                    if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                        allCities[i].adjacencies[counter] = new Edge(allCities[jk], 2);
                                        counter++;
                                    }
                                }
                            }
                        }
                    }
                    switch (CSV.flightCityQ[jj]) {
                        case 1:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 2) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 4) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                        case 2:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 1) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 3) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                        case 3:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 2) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 4) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 6) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                        case 4:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 1) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 3) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 5) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                        case 5:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 6) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 4) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                        case 6:
                            for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                                if (CSV.flightCityQ[jjj] == 3) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                                if (CSV.flightCityQ[jjj] == 5) {
                                    for (int jk = 0; jk < CSV.inc2; jk++) {
                                        if (CSV.mapName[jk].equals(CSV.flightCityName[jjj])) {
                                            allCities[i].adjacencies[counter] = new Edge(allCities[jk], 4);
                                            counter++;
                                        }
                                    }
                                }
                            }
                            break;
                    }

                }
            }
            //  System.out.println("gg = "+i);
            for (int j = 0; j < CSV.inc2; j++) {
                if (CSV.mapName[i].equals(XMLParser.ctNames[j])) {
                    for (int k = 0; k < XMLParser.nLand[j]; k++) {
                        if ((k + 1) % 2 == 0) {
                            for (int l = 0; l < CSV.inc2; l++) {
                                if (CSV.mapName[l].equals(XMLParser.ctLand[j][k])) {
                                    allCities[i].adjacencies[counter] = new Edge(allCities[l], 1);
                                    counter++;
                                }
                            }
                        }
                    }
                    for (int k = 0; k < XMLParser.nSea[j]; k++) {
                        if ((k + 1) % 2 == 0) {
                            for (int l = 0; l < CSV.inc2; l++) {
                                if (CSV.mapName[l].equals(XMLParser.ctSea[j][k])) {
                                    allCities[i].adjacencies[counter] = new Edge(allCities[l], 6);
                                    counter++;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public List Spath(int from, int to) {
        //System.out.println("from=" + from + "  to=" + to);
        for(int i=0;i<CSV.inc2;i++){
       allCities[i].minDistance=Double.POSITIVE_INFINITY;
       allCities[i].previous=null;
        }
        computePaths(allCities[from]);
    //    System.out.println("Distance from " + allCities[from] + " to " + allCities[to] + ": " + allCities[to].minDistance);
        List<Vertex> path = getShortestPathTo(allCities[to]);
       // System.out.println("Path: " + path);
        return path;
    }
}
