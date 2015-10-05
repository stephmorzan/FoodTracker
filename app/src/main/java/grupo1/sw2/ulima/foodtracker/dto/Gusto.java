package grupo1.sw2.ulima.foodtracker.dto;

/**
 * Created by stmorzan on 05/10/2015.
 */
public class Gusto {

    private long id;
    private String nombre;

    public Gusto() {
    }

    public Gusto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
