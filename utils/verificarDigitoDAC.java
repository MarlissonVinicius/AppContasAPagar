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

    public static String boxe(String stringBoxe) { 
        if(stringBoxe.length() == 12){

            if (isNumeric(stringBoxe)) {

                if (CalcularDigitoDAC.main(stringBoxe) == lastChar(stringBoxe)) {
                    return "valido"; 
                }
                return "dac Errado";           
                
            }
            return "nao Numerico";
        }
        return "menor"; 
        
    }
}