/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jun
 */
public class CSV {

    public static String[] mapName = new String[180];
    public static String[] mapColor = new String[180];
    public static double[] mapQuarter = new double[180];
    public static double[] mapX = new double[180];
    public static double[] mapY = new double[180];
    public static boolean splash = true;
    public static String[] cityNameInfo = new String[180];
    public static String[] cityInfoData = new String[180];
    public static String[] flightCityName = new String[35];
    public static int[] flightCityQ = new int[35];
    public static int[] flightCityX = new int[35];
    public static int[] flightCityY = new int[35];

    String line = "";
    public static int inc2 = 0;
    public static int inc1 = 0;
    public static int inc3 = 0;

    void setupCSV() {
        Scanner scan1 = null;
        String filename1 = "data/loadInfo.txt";
        try {
            scan1 = new Scanner(new BufferedReader(new FileReader(filename1)));
            while (scan1.hasNextLine()) {
                cityNameInfo[inc1] = scan1.nextLine();
                cityNameInfo[inc1] = cityNameInfo[inc1].toUpperCase();
                cityInfoData[inc1] = scan1.nextLine();
                inc1++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // System.out.println(inc1);
        //442 596
        Scanner scan = null;
        String filename = "data/cities.csv";
        try {
            scan = new Scanner(new BufferedReader(new FileReader(filename)));
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] inArray = line.split(",");
                mapName[inc2] = inArray[0];
                mapColor[inc2] = inArray[1];
                mapQuarter[inc2] = Integer.parseInt(inArray[2]);
                mapX[inc2] = Integer.parseInt(inArray[3]) * 0.21990049751;
                mapY[inc2] = Integer.parseInt(inArray[4]) * 0.23199688594;

                inc2++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner scan3 = null;
        String filename3 = "data/flightCitiesCSV.csv";
        try {
            scan3 = new Scanner(new BufferedReader(new FileReader(filename3)));
            while (scan3.hasNextLine()) {
                line = scan3.nextLine();
                String[] inArray = line.split(",");
                flightCityName[inc3] = inArray[0];
                flightCityQ[inc3] = Integer.parseInt(inArray[3]);
                flightCityX[inc3] = Integer.parseInt(inArray[1])/2;
                flightCityY[inc3] = Integer.parseInt(inArray[2])/2;
                inc3++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
