package Model;

import Util.EstadoCliente;

public class Cliente {
    private int id;
    private String identificacion;

    private String name;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private EstadoCliente estado;
    private String RegisterDate;
    private String dateLastActivity;

    public Cliente(int id,String identificacion, String name, String lastName, String adress, String phoneNumber, String email, EstadoCliente estado, String registerDate, String dateLastActivity) {
        this.id = id;
        this.identificacion = identificacion;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.estado = estado;
        RegisterDate = registerDate;
        this.dateLastActivity = dateLastActivity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(String registerDate) {
        RegisterDate = registerDate;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }
}
