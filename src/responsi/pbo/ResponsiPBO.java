/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.pbo;

import modeldatabase.Connector;
import view.ViewMovie;

/**
 *
 * @author Lisa Meliana
 */
public class ResponsiPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connector DB = new Connector();
        ViewMovie viewmovie = new ViewMovie(DB);
        viewmovie.setVisible(true);
    }
    
}
