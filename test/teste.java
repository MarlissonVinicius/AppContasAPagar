
import java.util.Scanner;
import utils.menus;
import utils.verificarDigitoDAC;
import java.lang.Thread;

public class teste {
    
    public static void main(String[] args) {
        String opcao="";
        Scanner scan = new Scanner(System.in);
        
        do {
            menus.inicial();
            opcao = scan.nextLine();
            switch (opcao) {
                case "1":
                    //System.out.println("Opção 1");
                    menus.ReceberDig();
                    for (int i = 1; i <= 4; i++) {
                        System.out.println("Digite o BOXE-"+i+": ");
                        String digitos = scan.nextLine();
                        
                        if(verificarDigitoDAC.boxe(digitos)){
                            System.out.println("Pagamento efetuado com sucesso");
                        }else{
                            System.out.println("Digito verificador inválido!");
                            try {
                                Thread.sleep(3000); // Pausa por 1 segundo
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        } 
                    }
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
           
        } while (opcao!="3");

        scan.close();
    }
}
