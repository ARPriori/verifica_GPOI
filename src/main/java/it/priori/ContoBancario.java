package it.priori;

import java.util.ArrayList;

/**
 * Classe che rappresenta un conto bancario.
 */
public class ContoBancario {
    /**
     * L'IBAN del conto bancario.
     */
    protected String iban;
    /**
     * Il saldo del conto bancario.
     */
    protected double saldo;
    /**
     * La lista dei movimenti del conto bancario.
     */
    protected ArrayList<String> movimenti = new ArrayList<>();

    /**
     * Costruttore che inizializza il conto bancario con un IBAN e un saldo.
     * @param iban il numero del conto bancario
     * @param saldo il saldo iniziale del conto bancario
     */
    public ContoBancario(String iban, double saldo){
        this.iban = iban;
        this.saldo = saldo;
    }

    /**
     * Restituisce il numero del conto bancario.
     * @return il numero del conto bancario
     */
    public String getIban() {
        return iban;
    }

    /**
     * Restituisce il saldo del conto bancario.
     * @return il saldo del conto bancario
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Restituisce la lista dei movimenti del conto bancario.
     * @return la lista dei movimenti del conto bancario
     */
    public ArrayList<String> getMovimenti() {
        return movimenti;
    }

    /**
     * Restituisce gli ultimi n movimenti del conto bancario.
     * @param n il numero di movimenti da restituire
     * @return gli ultimi n movimenti del conto bancario
     */
    public ArrayList<String> getUltimiMovimenti(int n){
        ArrayList<String> ultimiMov = new ArrayList<>();
        if(n > movimenti.size()){
            return null;
        }
        
        for(int i = 1; i <= n; i++){
            ultimiMov.add(movimenti.get(movimenti.size()-i));
        }
        return ultimiMov;
    }

    /**
     * Deposita una somma di denaro sul conto bancario, incrementando il saldo. Viene aggiornata la lista dei movimenti
     * @param importo la somma di denaro da depositare
     * @throws IllegalArgumentException se l'importo è negativo
     */
    public void deposita(double importo){
        if(importo < 0){
            throw new IllegalArgumentException();
        }else{
            saldo += importo;
            movimenti.add("deposito di " + importo + "EUR");
        }
    }

    /**
     * Preleva una somma di denaro dal conto bancario, decrementando il saldo Viene aggiornata la lista dei movimenti
     * @param importo la somma di denaro da prelevare
     * @throws IllegalArgumentException se l'importo e' negativo o supera il saldo
     */
    public void preleva(double importo){
        if(importo < 0 || importo > saldo){
            throw new IllegalArgumentException();
        }else{
            saldo -= importo;
            movimenti.add("pelievo di " + importo + "EUR");
        }
    }

    /**
     * Restituisce una rappresentazione stringa del conto bancario. Include l'IBAN, il saldo e l'ultimo movimento effettuato (se presenti). La rappresentazione stringa e' formattata per essere facile da leggere e comprendere. Ecco un esempio di come potrebbe apparire la rappresentazione stringa:
     * <br>```
     * <br>Conto Bancario:<br>IBAN: IT12X0542811101000000123<br>Saldo: 1000.0 EUR<br>Ultimo Movimento:<br>- deposito di 100 EUR
     * <br>```
     * @return una rappresentazione stringa del conto bancario, inclusivo di IBAN, saldo e ultimo movimento
     */
    @Override
    public String toString() {
        return "Conto Bancario:\nIBAN: " + iban + "\nSaldo: " + saldo + "EUR\nUltimo Movimento:\n" + ((movimenti.size() == 0)? "nessun movimento registrato" : movimenti.getLast());
    }
    
}
