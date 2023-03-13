import java.util.Arrays;

/**
 *
 * @author administrador
 */
public class Comercial {

    private String nombre;
    private int[] unidadesVendidas;
    private int sueldfijo;
    private static String marcas[] = {"Nike", "Adidas", "Converse"};
   

    public Comercial(String nombre) {
        this.nombre = nombre;
        this.unidadesVendidas=new int[marcas.length];
        this.sueldfijo=sueldfijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUnidadesVendidas(int numVentas, int numMarca) {
        this.unidadesVendidas[numMarca] += numVentas;
    }
    
    public int getUnidadesVendidas(int numMarca){
        return unidadesVendidas[numMarca];
    }




    public static int buscarMarca(String marca) {
        for (int i = 0; i < marcas.length; i++) {
            if (marcas[i].equalsIgnoreCase(marca)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Comercial [nombre=" + nombre + ", unidadesVendidas=" + Arrays.toString(unidadesVendidas)
                + ", sueldfijo=" + sueldfijo + "]";
    }

    public int getUnidadesVendidas() {
        return 0;
    }

    public int getVentasTotales() {
        return 0;
    }

    
}
  

    

 
