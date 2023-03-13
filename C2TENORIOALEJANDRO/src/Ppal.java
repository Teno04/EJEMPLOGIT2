import java.util.*;

/**
 *
 * @author administrador
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre, marca, tipo;
        char otroComercial;
        int sueldfijo = 0, numComerciales = 0, numVentas, numMarca = 0, empleVenta = 0, ventasMínimas, aumento, sueldoaum=0;
        Scanner sc = new Scanner(System.in);
        Comercial comerciales[] = new Comercial[8];

        do {
            otroComercial = 'S';
            System.out.print("Introduce nombre del comercial: ");
            nombre = sc.nextLine();
            System.out.println("Introduce el tipo de empleado por su sueldo: F (FIJO) o C(COMISION)");
            tipo = sc.nextLine();
            if (tipo.equalsIgnoreCase("C")) {
                comerciales[numComerciales] = new comision(nombre);
                numComerciales++;

            } else if (tipo.equalsIgnoreCase("F")) {
                System.out.println("Introduzca su sueldo fijo");
                sueldfijo = sc.nextInt();
                sc.nextLine();
                System.out.println("Anote el aumento que quiere realizar a los empleados con sueldo fijo");
                aumento = sc.nextInt();
                sueldoaum=sueldfijo+((sueldfijo*aumento)/100);
                sc.nextLine();
                comerciales[numComerciales] = new fijo(nombre, sueldfijo);
                numComerciales++;
            }
            if (numComerciales >= 2 && numComerciales <= 7) {
                System.out.print("¿Otro comercial? (S para otro) --> ");
                otroComercial = sc.nextLine().charAt(0);
            }
        } while (Character.toUpperCase(otroComercial) == 'S' && numComerciales <= 7);

        do {
            do {
                System.out.print("\nIntroduce nombre del comercial de la venta: ");
                nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("FIN")) {
                    break;
                } else {
                    empleVenta = buscarComercial(comerciales, numComerciales, nombre);
                }
            } while (empleVenta == -1);

            if (nombre.equalsIgnoreCase("FIN")) {
                break;
            }

            do {
                System.out.print("Introduce marca: ");
                marca = sc.nextLine();
                numMarca = Comercial.buscarMarca(marca);
            } while (numMarca == -1);

            do {
                System.out.print("Introduce número de ventas: ");
                numVentas = sc.nextInt();
            } while (numVentas <= 0);
            for (int i = 0; i < numComerciales; i++) {

            }
            comerciales[empleVenta].setUnidadesVendidas(numVentas, numMarca);
            for (int i = 0; i < numComerciales; i++) {
                System.out.println(comerciales[i].toString());
            }
            System.out.println("Introduzca la marca de la que quiera saber que empleado a vendido mas unidades");





        } while (!nombre.equalsIgnoreCase("FIN"));

        for (int i = 0; i < numComerciales; i++) {
            System.out.println(comerciales[i].toString());
        }
    }

    public static int buscarComercial(Comercial comerciales[], int numComerciales, String nombre) {
        for (int i = 0; i < numComerciales; i++) {
            if (nombre.equals(comerciales[i].getNombre())) {
                return i;
            }
        }
        return -1;
    }

    public static void burbuja(Comercial comerciales[], int numComerciales) {
        int i, j;
        Comercial aux;
        for (i = 0; i < numComerciales - 1; i++) {
            for (j = 0; j < numComerciales - i - 1; j++) {
                if (comerciales[j + 1].getUnidadesVendidas() > comerciales[j].getUnidadesVendidas()) {
                    aux = comerciales[j + 1];
                    comerciales[j + 1] = comerciales[j];
                    comerciales[j] = aux;
                }
            }
        }
    }
   /*public static boolean unidadesVendidas( Comercial comerciales[], int numComerciales){
    for(int i=0;i<numComerciales;i++){
        for(int j=0;i<numComerciales;j++){
        if(comerciales[j].getVentasTotales() > comerciales[j+1].getVentasTotales()){
            return i;
        }
    }
        return false;
    }*/

}
