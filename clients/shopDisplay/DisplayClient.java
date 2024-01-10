package clients.shopDisplay;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * The standalone shop Display Client.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */
public class DisplayClient
{
   public static void main (String args[])
   {
     String stockURL = args.length < 1     // URL of stock RW
                     ? Names.STOCK_RW      //  default  location
                     : args[0];            //  supplied location
     String orderURL = args.length < 2     // URL of order
                     ? Names.ORDER         //  default  location
                     : args[1];            //  supplied location


    RemoteMiddleFactory mrf = new RemoteMiddleFactory();
    mrf.setStockRWInfo( stockURL );
    mrf.setOrderInfo  ( orderURL );        //

    displayGUI(mrf);                       // Create GUI

  }
  
  private static void displayGUI(MiddleFactory mf)
  {     
    JFrame  window = new JFrame();
    JLabel label = new JLabel("Hello");
    label.setFont(new Font("Calibri", Font.BOLD, 15));
    label.setForeground(Color.black);
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);



    window.setTitle( "Pick Client MVC");
    window.getContentPane().setBackground(Color.gray);
    window.setFont(new Font("Calibri", Font.BOLD, 15));
    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    window.getContentPane().add(label);
    label.setForeground(Color.gray );
    
    DisplayModel    model = new  DisplayModel(mf);
    DisplayView     view  = new  DisplayView( window, mf, 0, 0 );
    DisplayController cont  = new DisplayController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Display Screen 
  }
}


