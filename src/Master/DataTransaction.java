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
class DataTransaction {
    
    String id,  transaction_no, cost_estimate_kode,  cost,  sender_customer_kode,  receiver_customer_kode, alamat, nama_paket,  berat,  create_date,  create_by;

    public DataTransaction(String id, String transaction_no, String cost_estimate_kode, String cost, String sender_customer_kode, String receiver_customer_kode, String alamat, String nama_paket, String berat, String create_date, String create_by) {
        this.id = id;
        this.transaction_no = transaction_no;
        this.cost_estimate_kode = cost_estimate_kode;
        this.cost = cost;
        this.sender_customer_kode = sender_customer_kode;
        this.receiver_customer_kode = receiver_customer_kode;
        this.alamat = alamat;
        this.nama_paket = nama_paket;
        this.berat = berat;
        this.create_date = create_date;
        this.create_by = create_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public String getCost_estimate_kode() {
        return cost_estimate_kode;
    }

    public void setCost_estimate_kode(String cost_estimate_kode) {
        this.cost_estimate_kode = cost_estimate_kode;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSender_customer_kode() {
        return sender_customer_kode;
    }

    public void setSender_customer_kode(String sender_customer_kode) {
        this.sender_customer_kode = sender_customer_kode;
    }

    public String getReceiver_customer_kode() {
        return receiver_customer_kode;
    }

    public void setReceiver_customer_kode(String receiver_customer_kode) {
        this.receiver_customer_kode = receiver_customer_kode;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public void setNama_paket(String nama_paket) {
        this.nama_paket = nama_paket;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    
    
}
