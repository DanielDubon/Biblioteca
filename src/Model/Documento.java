package Model;





public class Documento {

    private int id;
    private String Titulo;
    private String Autor;
    private String Editorial;
    private String Materia;
    private int cantidadejemplares;
    private boolean estado;

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public int getCantidadejemplares() {
        return cantidadejemplares;
    }

    public void setCantidadejemplares(int cantidadejemplares) {
        this.cantidadejemplares = cantidadejemplares;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {

        return "Titulo de documento: " + getTitulo();
    }
}
