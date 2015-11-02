package grupo1.sw2.ulima.foodtracker.model;

/**
 * Created by EQ on 01/11/2015.
 */
public class RankingResponse {

    private String nombre;
    private String tipo;
    private float km;
    private float puntaje;

    public RankingResponse() {
    }

    public RankingResponse(String nombre, String tipo, float km, float puntaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.km = km;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }
}

