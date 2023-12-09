
import java.util.Scanner;
import utils.menus;

public class teste {
    
    public static void main(String[] args) {
        String opcao="";
        Scanner scan = new Scanner(System.in);
        
        do {
            

            menus.inicial();
            opcao = scan.nextLine();

            switch (opcao) {
                case "1":
                    menus.ReceberDigitos();
                    break;

                case "2":
                    System.out.println("Opção 2");
                    break;

                case "3":
                    System.out.println("Fim da execução do programa!!");
                    break;
            
                default:
                    menus.entradaInvalida();
                    break;
            }
            
        } while (!opcao.equals("3"));

        scan.close();
        
    }
}
