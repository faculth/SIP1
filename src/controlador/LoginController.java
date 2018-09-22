package controlador;

import vista.Login;
import vista.UserForm;
import Launcher.Launcher;
import modelo.Usuario;
import servicios.UsuarioServicio;

import javax.swing.*;


public class LoginController implements IController {

    private JFrame frame;
    private Login login;
    private UserForm userForm;
    private JPanel currentView;
    private Launcher main;
    private Usuario usuarioLogueado;
    
    public LoginController(JFrame frame) {
        this.frame = frame;
        login = new Login();
        userForm = new UserForm();
    }

    public void updateView() {
        frame.setContentPane(this.getCurrentView());
        frame.repaint();
        frame.setVisible(true);
    }

    public void setMain(Launcher main) {
        this.main = main;
    }

    public void renderMain() {
        renderLoginForm();
    }


    public void deleteAccount() {
        return;
    }

    private JPanel getCurrentView() {
        if (currentView == null) {
            renderLoginForm();
        }
        return currentView;
    }

    public void renderLoginForm() {
        currentView = login;
        login.setLoginController(this);
        this.updateView();
    }

    public void renderUserForm() {
        currentView = userForm;
        userForm.setUserController(this);
        this.updateView();
    }

    public boolean saveUser(String name,  String userEmail, String password, String birthDay, int id) {
        // todo  save;

        return true;
    }

    public void doLogin(String s) {
    	Usuario u = UsuarioServicio.getInstancia().buscarUsuario(Integer.parseInt(s));
    	setUser(u);
        main.onUserLogin();
    }
    
    public void doExit() {
        System.out.println("doExit");
        main.exit();
    }
    
	private void setUser(Usuario user){
		this.usuarioLogueado = user;
	}
}
