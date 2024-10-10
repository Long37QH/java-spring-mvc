package vn.hoidanit.laptopshop.domain.dto;

import vn.hoidanit.laptopshop.service.validator.RegisterChecked;

@RegisterChecked
public class RegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String passwors;
    private String confirmPasswors;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswors() {
        return passwors;
    }
    public void setPasswors(String passwors) {
        this.passwors = passwors;
    }
    public String getConfirmPasswors() {
        return confirmPasswors;
    }
    public void setConfirmPasswors(String confirmPasswors) {
        this.confirmPasswors = confirmPasswors;
    }

    
}
