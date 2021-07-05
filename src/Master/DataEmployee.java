/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Master;

/**
 *
 * @author Ami
 */
class DataEmployee {
    
    String kode, nama, jeniskelamin,  username, password, id_dropoff_agent;

    public DataEmployee(String kode, String nama, String jeniskelamin, String username, String password, String id_dropoff_agent) {
        this.kode = kode;
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
        this.username = username;
        this.password = password;
        this.id_dropoff_agent = id_dropoff_agent;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_dropoff_agent() {
        return id_dropoff_agent;
    }

    public void setId_dropoff_agent(String id_dropoff_agent) {
        this.id_dropoff_agent = id_dropoff_agent;
    }
    
    
    
    
    
}
