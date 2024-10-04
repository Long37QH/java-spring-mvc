package vn.hoidanit.laptopshop.domain;

public class User {
    private long id;
    private String email;
    private String passwors;
    private String fullName;
    private String addRess;
    private String phone;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAddRess() {
        return addRess;
    }
    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", passwors=" + passwors + ", fullName=" + fullName
                + ", addRess=" + addRess + ", phone=" + phone + "]";
    }
 
}
