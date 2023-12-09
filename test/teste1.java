public class teste1 {
    
    private static boolean calcularDigitoBoxe(String codigo){
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
        int ultimoDigito = Character.getNumericValue(codigo.charAt(codigo.length()-1));

        System.out.println(ultimoDigito);
        int dacBoxe = 10 - (acum%10);
        System.out.println(dacBoxe);
        
        return dacBoxe == ultimoDigito;
    }

    public static void main(String[] args) {
        String codigo = "012300678963";
        System.out.println(calcularDigitoBoxe(codigo));
        
    }
}
