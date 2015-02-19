/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.io.File;

/**
 *
 * @author nUll
 */
public interface IAction {

    void jButtonInsertAction(java.awt.event.ActionEvent evt);

    void jButtonUpdateAction(java.awt.event.ActionEvent evt);

    void jButtonDeleteAction(java.awt.event.ActionEvent evt);

    File aExport();
    

    void aInsertText();

    void aRemovedText();

    void aChangedText();

}
