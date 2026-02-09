package it.priori;


public class Main {
    public static void main(String[] args) {
        ContoBancario cb = new ContoBancario("IT12X0542811101000000123", 1000);
        System.out.println(cb.toString());

        cb.preleva(100);
        System.out.println(cb.toString());

        cb.deposita(1000);
        System.out.println(cb.toString());

        System.out.println("Ultimi movimenti: " + cb.getUltimiMovimenti(2));
    }
}