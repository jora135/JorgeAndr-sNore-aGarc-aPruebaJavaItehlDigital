package Model;

public class Curso1 {
    private int id;
    private String nombre;
    private int costo;
    private String descripcion;
    private int horas_duracion;
    private String dirigido_a;
    private String modalidad;
    

    public Curso1(int id, String nombre, int costo, String descripcion, int horas_duracion, String dirigido_a, String modalidad) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.horas_duracion = horas_duracion;
        this.dirigido_a = dirigido_a;
        this.modalidad = modalidad;
    }

    public Curso1() {
        this.nombre = "Sin nombre asignado";
        this.costo =  0;
        this.descripcion = "Sin descripcion asignada";
        this.horas_duracion = 0;
        this.dirigido_a = "Sin direccion asignada";
        this.modalidad = "Sin modalidad asignado";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return this.nombre;
    }

    public void setNombre1(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras_duracion() {
        return this.horas_duracion;
    }

    public void setHoras_duracion(int horas_duracion) {
        this.horas_duracion = horas_duracion;
    }

    public String getDirigido_a() {
        return this.dirigido_a;
    }

    public void setDirigido_a(String dirigido_a) {
        this.dirigido_a = dirigido_a;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }


    @Override
    public String toString() {
        return 
            "id=" + getId() +
            "&nombre=" + getNombre1() +
            "&costo=" + getCosto() +
            "&descripcion=" + getDescripcion() +
            "&horas_duracion=" + getHoras_duracion() +
            "&dirigido_a=" + getDirigido_a() +
            "&modalidad=" + getModalidad();
    }
    
}
