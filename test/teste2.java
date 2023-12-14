public class teste2 {

    public static int dac(String codigo){
        int acum = 0;

        for (int i = 0; i < codigo.length(); i++) {

            int mutiplicador = (i%2 == 0) ? 2:1; 
            int num = Character.getNumericValue(codigo.charAt(i));
            int valor = num*mutiplicador;
            System.out.print(num+"*"+mutiplicador+"=");
            if(valor > 9){
                valor = 1 + (valor%10);
            }
            System.out.println(valor);
            acum+=valor; 
            
        }
        int resto = acum%10;

        if (resto == 0) {
            return resto;
        }

        int dacBoxe = 10 - resto;
        return dacBoxe;
    }

    public static void main(String[] args) {
        System.out.println(dac("10207492019"));
    }
}
