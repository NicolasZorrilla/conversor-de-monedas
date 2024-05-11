import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msjBienvenida = """
                *****************************************
                ¡Sea bienvenido/a al conversor de moneda!
                *****************************************
                """;
        String menu = """
                1) Dólar americano => Peso argentino
                2) Peso argentino => Dólar americano
                3) Dólar americano => Real brasileño
                4) Real brasileño => Dólar americano
                5) Dólar americano => Peso mexicano
                6) Peso mexicano => Dólar americano
                0) Salir
                """;
        int opcion = 1;
        ConsultaApi consulta = new ConsultaApi();

        System.out.println(msjBienvenida);
        while (opcion != 0) {
            System.out.println(menu);
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(sc.next());
                switch (opcion) {
                    case 1: //usd to ars
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        int cantidad = Integer.parseInt(sc.next());
                        Conversion conversion = consulta.convertir("USD");
                        double moneda = conversion.conversion_rates().get("ARS");
                        double total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " USD corresponde al valor final de $" + (total) + " ARS\n");
                        break;
                    case 2: //ars to usd
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        cantidad = Integer.parseInt(sc.next());
                        conversion = consulta.convertir("ARS");
                        moneda = conversion.conversion_rates().get("USD");
                        total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " ARS corresponde al valor final de $" + (total) + " USD\n");
                        break;
                    case 3: //usd to brl
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        cantidad = Integer.parseInt(sc.next());
                        conversion = consulta.convertir("USD");
                        moneda = conversion.conversion_rates().get("BRL");
                        total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " USD corresponde al valor final de $" + (total) + " BRL\n");
                        break;
                    case 4: //brl to usd
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        cantidad = Integer.parseInt(sc.next());
                        conversion = consulta.convertir("BRL");
                        moneda = conversion.conversion_rates().get("USD");
                        total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " BRL corresponde al valor final de $" + (total) + " USD\n");
                        break;
                    case 5: //usd to mxn
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        cantidad = Integer.parseInt(sc.next());
                        conversion = consulta.convertir("USD");
                        moneda = conversion.conversion_rates().get("MXN");
                        total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " USD corresponde al valor final de $" + (total) + " MXN\n");
                        break;
                    case 6: //mxn to usd
                        System.out.print("\nIngresa la cantidad que desea convertir: ");
                        cantidad = Integer.parseInt(sc.next());
                        conversion = consulta.convertir("MXN");
                        moneda = conversion.conversion_rates().get("USD");
                        total = cantidad * moneda;
                        System.out.println("El valor $" + cantidad +
                                " MXN corresponde al valor final de $" + (total) + " USD\n");
                        break;
                    case 0:
                        opcion = 0;
                        System.out.println("La aplicación ha finalizado");
                        break;
                    default:
                        System.out.println("""
                                *****************************************
                                     La opción ingresada es invalida
                                *****************************************
                                """);
                }//switch
            } catch (NumberFormatException e) {
                System.out.println("""
                                *****************************************
                                        Error al ingresar el valor
                                *****************************************
                                """);
            }//try-catch
        }//while
    }//main
}
