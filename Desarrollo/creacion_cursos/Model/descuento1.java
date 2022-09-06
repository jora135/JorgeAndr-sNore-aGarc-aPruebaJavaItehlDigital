package Model;

public class descuento1 {
    private int id;

    private String nombre_des;
    private String modalidad;
    private String pais;
    private int descuento;
    private String curso;
    private String fecha_fin_promo;


    public descuento1(int id, String nombre_des, String modalidad, String pais, int descuento, String curso, String fecha_fin_promo) {
        this.id = id;
        this.nombre_des = nombre_des;
        this.modalidad = modalidad;
        this.pais = pais;
        this.descuento = descuento;
        this.curso = curso;
        this.fecha_fin_promo = fecha_fin_promo;
    }

    public descuento1() {
        this.nombre_des = "Sin nombre de descuento asignado";
        this.modalidad = "Sin modalidad asignada";
        this.pais = "Sin pais asignado";
        this.descuento = 0;
        this.curso = "Sin curso asignada";
        this.fecha_fin_promo = "Sin fecha asignada";
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_des() {
        return this.nombre_des;
    }

    public void setNombre_des(String nombre_des) {
        this.nombre_des = nombre_des;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getDescuento() {
        return this.descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFecha_fin_promo() {
        return this.fecha_fin_promo;
    }

    public void setFecha_fin_promo(String fecha_fin_promo) {
        this.fecha_fin_promo = fecha_fin_promo;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
            "&nombre_des=" + getNombre_des() +
            "&modalidad=" + getModalidad() +
            "&pais=" + getPais() +
            "&descuento=" + getDescuento() +
            "&curso=" + getCurso() +
            "&fecha_fin_promo=" + getFecha_fin_promo();
    }

}
