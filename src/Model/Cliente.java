package Model;

import java.util.ArrayList;

public class Cliente {
    private int ID;
    private String name;
    private String direccion;
    private int cantprestamos;

    private ArrayList<String> TipoLibrosprestados = new ArrayList<>();
    private ArrayList<Integer>  IDdelibrosprestados = new ArrayList<>();

    public ArrayList<Integer> getIDdelibrosprestados() {
        return IDdelibrosprestados;
    }

    public void setIDdelibrosprestados(ArrayList<Integer> IDdelibrosprestados) {
        this.IDdelibrosprestados = IDdelibrosprestados;
    }

    public Cliente(){
       // TipoLibrosprestados.add("a");

    }
    public ArrayList<String> getTipoLibrosprestados() {
        return TipoLibrosprestados;
    }

    public void setTipoLibrosprestados(ArrayList<String> tipoLibrosprestados) {
        TipoLibrosprestados = tipoLibrosprestados;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantprestamos() {
        return cantprestamos;
    }

    public void setCantprestamos(int cantprestamos) {
        this.cantprestamos = cantprestamos;
    }





}
