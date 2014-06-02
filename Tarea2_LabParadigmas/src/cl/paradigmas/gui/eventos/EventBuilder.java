package cl.paradigmas.gui.eventos;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cl.paradigmas.gui.Canvas;
import cl.paradigmas.gui.Ventana;
import cl.paradigmas.modelo.Circulo;
import cl.paradigmas.modelo.Linea;


final public class EventBuilder
{
        private EventBuilder(){
        }
       
        public static ActionListener Limpieza(final Ventana ventana)
        {
                return new ActionListener()
                {
                	@Override
                         public void actionPerformed(ActionEvent e)
                        {
                               ventana.getCanvas().limpiar();
                        }
                };
            }
        
        public static ActionListener DibujaCirculo(final Ventana ventana)
        {
                return new ActionListener()
                {
                	@Override
                         public void actionPerformed(ActionEvent e)
                        {
                               ventana.setSeleccionado(Ventana.CIRCULO);
                        }
                };
            }
        
        public static ActionListener DibujaLinea(final Ventana ventana)
        {
                return new ActionListener()
                {
                	@Override
                         public void actionPerformed(ActionEvent e)
                        {
                               ventana.setSeleccionado(Ventana.LINEA);
                        }
                };
        }
                
                public static MouseAdapter DibujaElCanvas(final Ventana ventana)
                {
                        return new MouseAdapter()
                        {
                        	private Point flarg;
                        	
                                 public void mouseClicked(MouseEvent a)
                                {
                                       int eleccion = ventana.getSeleccionado();
                                       if(Ventana.CIRCULO == eleccion)
                                       {
                                    	   Circulo circulo = new Circulo(a.getPoint(),100);
                                    	   ventana.getCanvas().addDibujable(circulo);
                                       }
                                       
                                       ventana.getCanvas().repaint();
                                   }
                                 
                                 public void mousePressed(MouseEvent a)
                                 {
                                	    Canvas canvas = ventana.getCanvas();
                                        int eleccion = ventana.getSeleccionado();
                                        
                                        if(!canvas.isDibujandoTmp())
                                        {
                                        	canvas.setDibujandoTmp(true);
                                        	if(Ventana.LINEA==eleccion){
                                        		flarg = a.getPoint();
                                        		Linea linea = new Linea(flarg,flarg);
                                        		ventana.getCanvas().setDibujableTmp(linea);
                                     	       	}
                                        ventana.getCanvas().repaint();
                                    }
                                 }
                                 
                                 public void mouseDragged(MouseEvent a)
                                 {
                                	    int eleccion = ventana.getSeleccionado();
                                        Canvas canvas = ventana.getCanvas();
                                        if(canvas.isDibujandoTmp())
                                        {
                                        	if(Ventana.LINEA==eleccion){
                                        		
                                        		Linea linea = (Linea) ventana.getCanvas().getDibujableTmp();
                                        		linea.setFin(a.getPoint());
                                           	}
                                        	  canvas.repaint();
                                       }
                                     
                                  }
                                 
                                 public void mouseReleased(MouseEvent a)
                                 {
                                	    int eleccion = ventana.getSeleccionado();
                                        Canvas canvas = ventana.getCanvas();
                                        if(canvas.isDibujandoTmp())
                                        {
                                        	if(Ventana.LINEA==eleccion){
                                        		
                                        		Linea linea = (Linea) canvas.getDibujableTmp();
                                        		canvas.setDibujableTmp(null);
                                        		canvas.addDibujable(linea);
                                           	}
                                        	canvas.setDibujandoTmp(false);  
                                        	canvas.repaint();
                                       }
                                     
                                  }
                                 
                                 
                              };
                                 
                                 
                
                             };
                             
                             
                
                
                
                
            }
        
               
