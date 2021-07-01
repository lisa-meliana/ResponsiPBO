/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.ModelMovie;

/**
 *
 * @author Lisa Meliana
 */
public class Control {
   ModelMovie modelmovie;
   Object[][] modelmovies = new Object[100][4];
    private Object[][] movie;
    public Control(ModelMovie modelmovie){
       this.modelmovie = modelmovie;
    }
    
    public Object[][] index(){
       movie = modelmovie.getMovie();
       return movie;
   } 
    
    public void simpan(String judul, double alur, double penokohan, double akting){
        boolean sudahada = false;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                sudahada = true;
                break;
            }
        }
        if(sudahada){
            JOptionPane.showMessageDialog(null,"Movie Sudah ada dalam database!");
        } else {
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Maksimal alur, penokohan, dan akting adalah 5!"); 
            } else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Minimal alur, penokohan, dan akting adalah 0!");
            } else{
                modelmovie.insert(judul, alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Movie!");
            }
        }
    }
    
    public void update(String judul, double alur, double penokohan, double akting){
        boolean ketemu = false;
        int index = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                index = i;
                ketemu = true;
                break;
            }
        }
        
        if(ketemu){
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
               JOptionPane.showMessageDialog(null,"Maksimal alur, penokohan, dan akting adalah 5!"); 
            } else if(alur < 0 || penokohan < 0 || akting < 0){
                JOptionPane.showMessageDialog(null,"Minimal alur, penokohan, dan akting adalah 0!");
            } else{
                modelmovie.update(movie[index][0].toString(), alur, penokohan, akting);
                JOptionPane.showMessageDialog(null,"Berhasil Mengupdate Movie!");
            }
        } else {
           JOptionPane.showMessageDialog(null,"Movie tidak ditemukan!"); 
        }
    }
    
    public void delete(String judul){
        boolean found = false;
        int index = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                index = i;
                found = true;
                break;
            }
        }
        if (found){
            modelmovie.delete(movie[index][0].toString());
            JOptionPane.showMessageDialog(null,"Berhasil Menghapus Movie!");
        }else{
           JOptionPane.showMessageDialog(null,"Movie tidak ditemukan!"); 
        }
    }

    public void store(String judul, double alur, double penokohan, double akting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
