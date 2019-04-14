package sample;

import java.util.ArrayList;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;

    public Artikal() {
    }

    public Artikal(String recenica){
        String [] novi=recenica.split(",");
        sifra=novi[0];
        naziv=novi[1];
        cijena=Double.parseDouble(novi[2]);
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    @Override
    public String toString() {
        return  this.sifra + "," + naziv + "," + cijena;
    }
    public boolean equals(Object o){
        Artikal artikal=(Artikal)o;
        if(!naziv.equals(artikal.getNaziv()))
            return false;
        if(!sifra.equals(artikal.getSifra()))
            return false;
        if(Double.compare(cijena, artikal.getCijena())!=0)
            return false;

        return true;

    }

    @Override
    public int hashCode() {
        int rezultat;
        long pomocna;
        rezultat=getSifra()!=null? getSifra().hashCode():0;
        rezultat=31*rezultat+(getNaziv()!= null ? getNaziv().hashCode() : 0);
        pomocna=Double.doubleToLongBits(getCijena());
        rezultat=31*rezultat+(int)(pomocna^(pomocna >>> 32));
        return rezultat;
    }


    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli){
        for(int i =0;i<artikli.size();i++){
            for(int j=i+1;j<artikli.size();j++){
                if(artikli.get(i).equals(artikli.get(j))){
                    artikli.remove(j);
                }
            }
        }
    return artikli;
    }

}
