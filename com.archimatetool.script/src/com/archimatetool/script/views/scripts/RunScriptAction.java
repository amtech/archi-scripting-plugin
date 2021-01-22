/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.script.views.scripts;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import com.archimatetool.script.IArchiScriptImages;
import com.archimatetool.script.RunArchiScript;
import com.archimatetool.script.ScriptFiles;


/**
 * Run Script Action
 */
public class RunScriptAction extends Action {

    private File fFile;

    public RunScriptAction() {
        setImageDescriptor(IArchiScriptImages.ImageFactory.getImageDescriptor(IArchiScriptImages.ICON_RUN));
        setText(Messages.RunScriptAction_0);
        setToolTipText(Messages.RunScriptAction_1);
    }
    
    public void setFile(File file) {
        fFile = file;
        setEnabled(ScriptFiles.isScriptFile(file));
    }

    @Override
    public void run() {
        if(isEnabled()) {
            try {
                RunArchiScript runner = new RunArchiScript(fFile);
                runner.run();
            }
            catch(Exception ex) {
                MessageDialog.openError(null, Messages.RunScriptAction_1, ex.getMessage());
            }
        }
    }
}