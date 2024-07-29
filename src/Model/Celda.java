package Model;
public class Celda {
    private boolean estado;  // Indica si la celda es un obstáculo
    private boolean inicio;
    private boolean fin;
    private boolean parteDelCamino;  // Indica si la celda es parte del camino encontrado

    public Celda() {
        this.estado = false;
        this.inicio = false;
        this.fin = false;
        this.parteDelCamino = false;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void toggleEstado() {
        this.estado = !this.estado;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public boolean isParteDelCamino() {
        return parteDelCamino;
    }

    public void setParteDelCamino(boolean parteDelCamino) {
        this.parteDelCamino = parteDelCamino;
    }
}
