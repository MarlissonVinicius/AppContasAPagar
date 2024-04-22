package utils;



public class GerarBoleto {

    private static String preencherComZeros(String valorIncompleto, int comprimento){
        int tamValor = comprimento-valorIncompleto.length(); //quantidade de casas que o valor ocupa

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

    public static String main(String codigo, String valorFatura, String identEmpresa, String uniConsumidora, String data, String sequencial) {
        
        
        String boletoIncompleto = (codigo+
                                    preencherComZeros(valorFatura, 11)+
                                    preencherComZeros(identEmpresa, 7)+
                                    preencherComZeros(uniConsumidora, 7)+
                                    data+
                                    "9"+ //digito separador
                                    preencherComZeros(sequencial, 7)+
                                    "9"); //digito separador
       
        String digito = CalcularDigitoDAC.geral(boletoIncompleto);
        
        boletoIncompleto = (boletoIncompleto.substring(0,3)+digito+boletoIncompleto.substring(3));

        return formatarBoleto(boletoIncompleto);                           
    }
    
}