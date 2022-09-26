package Controller;

import Model.Cliente;
import Model.Documento;
import Model.Revista;

import java.util.ArrayList;

public class Administracion {
    /**
     *
     * @param ID
     * @param _Documento
     */

    public static void buscarporID(int ID, ArrayList<Documento> _Documento){
        boolean encontrado = false;
        for (Documento documento: _Documento){
            if (documento.getId() == ID){
                System.out.println("¡Documento encontrado! ");
                System.out.println("El Titulo es "+documento.getTitulo());
                System.out.println("La cantidad de ejemplares disponibles son: "+ documento.getCantidadejemplares());
                encontrado = true;
            }

        }
        if (!encontrado){
            System.out.println("Libro no encontrado... ");
        }

    }

    /**
     *
     * @param materia
     * @param _Documento
     * @return contador retorna la cantidad de libros por materia
     */
    public static int cantidadpormateria(String materia, ArrayList<Documento> _Documento){
        int contador = 0;
        for (Documento documento: _Documento){

            if (materia.equalsIgnoreCase(documento.getMateria())) {
            contador = contador + documento.getCantidadejemplares();

            }

        }
        return contador;
    }

    /**
     *
     * @param materia
     * @param _Documento
     * @return retorna la cantidad de revistas por materia
     */
    public static int cantidadpormateriaRevista(String materia, ArrayList<Documento> _Documento){
        int contador = 0;
        for (Documento documento: _Documento){
            if(documento.getTipo().equalsIgnoreCase("Revista")){
            if (materia.equalsIgnoreCase(documento.getMateria())) {
                contador = contador + documento.getCantidadejemplares();
            }
            }

        }
        return contador;
    }

    /**
     *
     * @param ID
     * @param _Cliente
     * @return retorna el valor si fue encontrado o no un usuario
     */
    public static boolean buscarusuario(int ID, ArrayList<Cliente> _Cliente){
        boolean encontrado = false;
        for (Cliente cliente: _Cliente){
            System.out.println("//Usuario de cliente en loop buscar usuario "+cliente.getID());
            if(cliente.getID() == ID){
                System.out.println("Usuario encontrado, Bienvenido "+ cliente.getName());
                encontrado = true;
            }
        }
    return encontrado;
    }

    /**
     *
     * @param IDUSU
     * @param IDPrestar
     * @param _Documento
     * @param _cliente
     */
    public static void prestarlibro(int IDUSU,int IDPrestar, ArrayList<Documento> _Documento,ArrayList<Cliente> _cliente){
        boolean encontrado = false;
        for (Documento documento: _Documento){
            if (documento.getId() == IDPrestar) {
                System.out.println("¡Documento encontrado! ");
                System.out.println("El Titulo es " + documento.getTitulo());
                System.out.println("La cantidad de ejemplares disponibles son: " + documento.getCantidadejemplares());

                encontrado = true;


            if(encontrado) {
                if (documento.getEstado()) {

                    for (Cliente cliente : _cliente) {
                        if (cliente.getID() == IDUSU) {
                            if (!(cliente.getCantprestamos() == 5)) {

                                ArrayList<String> tipodedocs = (ArrayList<String>) cliente.getTipoLibrosprestados().clone();
                                tipodedocs.add(documento.getTipo());
                                cliente.setTipoLibrosprestados(tipodedocs);

                                ArrayList<Integer> IDdelibrosprestadosporusu = (ArrayList<Integer>) cliente.getIDdelibrosprestados().clone();
                                IDdelibrosprestadosporusu.add(documento.getId());

                                cliente.setIDdelibrosprestados(IDdelibrosprestadosporusu);


                                System.out.println("¡Documento prestado correctamente, cuidelo!");
                                documento.setCantidadejemplares(documento.getCantidadejemplares() - 1);

                                if (documento.getCantidadejemplares() == 0) {
                                    documento.setEstado(false);
                                }
                                cliente.setCantprestamos(cliente.getCantprestamos() + 1);
                            } else {
                                System.out.println("No es posible prestar el libro, ya tiene muchos prestados el maximo es 5...");
                            }

                        }
                    }

                } else {
                    System.out.println("Lastimosamente ya no hay ejemplares de este Libro disponibles...");
                }
            }
            }

        }
        if (!encontrado){
            System.out.println("Documento no encontrado... ");
        }


    }

