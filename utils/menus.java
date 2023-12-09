package utils;

import java.util.Scanner;
import utils.verificarDigitoDAC;
import java.io.IOException; 
import java.lang.Thread;    


public class menus {

    private static void esperar(int tempo){
        try {
            Thread.sleep(tempo*1000); // Pausa por 3 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    private static void exibirBarras(){
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
        exibirBarras();
        System.out.println("    ENTRADA INVÁLIDA");
        System.out.println("    TENTE NOVAMENTE");
    }

    public static void inicial() {
        limparTerminal();
        exibirBarras();
        System.out.println("        Contas e Tributos");
        System.out.println(" (Água, Luz, Telefone, IPTU, ISS)");
        exibirBarras();
        System.out.println("  1) Pagamento com Código de Barras");
        System.out.println("  2) Imprimir 2ª Via de Boleto");
        System.out.println("  3) Sair");
        exibirBarras();
        System.out.print(" Digite a opção: ");
    }

    public static void ReceberDigitos(){
        Scanner scan = new Scanner(System.in);
        int dacCorreto = 0;
        limparTerminal();
        exibirBarras();

        for (int i = 1; i <= 4; i++) {  //receber os 4 dígitos boxe
            System.out.print("Digite o BOXE-"+i+": ");
            String digitos = scan.nextLine();
            String retorno = verificarDigitoDAC.boxe(digitos);

            if( retorno == "valido"){
                dacCorreto+=1;
            }else{

                switch (retorno){
                    case "menor":
                        System.out.println("Código não possue 12 dígitos");
                        break;
                    case "nao Numerico":
                        System.out.println("Código não possue apenas números");
                        break;
                    case "dac Errado":
                        System.out.println("Digito verificador inválido");
                        break;
                }
                
                esperar(3);
                break;
            }
        }
        if(dacCorreto == 4){
            System.out.println("Pagamento efetuado com sucesso!");
            esperar(3);
        }
    }
}
