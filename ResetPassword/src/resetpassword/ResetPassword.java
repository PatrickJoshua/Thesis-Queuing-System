/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resetpassword;

import java.util.Scanner;
import java.util.prefs.Preferences;

/**
 * SAGUINSIN, Patrick Joshua B.
 * @author PatrickJoshua
 */
public class ResetPassword
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Preferences prefs = Preferences.userRoot();
        System.out.print("Do you want to reset this controller's password? (y/N): ");
        Scanner in = new Scanner(System.in);
        if(in.next().contains("y")) {
            prefs.remove("PASSWORD");
            System.out.println("Controller password has been changed to blank.");
        }
        
        System.out.print("Do you want to reset the web app admin password?"
                + " (Only applicable if the web server is running on this system) (y/N): ");
        if(in.next().contains("y")) {
            prefs.remove("WEBPW");
            System.out.println("Web app password has been changed to blank.");
        }
    }

}
