import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rezky Rizaldi
 */
public class RumahSakitClass {

    /**
     * @return the tglMasuk
     */
    public Date getTglMasuk() {
        return tglMasuk;
    }

    /**
     * @param tglMasuk the tglMasuk to set
     */
    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    /**
     * @return the tglKeluar
     */
    public Date getTglKeluar() {
        return tglKeluar;
    }

    /**
     * @param tglKeluar the tglKeluar to set
     */
    public void setTglKeluar(Date tglKeluar) {
        this.tglKeluar = tglKeluar;
    }
    
    private String namaPasien;
    private String alamat;
    private String tlp;
    private int kdKamar;
    private char askes;
    private char pBaru;
    private Date tglMasuk;
    private Date tglKeluar;
    //------------------//
    private int bAdmin;
    private int bInap;
    private String kamar;
    
    public  RumahSakitClass(){
        namaPasien = "";
        alamat = "";
        tlp = "";
        kdKamar = 0;
        askes = 'T';
        pBaru = 'T';
    }
    
    public int PasienBaru(){
        int bBaru;
        
        if ( this.getpBaru() == 'Y' ){
            bBaru = 100000;
        } else {
            bBaru = 0;
        }
        
        return bBaru;
    }
    
    public long CariLama(){
        long hari1, hari2;
        
        //System.out.println("tgl masuk = " + this.getTglMasuk());
        hari1 = this.getTglMasuk().getTime();
        hari2 = this.getTglKeluar().getTime();
        
        long diff = hari2-hari1;
        
        //  konversi ke milidetik dengan ketentuan 1 hari = 24 jam x 60 detik 60 sekon x 1000 milidetik
        long lama = diff / (24 * 60 *60 * 1000);
        
        return (lama);
    }
    
    public void cariHarga(){
        //  System.out.println("setting kode kamar = " +this.getKdKamar() );
        switch (this.getKdKamar()){
            case 0 : bAdmin=(1000000);
            bInap=(2500000);
            kamar=("VIP");
                    break;
            case 1 : bAdmin=(500000);
            bInap=(1000000);
            kamar=("Kamar 1");
                    break;
            case 2 : bAdmin=(350000);
            bInap=(500000);
            kamar=("Kamar 2");
                    break;
            case 3 : bAdmin=(150000);
            bInap=(300000);
            kamar=("Kamar 3");
                    break;
            default : bAdmin=(0);
            bInap=(0);
            kamar=("Tidak ada");
        }
    }
    
    public long biayaInap(){
        long totInap;
        
        totInap = CariLama() * this.getbInap();
        
        return (totInap);
    }
    
    public double PotAskes(){
        double potongan;
        
        if ( this.getAskes() == 'Y' ){
            potongan = 0.3 * biayaInap();
        } else {
            potongan = 0;
        }
        
        return (potongan);
    }
    
    public double totBay(){
       double totBay;
       
       totBay = biayaInap() + PasienBaru() - PotAskes();
       
       return (totBay);
    }
    
    public void tampilkan(){
        System.out.println("Nama Pasien             : " + this.getNamaPasien());
        System.out.println("Alamat Pasien           : " + this.getAlamat());
        System.out.println("Telepon                 : " + this.getTlp());
        System.out.println("Lama inap               : " + CariLama());
        System.out.println("Jenis Kamar             : " + this.kamar);
        System.out.println("Biaya Pasien Baru       : " + this.PasienBaru());
        System.out.println("Potongan Askes          : " + this.PotAskes());
        System.out.println("Total Setelah Potongan  : " + totBay());
    }

    /**
     * @return the namaPasien
     */
    public String getNamaPasien() {
        return namaPasien;
    }

    /**
     * @param namaPasien the namaPasien to set
     */
    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the tlp
     */
    public String getTlp() {
        return tlp;
    }

    /**
     * @param tlp the tlp to set
     */
    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    /**
     * @return the kdKamar
     */
    public int getKdKamar() {
        return kdKamar;
    }

    /**
     * @param kdKamar the kdKamar to set
     */
    public void setKdKamar(int kdKamar) {
        this.kdKamar = kdKamar;
    }

    /**
     * @return the askes
     */
    public char getAskes() {
        return askes;
    }

    /**
     * @param askes the askes to set
     */
    public void setAskes(char askes) {
        this.askes = askes;
    }

    /**
     * @return the pBaru
     */
    public char getpBaru() {
        return pBaru;
    }

    /**
     * @param pBaru the pBaru to set
     */
    public void setpBaru(char pBaru) {
        this.pBaru = pBaru;
    }

    /**
     * @return the bAdmin
     */
    public int getbAdmin() {
        return bAdmin;
    }


    /**
     * @return the bInap
     */
    public int getbInap() {
        return bInap;
    }


    /**
     * @return the kamar
     */
    public String getKamar() {
        return kamar;
    }
}