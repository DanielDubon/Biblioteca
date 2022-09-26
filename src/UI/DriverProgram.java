package UI;

import Controller.Administracion;
import Model.*;

import javax.print.Doc;
import java.util.Scanner;
import java.util.ArrayList;

import static Controller.Administracion.*;

/**
 * @author Daniel Dubon
 */
public class DriverProgram {

    private static boolean emenu= true;
    private static int opcion;
    private static int opciondoc;


    public static ArrayList<Documento> Documents = new ArrayList<>();
    public static ArrayList<Cliente> Clientes = new ArrayList<>();


    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        menu(emenu);
    }

    /**
     *
     * @param emenu
     */
    public static void menu(boolean emenu){

        while (emenu){
        System.out.println("Bienvenido a la biblioteca, ¿Que desea realizar?");
            System.out.println("1)Insertar Documento");
            System.out.println("2)Buscar libro por ID");
            System.out.println("3)Cantidad de libros de cierta materia");
            System.out.println("4)Prestar Documento");
            System.out.println("5)Devolver Documento");
            System.out.println("6)Cantidad de Documentos prestados a Usuario");
            System.out.println("7)Cantidad de revistas de cierta materia");
            System.out.println("8)Verificar si quedan ejemplares de cierto Documento");
            System.out.println("9)Salir");
            System.out.print("Ingrese seleccion: ");
            Scanner in = new Scanner(System.in);
            try{
                opcion = in.nextInt();

            }catch (Exception e){
                System.out.println("Ingrese un valor numerico del menu por favor");
            }

            switch (opcion){
                case 1:
                    System.out.println("¿Que tipo de documento desea ingresar?");
                    System.out.println("1)Libro");
                    System.out.println("2)Revista");
                    System.out.println("3)Articulo");
                    System.out.print("Ingrese seleccion: ");

                    try{
                    opciondoc = in.nextInt();
                    if (opciondoc == 1) {
                        int IDLIB = generarIDLIB(Documents);
                        in.nextLine();
                        System.out.println("Ingrese Titulo del libro: ");
                        String Titulo = in.nextLine();
                        System.out.println("Ingrese Autor del libro: ");
                        String Autor = in.nextLine();
                        System.out.println("Ingrese la editorial del libro: ");
                        String Editorial = in.nextLine();
                        System.out.println("Ingrese Materia del libro: ");
                        String Materia = in.nextLine();
                        System.out.println("Ingrese cuantos ejemplares de este libro se ingresaran: ");
                        int cantidaddeejemplares = in.nextInt();
                        Libro nlibro = new Libro();
                        nlibro.setId(IDLIB);
                        nlibro.setTitulo(Titulo);
                        nlibro.setAutor(Autor);
                        nlibro.setEditorial(Editorial);
                        nlibro.setMateria(Materia);
                        nlibro.setCantidadejemplares(cantidaddeejemplares);
                        nlibro.setEstado(true);
                        nlibro.setTipo("Libro");
                        Documents.add(nlibro);
                        System.out.println("¡Libro ingresado!, el ID de este libro es: "+IDLIB);


                    }else if(opciondoc == 2) {
                            int IDREV = generarIDLIB(Documents);
                            in.nextLine();
                            System.out.println("Ingrese Titulo de la Revista: ");
                            String Titulo = in.nextLine();
                            System.out.println("Ingrese Materia de la Revista: ");
                            String Materia = in.nextLine();
                            System.out.println("Ingrese cuantos ejemplares de esta Revista se ingresaran: ");
                            int cantidaddeejemplares = in.nextInt();
                            in.nextLine();
                            System.out.println("Año de la revista: ");
                            int Ano = in.nextInt();
                            in.nextLine();
                            System.out.println("Numero de la revista: ");
                            int numerorevista = in.nextInt();
                            Revista nrevista = new Revista();

                            nrevista.setId(IDREV);
                            nrevista.setTitulo(Titulo);
                            nrevista.setMateria(Materia);
                            nrevista.setCantidadejemplares(cantidaddeejemplares);
                            nrevista.setAnoderevista(Ano);
                            nrevista.setNderevista(numerorevista);
                            nrevista.setEstado(true);
                            nrevista.setTipo("Revista");
                            Documents.add(nrevista);
                            System.out.println("¡Revista ingresada!, el ID de esta revista es: "+IDREV);


                        }else if (opciondoc == 3) {
                            int IDART = generarIDLIB(Documents);
                            in.nextLine();
                            System.out.println("Ingrese Titulo del Articulo: ");
                            String Titulo = in.nextLine();
                            System.out.println("Ingrese Materia del Articulo: ");
                            String Materia = in.nextLine();
                            System.out.println("Ingrese cuantos ejemplares de este Articulo se ingresaran: ");
                            int cantidaddeejemplares = in.nextInt();
                            in.nextLine();
                            System.out.println("Arbitro de la Revista: ");
                            String arbitro = in.nextLine();

                            Articulo narticulo = new Articulo();

                            narticulo.setId(IDART);
                            narticulo.setTitulo(Titulo);
                            narticulo.setMateria(Materia);
                            narticulo.setCantidadejemplares(cantidaddeejemplares);
                            narticulo.setArbittro(arbitro);
                            narticulo.setEstado(true);
                            narticulo.setTipo("Articulo");
                            Documents.add(narticulo);
                            System.out.println("¡Articulo ingresado!, el ID de este articulo es: "+IDART);


                        }else {
                        System.out.println("No existe este tipo de documento, intente nuevamente por favor");
                    }
                    }catch(Exception e){
                        System.out.println("Error en el ingreso de datos");
                        }

                    break;
                case 2:

                    System.out.println("Ingrese el id del documento que desea buscar: ");
                    try {
                        int ID = in.nextInt();
                        Administracion.buscarporID(ID, Documents);
                    }catch (Exception e){
                        System.out.println("Error en buscar documento por ID....");
                    }


                    break;
                case 3:

                    System.out.println("Ingrese la materia del documento que desea verificar cuantos ejemplares se tiene disponibles: ");
                    try {
                        in.nextLine();
                        String materia = in.nextLine();
                        System.out.println("La cantidad de documentos de materia "+materia+" son: "+cantidadpormateria(materia, Documents));
                    }catch (Exception e){
                        System.out.println("Error en buscar cantidad de libros por materia.");
                    }

                    break;
                case 4:
                    System.out.println("----Bienvenido al sistema de prestamos----");
                    System.out.println("Ingrese su ID de usuario por favor(Si no tiene escriba un (1) por favor):");

                    try {


                        int IDUSU = in.nextInt();
                        in.nextLine();
                        if (buscarusuario(IDUSU, Clientes)) {
                            System.out.println("Ingrese el ID del documento que desea prestar.");
                            int IDPrestar = in.nextInt();
                            in.nextLine();
                            prestarlibro(IDUSU, IDPrestar, Documents, Clientes);

                        } else {
                            System.out.println("Usuario no encontrado... Registrese antes por favor.");
                            Cliente ncliente = new Cliente();
                            System.out.println("¿Cual es su nombre?");
                            String nombre = in.nextLine();
                            ncliente.setName(nombre);
                            System.out.println("¿Cual es su direccion?");
                            String direccion = in.nextLine();
                            ncliente.setDireccion(direccion);
                            ncliente.setCantprestamos(0);
                            int IDNuevo = generarIDUSU(Clientes);
                            //algoritmo para generar ID de usuario
                            ncliente.setID(IDNuevo);
                            Clientes.add(ncliente);
                            System.out.println("Registro completado, su Numero de ID es: " + IDNuevo);
                            System.out.println("¡Ahora ya puede prestar un Documento!, intentemos nuevamente por favor...");
                        }
                    }catch (Exception a){
                        System.out.println("Error en prestar un documento...");
                    }

                    break;
                case 5:

                    System.out.println("----Bienvenido al sistema de devoluciones----");
                    System.out.println("Ingrese su ID de usuario por favor:");

                    try {


                        int IDUSU = in.nextInt();

                        if(buscarusuario(IDUSU,Clientes)){
                            System.out.println("Ingrese el ID del documento que desea devolver.");
                            in.nextLine();
                            int IDPrestar = in.nextInt();
                            devolverlibro(IDUSU,IDPrestar,Documents,Clientes);
                        }else {
                            System.out.println("Usuario no encontrado, no se puede devolver un Documento... Registrese antes por favor y luego podra prestar documentos para poder devolverlos.");
                            Cliente ncliente = new Cliente();
                            System.out.println("¿Cual es su nombre?");
                            in.nextLine();
                            String nombre = in.nextLine();
                            ncliente.setName(nombre);
                            System.out.println("¿Cual es su direccion?");
                            String direccion = in.nextLine();
                            ncliente.setDireccion(direccion);
                            ncliente.setCantprestamos(0);
                            int IDNuevo = generarIDUSU(Clientes);
                            //algoritmo para generar ID de usuario
                            ncliente.setID(IDNuevo);
                            Clientes.add(ncliente);
                            System.out.println("Registro completado, su Numero de ID es: " + IDNuevo);
                            System.out.println("¡Ahora ya puede entrar al sistema de prestar un documento!, antes puede prestar un documento para luego devolverlo...");}
                    }catch(Exception e){

                    }


                    break;
                case 6:

                    try {
                        System.out.println("Ingrese el ID del usuario que desea verificar: ");
                        in.nextLine();
                       int IDUSU = in.nextInt();
                        in.nextLine();

                        if (buscarusuario(IDUSU, Clientes)){
                            verificarPrestamos(IDUSU, Clientes );
                        }else {
                            System.out.println("Usuario no encontrado...");
                        }


                    }catch (Exception e){
                        System.out.println("Error en verificar prestamos de un usuario...");

                    }


                    break;
                case 7:
                    System.out.println("Ingrese el tipo de materia de las revistas");
                    try {
                        in.nextLine();
                        String materia = in.nextLine();
                        System.out.println("La cantidad de revistas de materia "+materia+" son: "+cantidadpormateriaRevista(materia, Documents));
                    }catch (Exception e){
                        System.out.println("Error en buscar cantidad de libros por materia.");
                    }
                    break;
                case 8:
                    System.out.println("");
                    break;
                case 9:
                    System.out.println("Adios...");
                    emenu = false;
                    break;

                default:
                    System.out.println("No se ingreso un dato correcto del menu");





            }

        }





    }

}
