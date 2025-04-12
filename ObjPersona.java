public class ObjPersona {

    private String Nombre;
    private int Cedula;
    private int Edad;
    private double Auxilio;
    private String esDesplazado;
    private int Estrato;

    public ObjPersona(){

    }

    public ObjPersona(String nombre, int cedula, int edad, double auxilio, String esdesplazado, int estrato){

        Nombre = nombre;
        Cedula = cedula;
        Edad = edad;
        Auxilio = auxilio;
        esDesplazado = esdesplazado;
        Estrato = estrato;

    }

    public ObjPersona(ObjPersona o){

        Nombre = o.Nombre;
        Cedula = o.Cedula;
        Edad = o.Edad;
        Auxilio = o.Auxilio;
        esDesplazado = o.esDesplazado;
        Estrato = o.Estrato;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getAuxilio() {
        return Auxilio;
    }

    public void setAuxilio(double auxilio) {
        Auxilio = auxilio;
    }

    public String getEsDesplazado() {
        return esDesplazado;
    }

    public void setEsDesplazado(String esDesplazado) {
        this.esDesplazado = esDesplazado;
    }

    public int getEstrato() {
        return Estrato;
    }

    public void setEstrato(int estrato) {
        Estrato = estrato;
    }

}
