/*
 * Validator.java class
 * Matt Koenen / Sidney Rens
 * IS 286 695
 * Project 3 - Employee Application
 * 07/15/18
 */


package validation;

import business.Employee;
import java.awt.Component;
import java.awt.Frame;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validator {
    // Validate for first and last name textfield
    
    public static boolean isValidName(JTextField jtxtField) {
        /* Validate for entries that contain spaces, dots, 
           and special characters */
        boolean validName = false;
        
        if (Pattern.matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", 
                jtxtField.getText())) {
            validName = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(jtxtField), 
                    jtxtField.getName()
                + " is blank or invalid.\n It must not contain spaces, dots "
                + "or numbers.","Invalid Input", JOptionPane.ERROR_MESSAGE);
            jtxtField.setText("");
            jtxtField.requestFocusInWindow();
        }
        
        return validName;
    }
    

    public static boolean isValidEmployeeNumber(JTextField txtField) {
        /* Validate for entries that contain spaces, dots, 
           and special characters. Also checks for correct 
           employee number length*/
        
        boolean validAccountNo = false;
        
        if (Pattern.matches("^[0-9]+$", txtField.getText()) &&
                txtField.getText().length() == 8) {
            validAccountNo = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(txtField), 
                    "Employee Number" 
                    + " is invalid. Only numbers are allowed and the\n"
                    + "Employee number must contain eight numbers",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validAccountNo;
    }
    
    
    public static boolean isTextFieldNotEmpty(JTextField txtField) {
        if (txtField.getText().isEmpty()) {
            errorMessage("The text field " + "'" + txtField.getName() + "'" + 
                    " is empty. \n Please make a valid entry." , txtField);
            txtField.requestFocusInWindow();
            return false;
        }
        return true;
    }  
    
    public static boolean isPhoneValid(JTextField txtField){
        boolean validPhone = false;
        
        if (Pattern.matches("^[0-9]+$", txtField.getText()) &&
                txtField.getText().length() == 7) {
            validPhone = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(txtField), 
                    "Phone Number" 
                    + " is invalid. Only numbers are allowed and the\n"
                    + " phone number must only be SEVEN digits. "
                            + "Plese do not use an area code or dashes.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validPhone;
    }
    
    public static void errorMessage(String message, JTextField txtField) {
        JOptionPane.showMessageDialog(getParentFrame(txtField), message, 
            "Invalid input",JOptionPane.ERROR_MESSAGE);
        txtField.setText("");
        txtField.requestFocusInWindow();
    }
    
    public static Component getParentFrame(Component c) {
        while (!(c instanceof Frame)) {
            c = c.getParent();
            
            if (c==null) {
                break;
            }
        }
        return c;
    }
}

