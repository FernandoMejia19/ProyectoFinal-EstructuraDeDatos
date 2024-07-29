package Controller;

import java.util.LinkedList;
import java.util.Queue;

import Model.Laberinto;

public class LaberintoControlador {
    private Laberinto laberinto;
    private int inicioX, inicioY, finX, finY;

    public LaberintoControlador(int ancho, int alto) {
        this.laberinto = new Laberinto(ancho, alto);
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public void setInicio(int x, int y) {
        laberinto.getCelda(x, y).setInicio(true);
        this.inicioX = x;
        this.inicioY = y;
    }

    public void setFin(int x, int y) {
        laberinto.getCelda(x, y).setFin(true);
        this.finX = x;
        this.finY = y;
    }

    public void toggleCelda(int row, int col) {
        laberinto.toggleCelda(row, col);
    }
    public boolean solveDFS() {
        laberinto.reset();  // Limpiar el laberinto antes de resolver
        boolean[][] visited = new boolean[laberinto.getAncho()][laberinto.getAlto()];
        return dfs(inicioX, inicioY, visited);
    }
    
    private boolean dfs(int x, int y, boolean[][] visited) {
        // Verificar límites del laberinto y si la celda ya fue visitada o es una pared
        if (x < 0 || y < 0 || x >= laberinto.getAncho() || y >= laberinto.getAlto() || laberinto.getCelda(x, y).getEstado() || visited[x][y]) {
            return false;
        }
    
        visited[x][y] = true;
    
        // Verificar si se ha llegado al final del laberinto
        if (x == finX && y == finY) {
            laberinto.getCelda(x, y).setParteDelCamino(true);
            return true;
        }
    
        laberinto.getCelda(x, y).setParteDelCamino(true);
    
        // Direcciones posibles: derecha, izquierda, abajo, arriba
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
    
            if (dfs(newX, newY, visited)) {
                return true;
            }
        }
    
        // Desmarcar la celda como parte del camino si no conduce a la solución
        laberinto.getCelda(x, y).setParteDelCamino(false);
        return false;
    }
    
    

    public boolean solveDFSDinamico() {
        laberinto.reset();  // Limpiar el laberinto antes de resolver
        Boolean[][] memo = new Boolean[laberinto.getAncho()][laberinto.getAlto()];
        boolean[][] visited = new boolean[laberinto.getAncho()][laberinto.getAlto()];
        return dfsDP(inicioX, inicioY, visited, memo);
    }
    
    private boolean dfsDP(int x, int y, boolean[][] visited, Boolean[][] memo) {
        // Verificar límites del laberinto y si la celda ya fue visitada o es una pared
        if (x < 0 || y < 0 || x >= laberinto.getAncho() || y >= laberinto.getAlto() || laberinto.getCelda(x, y).getEstado() || visited[x][y]) {
            return false;
        }
    
        // Usar memoización para evitar recalcular
        if (memo[x][y] != null) {
            return memo[x][y];
        }
    
        visited[x][y] = true;
    
        // Verificar si se ha llegado al final del laberinto
        if (x == finX && y == finY) {
            laberinto.getCelda(x, y).setParteDelCamino(true);
            memo[x][y] = true;
            return true;
        }
    
        laberinto.getCelda(x, y).setParteDelCamino(true);
    
        // Direcciones posibles: derecha, izquierda, abajo, arriba
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
    
            if (dfsDP(newX, newY, visited, memo)) {
                memo[x][y] = true;
                return true;
            }
        }
    
        // Desmarcar la celda como parte del camino si no conduce a la solución
        laberinto.getCelda(x, y).setParteDelCamino(false);
        visited[x][y] = false; // Opcional: si se desea desmarcar la celda como visitada
        memo[x][y] = false;
        return false;
    }
    



public boolean solveBFSDinamica() {
    laberinto.reset();  // Limpiar el laberinto antes de resolver
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited = new boolean[laberinto.getAncho()][laberinto.getAlto()];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{inicioX, inicioY});
    visited[inicioX][inicioY] = true;

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];

        if (x == finX && y == finY) {
            laberinto.getCelda(x, y).setParteDelCamino(true);
            return true; // Encontrado
        }

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newY >= 0 && newX < laberinto.getAncho() && newY < laberinto.getAlto() && 
                !visited[newX][newY] && !laberinto.getCelda(newX, newY).getEstado()) {
                visited[newX][newY] = true;
                queue.add(new int[]{newX, newY});
                laberinto.getCelda(newX, newY).setParteDelCamino(true);
            }
        }
    }
    return false; // No encontrado
}


public boolean solveBFSRecursivo() {
    laberinto.reset();
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited = new boolean[laberinto.getAncho()][laberinto.getAlto()];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{inicioX, inicioY});
    visited[inicioX][inicioY] = true;

    return bfsRecursivo(queue, directions, visited);
}

private boolean bfsRecursivo(Queue<int[]> queue, int[][] directions, boolean[][] visited) {
    if (queue.isEmpty()) {
        return false;
    }

    int[] current = queue.poll();
    int x = current[0];
    int y = current[1];

    if (x == finX && y == finY) {
        laberinto.getCelda(x, y).setParteDelCamino(true);
        return true; // Encontrado
    }

    for (int[] dir : directions) {
        int newX = x + dir[0];
        int newY = y + dir[1];

        if (newX >= 0 && newY >= 0 && newX < laberinto.getAncho() && newY < laberinto.getAlto() && 
            !visited[newX][newY] && !laberinto.getCelda(newX, newY).getEstado()) {
            visited[newX][newY] = true;
            queue.add(new int[]{newX, newY});
            laberinto.getCelda(newX, newY).setParteDelCamino(true);
        }
    }

    return bfsRecursivo(queue, directions, visited);
}

    

    public void limpiarMatriz() {
        laberinto.resetLaberinto();
    }
}
