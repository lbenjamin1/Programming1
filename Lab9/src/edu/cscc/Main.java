package edu.cscc;

public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";

    public static void main(String[] args) {


        Surname[] namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) {
            System.out.println("Rank\t\tName");
            for(int f = 0; f < namelist.length; ++f){
                System.out.println(namelist[f].getRank() + "\t\t\t" + namelist[f].getName());
            }
        }
        else{
            System.out.println("Problem With Namelist. Exiting Program");
        }
    }
}