package cl.paradigmas;

import java.awt.event.MouseAdapter;

import javax.swing.JToggleButton;

import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.eventos.EventBuilder;


public class Main {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.getToolbar().addBtn("Circulo",new JToggleButton("Circulo"));
		ventana.getToolbar().addBtn("Linea",new JToggleButton("Linea"));
		ventana.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.Limpieza(ventana));
		ventana.getToolbar().getBtn("Circulo").addActionListener(EventBuilder.DibujaCirculo(ventana));
		ventana.getToolbar().getBtn("Linea").addActionListener(EventBuilder.DibujaLinea(ventana));
		
		MouseAdapter uno = EventBuilder.DibujaElCanvas(ventana);
		ventana.getCanvas().addMouseListener(uno);
		ventana.getCanvas().addMouseListener(uno);
		ventana.getCanvas().addMouseMotionListener(uno);
		ventana.setVisible(true);
	}

}