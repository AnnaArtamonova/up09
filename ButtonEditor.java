/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bsu.fpmi.educational_practice2017;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

public class ButtonEditor extends PropertyEditorSupport {
    
    @Override
    public String[] getTags()
    {
    return new String[]{"Text Button 1", "Text Button 2", "Text Button 3"}; 
    }

    @Override
    public void setAsText(String s)
    {
    if(Arrays.asList(this.getTags()).indexOf(s)!=-1)
    setValue((Object)s);
    else
    setValue((Object)"Default text");
    }

    @Override
    public String getJavaInitializationString()
    {
    return "\""+(String)getValue()+"\"";
    }
    
}
