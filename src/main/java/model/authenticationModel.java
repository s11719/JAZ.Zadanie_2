package model;


public class authenticationModel extends userModel {
    
    String password;

    public authenticationModel(String username, String email, String role) {
        super(username, email, role);
    }
    
}
