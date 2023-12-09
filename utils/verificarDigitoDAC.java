package utils;



public class verificarDigitoDAC {

    private static int lastChar(String codigo){
        int ultimoDigito = Character.getNumericValue(codigo.charAt(codigo.length()-1));
        return ultimoDigito;
    }

    private static boolean isNumeric(String texto){

        try {
            Double.parseDouble(texto);
            return true;
          } catch (NumberFormatException e) {
            return false;
          }

    }

    private static int calcularDigitoBoxe(String codigo){
        int acum = 0;

        for (int i = 0; i < codigo.length()-1; i++) {

            int mutiplicador = (i%2 == 0) ? 2:1; 
            int num = Character.getNumericValue(codigo.charAt(i));
            int valor = num*mutiplicador;

            if(valor > 9){
                valor = 1 + (valor%10);
            }
            acum+=valor; 
            
        }
        
        int dacBoxe = 10 - (acum%10);
        
        return dacBoxe;
    }

    public static String boxe(String stringBoxe) { 
        if(stringBoxe.length() == 12){

            if (isNumeric(stringBoxe)) {

                if (calcularDigitoBoxe(stringBoxe) == lastChar(stringBoxe)) {
                    return "valido"; 
                }
                return "dac Errado";           
                
            }
            return "nao Numerico";
        }
        return "menor";
        
        
    }

    public static void geral(){

    }
}