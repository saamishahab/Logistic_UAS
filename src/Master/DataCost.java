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
class DataCost {
    
    String kode,fromcitycode,tocitycode,cost_kg;

    public DataCost(String kode, String fromcitycode, String tocitycode, String cost_kg) {
        this.kode = kode;
        this.fromcitycode = fromcitycode;
        this.tocitycode = tocitycode;
        this.cost_kg = cost_kg;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getFromcitycode() {
        return fromcitycode;
    }

    public void setFromcitycode(String fromcitycode) {
        this.fromcitycode = fromcitycode;
    }

    public String getTocitycode() {
        return tocitycode;
    }

    public void setTocitycode(String tocitycode) {
        this.tocitycode = tocitycode;
    }

    public String getCost_kg() {
        return cost_kg;
    }

    public void setCost_kg(String cost_kg) {
        this.cost_kg = cost_kg;
    }
    


    
}
