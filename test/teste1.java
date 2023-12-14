import utils.CalcularDigitoDAC;
import utils.verificarDigitoDAC;

public class teste1 {
    
    private static double retirarValor(String boxesUnidos){
        
        String stringValor = boxesUnidos.substring(4,11) + boxesUnidos.substring(12, 16);
        double doubleValor = Double.parseDouble(stringValor)/100;
        
        return doubleValor;
    }

    private static String preencherComZeros(String valorIncompleto, int comprimento){
        int tamValor = comprimento-valorIncompleto.length(); //quantidade que irá completar com 0

        for (int i = tamValor; i > 0 ; i--) {
            
            valorIncompleto = "0" + valorIncompleto;

        }

        return valorIncompleto;
    }

    private static String formatarBoleto(String entrada){
        
        String boxe1 = entrada.substring(0, 11);
        String boxe2 = entrada.substring(11, 22);;
        String boxe3 = entrada.substring(22, 33);;
        String boxe4 = entrada.substring(33);;
        String boletoCompleto = (boxe1+"-"+CalcularDigitoDAC.main(boxe1)+" "+
                                boxe2+"-"+CalcularDigitoDAC.main(boxe2)+" "+
                                boxe3+"-"+CalcularDigitoDAC.main(boxe3)+" "+
                                boxe4+"-"+CalcularDigitoDAC.main(boxe4));
        
        
        return boletoCompleto;
    }

    public static String Gerarboleto(String codigo, String valorFatura, String identEmpresa, String uniConsumidora, String data, String sequencial) {
        String boletoImcompleto = (codigo+
                                    preencherComZeros(valorFatura, 11)+
                                    preencherComZeros(identEmpresa, 7)+
                                    preencherComZeros(uniConsumidora, 7)+
                                    data+
                                    "9"+ //digito separador
                                    preencherComZeros(sequencial, 7)+
                                    "9"); //digito separador
        
        String digito = CalcularDigitoDAC.geral(boletoImcompleto);

        boletoImcompleto = (boletoImcompleto.substring(0,4)+digito+boletoImcompleto.substring(4));

        return formatarBoleto(boletoImcompleto);
        //83600000001-7 65270148000-4 102074920190-4 7900001019-2
        //83600000001-7 65270148000-4 10207492019-3 07900001019-2
                                  
    }

    public static void main(String[] args) {
        String codigo = "8262000000006635500410116";
        System.out.println(retirarValor(codigo));

        String valor = "6514";
        System.out.println(preencherComZeros(valor,11));

        System.out.println(Gerarboleto("836", "16527", "0148000", "1020749", "201907", "101"));
        
    }
}
