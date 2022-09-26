package Model;

public class Revista extends Documento{

    public int getNderevista() {
        return Nderevista;
    }

    public void setNderevista(int nderevista) {
        Nderevista = nderevista;
    }

    public int getAñoderevista() {
        return Añoderevista;
    }

    public void setAñoderevista(int añoderevista) {
        Añoderevista = añoderevista;
    }

    private int Nderevista;
    private int Añoderevista;
}
