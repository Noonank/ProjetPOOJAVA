/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.swing.JButton;

/**
 *
 * @author noork
 */
public class Button extends JButton{
    private String name;
    
    public String getName(){
        return name;
    }
    public void setName(String nom){
        this.name = nom;
    }
}