    /**
     *
     * @param IDUSU
     * @param IDPrestar
     * @param _Documento
     * @param _cliente
     */
    public static void devolverlibro(int IDUSU,int IDPrestar, ArrayList<Documento> _Documento,ArrayList<Cliente> _cliente){
        boolean encontrado = false;

        for (Documento documento: _Documento){
            if (documento.getId() == IDPrestar){
                System.out.println("¡Documento encontrado! ");
                System.out.println("El Titulo es "+documento.getTitulo());


                encontrado = true;




            if(encontrado) {

                for (Cliente cliente : _cliente) {

                    if (cliente.getCantprestamos() != 0) {


                    if (cliente.getID() == IDUSU) {

                        ArrayList<Integer> IDdelibrosprestadosporusu = (ArrayList<Integer>) cliente.getIDdelibrosprestados().clone();
                        int iddevuelto = documento.getId();




                        for (Integer Ids: IDdelibrosprestadosporusu){
                            System.out.println(Ids);



                            if (iddevuelto == Ids){
                                IDdelibrosprestadosporusu.remove(Integer.valueOf(iddevuelto));
                                cliente.setIDdelibrosprestados(IDdelibrosprestadosporusu);

                            String tipodedoc = documento.getTipo();
                            ArrayList<String> tipodedocs = (ArrayList<String>) cliente.getTipoLibrosprestados().clone();
                            tipodedocs.remove(tipodedoc);
                            cliente.setTipoLibrosprestados(tipodedocs);
                            cliente.setCantprestamos(cliente.getCantprestamos() - 1);
                            System.out.println("¡Documento devuelto correctamente, gracias esperamos que lo haya disfrutado!");

                            documento.setCantidadejemplares(documento.getCantidadejemplares() + 1);
                            System.out.println("La cantidad de ejemplares actual disponibles son: " + documento.getCantidadejemplares());
                            documento.setEstado(true);
                        } else {
                            System.out.println("Documento no posible de devolver, usted no tiene ningun libro prestado...");
                        }
                            }

                        }
                    }else {System.out.println("Usted no tiene este documento prestado...");}

                    }
                }

            }
            }


        if (!encontrado){
            System.out.println("Documento no encontrado... ");
        }


    }

    /**
     *
     * @param _cliente
     * @return retorna el ID del usuario nuevo
     */
    public static int generarIDUSU(ArrayList<Cliente> _cliente){
        int IDUSU=101;
        for (Cliente cliente: _cliente){
            IDUSU = IDUSU+1;
            System.out.println("verificando loop generador de ID");
        }

        return IDUSU;
    }

    /**
     *
     * @param _documento
     * @return retorna el ID del documento nuevo
     */
    public static int generarIDLIB(ArrayList<Documento> _documento){
        int IDLIB=10001;
        for (Documento documento: _documento){
            IDLIB = IDLIB+1;

        }

        return IDLIB;
    }

    /**
     *
     * @param IDUSU
     * @param _cliente
     */
    public static void verificarPrestamos(int IDUSU, ArrayList<Cliente> _cliente){
        int libros =0,revistas =0,articulos=0;
        for (Cliente cliente: _cliente){
                if (IDUSU == cliente.getID()) {
                    System.out.println("//verificando cantidad de prestamos "+cliente.getCantprestamos());
                    if (cliente.getCantprestamos() > 0) {
                        ArrayList<String> tipodedocs = (ArrayList<String>) cliente.getTipoLibrosprestados().clone();
                        for (String tipdocs: tipodedocs){
                       if (tipdocs.equals("Libro")){
                           libros = libros +1;
                       }else if(tipdocs.equals("Revista")){
                            revistas = revistas +1;
                        }else if(tipdocs.equals("Articulo")){
                           articulos = articulos +1;
                       }
                        }
                       System.out.println("El cliente tiene los siguietes tipos de documentos prestados, de tipo Libro: "+libros+" de tipo Revista: "+revistas+" de tipo Articulo: "+articulos);




                    }

                }

        }

    }

}
