package metodocesar;
/**
 *@version 02/03/2017
 * @author julian arias
 * @see https://github.com/kratos01/cifrado-de-cesar-.git
 */
import java.util.Scanner;

public class MetodoCesar {

    static Scanner buffer = new Scanner(System.in);

    static String frasePlano;
    static String fraseCifrada = "";//(Es necesario inicializar una cadena vacia)

    static String diccioMinus = "abcdefghijklmnopqrstuvwxyz, ; ";
    static String diccioMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ, ; ";
    static int clave = 0;

    
    //Funcion biunivoca E_n(x) = x + n mod {27}.
    public static void cifrar() {
        for (int x = 0; x < frasePlano.length(); x++) {
            for (int j = 0; j < diccioMinus.length(); j++) {
                if (frasePlano.charAt(x) == diccioMinus.charAt(j)) {
                    if (j + clave >= diccioMinus.length()) {
                        fraseCifrada += diccioMinus.charAt((j + clave) % diccioMinus.length());
                    } else {
                        fraseCifrada += diccioMinus.charAt(j + clave);
                    }
                } else if (frasePlano.charAt(x) == diccioMayus.charAt(j)) {
                    if (j + clave >= diccioMayus.length()) {
                        fraseCifrada += diccioMayus.charAt((j + clave) % diccioMayus.length());
                    } else {
                        fraseCifrada += diccioMayus.charAt(j + clave);
                    }
                }
            }
        }
    }

    //E_n(x) = x - n mod {27}.    
    public static void descifrar() {
        for (int x = 0; x <= frasePlano.length(); x++) {
            for (int j = 0; j <= diccioMinus.length(); j++) {
                if (frasePlano.charAt(x) == diccioMinus.charAt(j)) {
                    if (j + clave <= diccioMinus.length()) {
                        fraseCifrada += diccioMinus.charAt((j - clave) % diccioMinus.length());
                    } else {
                        fraseCifrada += diccioMinus.charAt(j - clave);
                    }
                } else if (frasePlano.charAt(x) == diccioMayus.charAt(j)) {
                    if (j + clave <= diccioMayus.length()) {
                        fraseCifrada += diccioMayus.charAt((j - clave) % diccioMayus.length());
                    } else {
                        fraseCifrada += diccioMayus.charAt(j - clave);
                    }
                }
            }
        }
    }

    public static void tostring() {
        System.out.println("Desplazamiento: " + clave);
        System.out.println("String plano: " + frasePlano);
        System.out.println("String cifrado: " + fraseCifrada);
    }

    public static void main(String[] args) {

        System.err.println("Digite la frase a cifrar-->>>");
        frasePlano = buffer.next();
        System.err.println("Digite un valor para la clave-->>>");
        clave = buffer.nextInt();

        cifrar();//Cifrado cesar
        tostring();//Impresion de los resultados...
        //descifrar();
        //tostring();

    }
}
