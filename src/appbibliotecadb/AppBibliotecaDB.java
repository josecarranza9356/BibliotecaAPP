/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appbibliotecadb;


import appbibliotecadb.View.Login;
import appbibliotecadb.View.Menu;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.io.IOException;

/**
 *
 * @author JoseCv14
 */
public class AppBibliotecaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        FlatMacLightLaf.setup();

        //ingresar a login
        //Login login_user = new Login();
        //login_user.setVisible(true);
        //ingresar a menu
        Menu menu = new Menu();
        menu.setVisible(true);

        

    }

}
