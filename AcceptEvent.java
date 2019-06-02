/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bsu.fpmi.educational_practice2017;

public class AcceptEvent extends java.util.EventObject {
    protected String textButton;           
    
    public AcceptEvent(Object source, String text) {
	super(source);
        this.textButton = text;
    }
                  
    public String getTextButton(){
        return textButton;
    }
}