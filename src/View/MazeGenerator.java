package View;

import javax.swing.*;

import Controller.LaberintoControlador;
import Model.Celda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MazeGenerator extends Frame {
    private TextField widthField;
    private TextField heightField;
    private Panel gridPanel;
    private Button generateButton;
    private Button bfsButton;
    private Button dfsButton;
    private Button recursivaButton;
    private Button dinamicaButton;
    private Button limpiarButton;
    private Button generarNuevoButton;
    private LaberintoControlador controlador;
    private boolean settingStart = false;
    private boolean settingEnd = false;
    private Color colorPrin=new Color(22,23,28);
    private Color colorSec=new Color(42,42,50);
    private Color colorTer=new Color(203,174,116);
    private Color colorBtnAct=new Color(250,226,66);
    private Color colorBtnDesc=new Color(183,174,138);
    private Color camino=new Color(244,221,109);
    private Color fondo=new Color(145,200,241);
    private Color fin=new Color(254,64,64);
    private Font tipografiaTitle =new Font("Poppins", Font.BOLD, 40);
    private Frame secondV=new Frame();
    private Panel subPrin;
    private boolean dinamic=false;
    private Label data=new Label();
    public MazeGenerator() {
        //Menu principal
        setTitle("Generador de Laberinto");
        setBounds(500, 250, 500, 300);
       
        setLayout(new BorderLayout());
        Panel panelPrincipal=new Panel();
        panelPrincipal.setBackground(colorPrin);
        
        subPrin=new Panel();
        subPrin.setBounds(150, 120, 175, 85);
        subPrin.setBackground(colorSec);
        subPrin.setLayout(null);
        Label lblTitle = new Label("LABERINTO");
        lblTitle.setFont(tipografiaTitle);
        lblTitle.setForeground(colorBtnAct);
        Label lblSubTitle = new Label("PROYECTO FINAL");
        lblSubTitle.setForeground(Color.WHITE);
        add(panelPrincipal);
        widthField = new TextField("5");
        heightField = new TextField("6");
        generateButton = new Button("Generar");
        panelPrincipal.setLayout(null);
        panelPrincipal.setSize(500, 300);
        lblSubTitle.setBounds(190, 60, 100, 20);
        lblTitle.setBounds(130, 20, 240, 40);
        panelPrincipal.add(lblTitle);
        panelPrincipal.add(lblSubTitle);
        Label lblColumnas = new Label("Numero de Columnas");
        Label lblFilas = new Label("Numero de Filas");
        lblColumnas.setForeground(Color.WHITE);
        lblFilas.setForeground(Color.WHITE);
        lblColumnas.setBounds(10, 5, 120, 25);
        lblFilas.setBounds(10, 30, 100, 25);
        heightField.setBounds(150, 8, 20, 20);
        widthField.setBounds(150, 33, 20, 20);
        subPrin.add(widthField);
        subPrin.add(lblFilas);
        subPrin.add(heightField);
        subPrin.add(lblColumnas);
        generateButton.setBounds(50, 55, 75, 25);
        generateButton.setBackground(colorBtnAct);
        generateButton.setForeground(colorPrin);
        subPrin.add(generateButton);
        panelPrincipal.add(subPrin);
        

        //ventana Secundaria
        secondV.setTitle("Generador de Laberinto");
        secondV.setBounds(400, 150, 800, 500);
        
        secondV.setBackground(colorPrin);
        Panel butonPanels=new Panel();
        butonPanels.setBounds(600, 50, 175, 200);
        butonPanels.setBackground(colorSec);
        butonPanels.setLayout(null);
        Panel secondPrin=new Panel();
        secondPrin.setSize(800,500);
        secondPrin.setLayout(null);
        Panel controlPanel = new Panel();
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.setBounds(5, 85, 165, 20);
        bfsButton = new Button("Resolver BFS");
        dfsButton = new Button("Resolver DFS");
        controlPanel.add(bfsButton);
        controlPanel.add(dfsButton);
        Panel codePanel = new Panel();
        codePanel.setLayout(new GridLayout(1, 2));
        codePanel.setBounds(5, 60, 165, 20);
        recursivaButton = new Button(" Recursiva");
        dinamicaButton = new Button(" Dinámica");
        codePanel.add(recursivaButton);
        codePanel.add(dinamicaButton);
        limpiarButton = new Button("Limpiar Matriz");
        limpiarButton.setBounds(5, 130, 165, 20);
        generarNuevoButton = new Button("Generar Nueva Matriz");
        generarNuevoButton.setBounds(5, 155, 165, 20);
        Panel startPanel = new Panel();
        startPanel.setLayout(new GridLayout(1, 2));
        startPanel.setBounds(5, 10, 165, 20);
        Button setStartButton = new Button("  Inicio");
        Button setEndButton = new Button(" Fin");
        startPanel.add(setStartButton);
        startPanel.add(setEndButton);

        gridPanel = new Panel();
        gridPanel.setBounds(50, 50, 500, 300);
        secondPrin.add(gridPanel);
        controlador = new LaberintoControlador(5, 5);
        generateGrid(5, 5);
        secondPrin.add(gridPanel);
        butonPanels.add(controlPanel);
        butonPanels.add(startPanel);
        butonPanels.add(limpiarButton);
        butonPanels.add(generarNuevoButton);
        butonPanels.add(codePanel);
        secondPrin.add(butonPanels);
        secondV.add(secondPrin);

        secondPrin.add(data);
        data.setBounds(50, 370, 160, 25);
        data.setBackground(colorSec);
        data.setForeground(Color.white);


        bfsButton.setBackground(camino);
        dfsButton.setBackground(camino);
        recursivaButton.setBackground(camino);
        dinamicaButton.setBackground(colorTer);
        limpiarButton.setBackground(camino);
        generarNuevoButton.setBackground(camino);
        
        addWindowListener(new WindowAdapter () {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
        });
        secondV.addWindowListener(new WindowAdapter () {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
        });
        dinamicaButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dinamicaButton.setBackground(colorBtnAct);
                recursivaButton.setBackground(colorBtnDesc);
                dinamic=true;
                
            }
        });
        recursivaButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dinamicaButton.setBackground(colorBtnDesc);
                recursivaButton.setBackground(colorBtnAct);
                dinamic=false;
                
            }
        });

        generateButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int ancho = Integer.parseInt(widthField.getText());
                int alto = Integer.parseInt(heightField.getText());
                controlador = new LaberintoControlador(ancho, alto);
                generateGrid(ancho, alto);
                secondV.setVisible(true);
                subPrin.setVisible(false);
                
            }
        });
        generarNuevoButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setStartButton.setBackground(Color.WHITE);
                setEndButton.setBackground(Color.WHITE);
                subPrin.setVisible(true);
                setEndButton.setEnabled(true);
                setStartButton.setEnabled(true);
                secondPrin.add(subPrin);
                subPrin.setBounds(600, 270, 175, 85);
            }
        });

        bfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean result=false;
                if(!setStartButton.isEnabled()&&!setEndButton.isEnabled()){
                if(dinamic){
                    long startTime = System.nanoTime();
                    result = controlador.solveBFSDinamica();
                    long endTime = System.nanoTime();
                    double durationIterativo = (endTime - startTime) / 100_000_000.00;
                    data.setText("Tiempo: " + durationIterativo + " segundos");
                    JOptionPane.showMessageDialog(null, result ? "Solución encontrada con BFS" : "No se encontró solución con BFS");
                    updateGrid();
                }else{
                    long startTime = System.nanoTime();
                    result = controlador.solveBFSRecursivo();
                    long endTime = System.nanoTime();
                    double durationIterativo = (endTime - startTime) / 100_000_000.00;
                    data.setText("Tiempo: " + durationIterativo + " segundos");
                    JOptionPane.showMessageDialog(null, result ? "Solución encontrada con BFS" : "No se encontró solución con BFS");
                    updateGrid();

                }
            }else{
                JOptionPane.showMessageDialog(null, setStartButton.isEnabled()&&setEndButton.isEnabled() ? "Debe seleccionar un inicio o un fin" : "No se encontró solución con BFS");
            }
            }
        });

        dfsButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result=false;
                
                if(!setStartButton.isEnabled()&&!setEndButton.isEnabled()){
                if(dinamic){
                    long startTime = System.nanoTime();
                    result = controlador.solveDFSDinamico();
                    long endTime = System.nanoTime();
                    double durationIterativo = (endTime - startTime) / 100_000_000.00;
                    data.setText("Tiempo: " + durationIterativo + " segundos");
                    JOptionPane.showMessageDialog(null, result ? "Solución encontrada con BFS" : "No se encontró solución con BFS");
                    updateGrid();
                }else{
                    long startTime = System.nanoTime();
                    result = controlador.solveDFS();
                    long endTime = System.nanoTime();
                    double durationIterativo = (endTime - startTime) / 100_000_000.00;
                    data.setText("Tiempo: " + durationIterativo + " segundos");
                    JOptionPane.showMessageDialog(null, result ? "Solución encontrada con BFS" : "No se encontró solución con BFS");
                    updateGrid();

                }
            }else{
                JOptionPane.showMessageDialog(null, setStartButton.isEnabled()&&setEndButton.isEnabled() ? "Debe seleccionar un inicio o un fin" : "No se encontró solución con BFS");
            }
            }
        });


        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setStartButton.setBackground(Color.WHITE);
                setEndButton.setBackground(Color.WHITE);
                controlador.limpiarMatriz();
                setEndButton.setEnabled(true);
                setStartButton.setEnabled(true);
                updateGrid();
                /* 
                gridPanel.removeAll();
                int ancho = Integer.parseInt(widthField.getText());
                int alto = Integer.parseInt(heightField.getText());
                controlador = new LaberintoControlador(ancho, alto);
                generateGrid(ancho, alto);*/
            }
        });

        setStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setStartButton.setBackground(colorBtnDesc);
                settingStart = true;
                settingEnd = false;
                setStartButton.setEnabled(false);
            }
        });

        setEndButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEndButton.setBackground(colorBtnDesc);
                settingStart = false;
                settingEnd = true;
                setEndButton.setEnabled(false);
            }
        });
        
    }

    private void generateGrid(int ancho, int alto) {
        gridPanel.removeAll();
        gridPanel.setLayout(new GridLayout(ancho, alto));
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Button button = new Button();
                int x = i;
                int y = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (settingStart) {
                            controlador.setInicio(x, y);
                            settingStart = false;
                        } else if (settingEnd) {
                            controlador.setFin(x, y);
                            settingEnd = false;
                        } else {
                            controlador.toggleCelda(x, y);
                        }
                        updateGrid();
                    }
                });
                updateButton(button, controlador.getLaberinto().getCelda(i, j));
                gridPanel.add(button);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void updateButton(Button button, Celda celda) {
        if (celda.isInicio()) {
            button.setBackground(fondo);
        } else if (celda.isFin()) {
            button.setBackground(fin);
        } else if (celda.getEstado()) {
            button.setBackground(colorSec);
        } else if (celda.isParteDelCamino()) {
            button.setBackground(camino);
        } else  {
            button.setBackground(Color.WHITE);
        }
    }

    private void updateGrid() {
        
        for (Component comp : gridPanel.getComponents()) {
            if (comp instanceof Button) {
                Button button = (Button) comp;
                int i = gridPanel.getComponentZOrder(comp) / controlador.getLaberinto().getAlto();
                int j = gridPanel.getComponentZOrder(comp) % controlador.getLaberinto().getAlto();
                updateButton(button, controlador.getLaberinto().getCelda(i, j));
            }
        }
    }
}