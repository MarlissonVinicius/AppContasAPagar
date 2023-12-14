package utils;

/**
 * CalcularDigitoDAC
 */
public class CalcularDigitoDAC {

    public static int main(String codigo){
        int acum = 0;

        for (int i = 0; i < codigo.length(); i++) {

            int mutiplicador = (i%2 == 0) ? 2:1; 
            int num = Character.getNumericValue(codigo.charAt(i));
            int valor = num*mutiplicador;

            if(valor > 9){
                valor = 1 + (valor%10);
            }
            acum+=valor; 
            
        }
        int resto = acum%10;

        if (resto == 0) {
            return resto;
        }

        int dacBoxe = 10 - resto;
        return dacBoxe;
    }

    public static String geral(String boleto){
        
        String codigoGeral = Integer.toString(main(boleto));
        
        return codigoGeral;
    }
}