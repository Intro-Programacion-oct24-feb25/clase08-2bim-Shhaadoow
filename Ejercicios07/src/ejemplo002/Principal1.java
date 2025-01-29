/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;
/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {
        
        String[] nombres = { "Jason", "Jonathan", "Kristen", "Robin", 
            "Michelle", "Emily", "Noah", "Daniel"};
        String[] apellidos = { "Lynch", "George", "Lang", "Cochran", 
            "Young", "Fletcher", "Adkins", "Harris"};
        int[][] notas = { {10, 80, 80, 95}, {40, 80, 80, 45}, 
            {80, 10, 20, 55}, {70, 30, 20, 65}, 
            {60, 50, 70, 75}, {50, 70, 30, 85},{40, 80, 40, 45}, 
            {30, 90, 50, 95}};
        
        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int[] filaNotas;
        String mensajeFinal = "";
        
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            filaNotas = notas[i];
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas, promedio_paralelo);
            tipoNotas = funcion03(filaNotas);
            String username = generarUsername(nombre, apellido);
            int[] notasMaxMin = obtenerNotasMaxMin(filaNotas);
            int notaMaxima = notasMaxMin[0];
            int notaMinima = notasMaxMin[1];
            mensajeFinal = String.format("%s%s\nUsuario: %s\nNota Máxima: %d\nNota Mínima: %d\n\n", 
                                        mensajeFinal, 
                                        presentarReporte(nombre, apellido, tipoNotas, 
                                        promedioEstudiante, numeroNotasArribaPromedio),
                                        username, notaMaxima, notaMinima);
        }
        
        CrearArchivoTexto.agregarRegistros(mensajeFinal);
    }
    
    public static String presentarReporte(String nom, String ap, String notas, 
            double prom, int numeroNotas){
        String reporte = String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Con notas: \n"
                + "%s\n"
                + "Promedio - %2f\n"
                + "Número de notas arriba del promedio: %d\n\n",
                nom, ap, notas, prom, numeroNotas);
        
        return reporte;
    }

    public static double obtenerPromedioParalelo(int[][] n){
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }
        
        promedio = (double)suma / contador;
        return promedio;
    }
    
    public static double funcion01(int[] notas){
        int suma = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        promedio = (double)suma / notas.length;
        return promedio;
    }
    
    public static int funcion02(int[] notas, double promedio){
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > promedio) {
                contador = contador + 1;
            }
        }
        
        return contador;
    }
    
    public static String funcion03(int[] notas){
        String cadena = "";
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] <= 20) {
                cadena = String.format("%s%d-%s\n", cadena, notas[i], "M");
            } else if (notas[i] <= 50) {
                cadena = String.format("%s%d-%s\n", cadena, notas[i], "MB");
            } else {
                cadena = String.format("%s%d-%s\n", cadena, notas[i], "S");
            }
        }
        
        return cadena;
    }

    // Nueva función para generar el username
    public static String generarUsername(String nombre, String apellido) {
        String primeraLetraNombre = nombre.substring(0, 1).toLowerCase();
        String apellidoLower = apellido.toLowerCase();
        return primeraLetraNombre + apellidoLower + "@utpl.edu.ec";
    }

    // Nueva función para obtener la nota más alta y más baja
    public static int[] obtenerNotasMaxMin(int[] notas) {
        int max = notas[0];
        int min = notas[0];
        
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
            if (notas[i] < min) {
                min = notas[i];
            }
        }
        
        return new int[]{max, min};
    }
} 
// Necesito que crees las funciones exta que necesites para que se present en el informe final username: y que sea la primera letra luego su apellido y 
// luego @utpl.edu.ec, tambien que las notas de cada uno, saque la nota mas alta y mas baja
