public class teste1 {
    
    private static double retirarValor(String boxesUnidos){
        
        String stringValor = boxesUnidos.substring(4,11) + boxesUnidos.substring(12, 16);
        double doubleValor = Double.parseDouble(stringValor)/100;
        
        return doubleValor;
    }
    public static void main(String[] args) {
        String codigo = "826200000006635500410116";
        System.out.println(retirarValor(codigo));
        
    }
}
