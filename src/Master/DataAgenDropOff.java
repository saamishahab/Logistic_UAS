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
class DataAgenDropOff {
    
    String kode,nama_agen,alamat,kota_id;

    public DataAgenDropOff(String kode, String nama_agen, String alamat, String kota_id) {
        this.kode = kode;
        this.nama_agen = nama_agen;
        this.alamat = alamat;
        this.kota_id = kota_id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_agen() {
        return nama_agen;
    }

    public void setNama_agen(String nama_agen) {
        this.nama_agen = nama_agen;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota_id() {
        return kota_id;
    }

    public void setKota_id(String kota_id) {
        this.kota_id = kota_id;
    }
    


    
}
