package Model;

public class Laberinto {
    private Celda[][] celdas;
    private int ancho;
    private int alto;

    public Laberinto(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        celdas = new Celda[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Celda getCelda(int row, int col) {
        return celdas[row][col];
    }

    public void toggleCelda(int row, int col) {
        celdas[row][col].toggleEstado();
    }

    public void resetLaberinto() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                celdas[i][j].setParteDelCamino(false);
                celdas[i][j].setFin(false);
                celdas[i][j].setInicio(false);
                celdas[i][j].setEstado(false);
                if (!celdas[i][j].getEstado() && !celdas[i][j].isInicio() && !celdas[i][j].isFin()) {
                    celdas[i][j].setEstado(false);
                }
            }
        }
    }
    public void reset() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                celdas[i][j].setParteDelCamino(false);
                if (!celdas[i][j].getEstado() && !celdas[i][j].isInicio() && !celdas[i][j].isFin()) {
                    celdas[i][j].setEstado(false);
                }
            }
        }
    }
}
