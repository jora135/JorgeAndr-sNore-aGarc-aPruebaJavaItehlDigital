package Model;

public class modalidad1 {
    private int id;

    private String nombre_mod;
    private String descripcion_mod;

    public modalidad1(int id, String nombre_mod, String descripcion_mod) {
        this.id = id;
        this.nombre_mod = nombre_mod;
        this.descripcion_mod = descripcion_mod;
    }

    public modalidad1() {
        this.nombre_mod = "Sin nombre asignado";
        this.descripcion_mod = "Sin descripcion asignada";
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_mod() {
        return this.nombre_mod;
    }

    public void setNombre_mod(String nombre_mod) {
        this.nombre_mod = nombre_mod;
    }

    public String getDescripcion_mod() {
        return this.descripcion_mod;
    }

    public void setDescripcion_mod(String descripcion_mod) {
        this.descripcion_mod = descripcion_mod;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
            "&nombre_mod=" + getNombre_mod() +
            "&descripcion_mod=" + getDescripcion_mod();
    }


}
