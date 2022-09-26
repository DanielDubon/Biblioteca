package Model;

public class Revista extends Documento{

    public int getNderevista() {
        return Nderevista;
    }

    public void setNderevista(int nderevista) {
        Nderevista = nderevista;
    }

    public int getAnoderevista() {
        return Anoderevista;
    }

    public void setAnoderevista(int anoderevista) {
        Anoderevista = anoderevista;
    }

    private int Nderevista;
    private int Anoderevista;
}
