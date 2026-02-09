package it.priori;

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
     * Deposita una somma di denaro sul conto bancario, incrementando il saldo.
     * @param importo la somma di denaro da depositare
     * @throws IllegalArgumentException se l'importo è negativo
     */
    public void deposita(double importo){
        if(importo < 0){
            throw new IllegalArgumentException();
        }else{
            saldo += importo;
        }
    }

    /**
     * Preleva una somma di denaro dal conto bancario, decrementando il saldo
     * @param importo la somma di denaro da prelevare
     * @throws IllegalArgumentException se l'importo e' negativo o supera il saldo
     */
    public void preleva(double importo){
        if(importo < 0 || importo > saldo){
            throw new IllegalArgumentException();
        }else{
            saldo -= importo;
        }
    }

    /**
     * Restituisce una rappresentazione stringa del conto bancario. Include l'IBAN e il saldo. La rappresentazione stringa e' formattata per essere facile da leggere e comprendere. Ecco un esempio di come potrebbe apparire la rappresentazione stringa:
     * <br>```
     * <br>Conto Bancario:<br>IBAN: IT12X0542811101000000123<br>Saldo: 1000.0 EUR
     * <br>```
     * @return una rappresentazione stringa del conto bancario, inclusivo di IBAN e saldo
     */
    @Override
    public String toString() {
        return "Conto Bancario:\nIBAN: " + iban + "\nSaldo: " + saldo + "EUR";
    }
    
}
