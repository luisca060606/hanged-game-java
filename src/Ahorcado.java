import java.util.Scanner;

class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String palabra_secreta = "services";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabra_secreta.length()];

        // System.out.print(" | ");
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';     
            // System.out.print(letrasAdivinadas[i] + "  ");       
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabra_secreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;
            for (int i = 0; i < palabra_secreta.length(); i++) {
                if (palabra_secreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;                    
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto!!!, te quedan: " + (intentosMaximos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabra_secreta)) {
                palabraAdivinada = true;
                System.out.println("Felicitaciones adivinaste la palabra secreta: " + palabra_secreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Perdiste :(");                        
        }
    }
}
