/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bsu.fpmi.educational_practice2017;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.awt.event.*;
import java.util.EventListener;

public class TextAndButtonPanel extends Panel{
    
    protected ArrayList<AcceptListener> listeners = new ArrayList<>();
    
    protected String textLabel;
    protected String textButton;
    
    protected Label label;
    protected Button button;
    
    public TextAndButtonPanel(){
        this("Text Label", "Text Button");
    }
    
    public TextAndButtonPanel(String textLabel, String textButton){
        label=new Label();
        button=new Button();
        
        this.textLabel=textLabel;
        this.textButton=textButton;
        
        label.setText(this.textLabel);
        button.setLabel(this.textButton);
        
        setLayout(new BorderLayout(15, 15));
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(label, this);
        add(button, this);
        
        button.addActionListener((ActionEvent e) -> {
        fireEvent(new AcceptEvent(TextAndButtonPanel.this, label.getText()));
                this.setTextButton(label.getText());
        });
    }
    
    public String getTextLabel(){
        return textLabel;
    }
    
    public String getTextButton(){
        return textButton;
    }
    
    public void setTextLabel(String textLabel){
        this.textLabel=textLabel;
        label.setText(this.textLabel);
        validate();
    }
    
    public void setTextButton(String textButton){
        this.textButton=textButton;
        button.setLabel(this.textButton);
        validate();
    }
    
        
    public void addAcceptListener(AcceptListener l) {
	listeners.add(l);
    }
    
    public void removeAcceptListener(AcceptListener l) {
	listeners.remove(l);
    }
    
    public AcceptListener[] getAcceptListeners(){
        return listeners.toArray(new AcceptListener[0]);
    }
    
    public final void fireEvent(AcceptEvent e) {
	ArrayList<AcceptListener> list = (ArrayList<AcceptListener>) listeners.clone();
        list.stream().forEach((listener) -> {
            listener.buttonPressed(e);
        });
    }
      
}
