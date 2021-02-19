package com.s22034.goldys;

public class Main {
    public static void main(String[] args) {

        Fabryka fabryka = new Fabryka("truskawkowy");
        Cukierek[] tab = fabryka.produkuj(10);
        try {
            for (int i = 0; i < tab.length; i++)
                System.out.println(tab[i]);
            System.out.println(fabryka.produkuj(10)[9]);
            System.out.println(fabryka.produkuj(5)[5]);
        }catch (Exception ex){
            System.out.println("My fault");
        }
    }
}

class Fabryka{

    String smak;
    int index;

    public Fabryka(String smak) {
        this.smak = smak;
        this.index = 0;
    }

    public String getSmak(){
        return this.smak;
    }

    public int getIndex(){
        return this.index;
    }

    public void increseIndex(){
        this.index += 1;
    }

    public Cukierek[] produkuj(int ilosc){
        System.out.println(
                "Produkcja " + ilosc + " cukierkow o smaku: " + getSmak()
        );

        Cukierek[] cukierekTab = new Cukierek[ilosc];

        int counter = 0;

        for(int i = 0; i < ilosc; i++){
            increseIndex();
            counter++;
            cukierekTab[i] = new Cukierek(getSmak(), getIndex());
            if((counter%5) == 0){
                System.out.println(
                        "Wyprodukowano " + counter + " cukierkow"
                );
                counter = 0;
            }
        }

        return cukierekTab;
    }
}

class Cukierek extends Fabryka{

    public Cukierek(String smak, int index) {
        super(smak);
        this.index = index;
    }

    @Override
    public String toString() {
        return "Cukierek nr " +  getIndex() + " smak: " + this.smak + ((getIndex() <=5) ? "11" : "");
    }
}