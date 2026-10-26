import java.util.Scanner;
public class Examen {
    static int totalEstudiantes = 0;
    static int totalAprobados = 0;
    static int totalReprobados = 0;
    static double sumaPromediosGeneral = 0;
    static Scanner scanner = new Scanner(System.in);
    public static double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }
    public static String obtenerResultado(double promedio) {
        if (promedio >= 6.0) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }
    public static void registrarCalificaciones() {
        System.out.println("=====================================");
        System.out.println("        REGISTRAR ESTUDIANTE         ");
        System.out.println("=====================================");

        System.out.print("¿Cuantos estudiantes registrara?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= cantidad; i++) {

            System.out.println("Estudiantes" + i);

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Evaluación 1: ");
            double ev1 = scanner.nextDouble();

            System.out.print("Evaluación 2: ");
            double ev2 = scanner.nextDouble();

            System.out.print("Evaluación 3: ");
            double ev3 = scanner.nextDouble();
            scanner.nextLine();

            double promedio = calcularPromedio(ev1, ev2, ev3);
            String resultado = obtenerResultado(promedio);

            System.out.println(String.format("Promedio: %.2f", promedio));
            System.out.println("Resultado: " + resultado);

            totalEstudiantes += 1;
            sumaPromediosGeneral += promedio;

            if (resultado.equals("APROBADO")) {
                totalAprobados += 1;
            } else {
                totalReprobados += 1;
            }
        }
    }
    public static void mostrarEstadisticas() {
        System.out.println("\n=====================================");
        System.out.println("       ESTADÍSTICAS DEL GRUPO        ");
        System.out.println("=====================================");
        System.out.println("Estudiantes registrados: " + totalEstudiantes);
        System.out.println("Estudiantes aprobados: " + totalAprobados);
        System.out.println("Estudiantes reprobados: " + totalReprobados);

        double promedioGeneral = 0.00;
        if (totalEstudiantes > 0) {
            promedioGeneral = sumaPromediosGeneral / totalEstudiantes;
        }

        System.out.println(String.format("Promedio general: %.2f", promedioGeneral));
        System.out.println("=====================================");
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("=====================================");
            System.out.println("       CONTROL DE CALIFICACIONES     ");
            System.out.println("=====================================");
            System.out.println("1. Registrar calificaciones");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                registrarCalificaciones();
            } else if (opcion.equals("2")) {
                mostrarEstadisticas();
            } else if (opcion.equals("3")) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
