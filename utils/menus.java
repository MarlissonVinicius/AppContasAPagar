package utils;

import java.util.Scanner;
import utils.verificarDigitoDAC;
import java.io.IOException;     


public class menus {

    private static void Barras(){
        String saida = ""; 
        for (int i = 0; i < 35; i++) {
            saida += "-";
        }
        System.out.println(saida);
    }

    private static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void entradaInvalida() {
        limparTerminal();
        Barras();
        System.out.println("    ENTRADA INVÁLIDA");
        System.out.println("    TENTE NOVAMENTE");
    }

    public static void inicial() {
        limparTerminal();
        Barras();
        System.out.println("        Contas e Tributos");
        System.out.println(" (Água, Luz, Telefone, IPTU, ISS)");
        Barras();
        System.out.println("  1) Pagamento com Código de Barras");
        System.out.println("  2) Imprimir 2ª Via de Boleto");
        System.out.println("  3) Sair");
        Barras();
        System.out.print(" Digite a opção: ");
    }

    public static void ReceberDig(){
        limparTerminal();
        Barras();
    }
}