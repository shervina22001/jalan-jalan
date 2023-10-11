/*
 * Nama File          : Main.java
 * Tanggal            : 10 Oktober 2023
 * Deskripsi          : Program untuk menghitung lama perjalanan
 * Nama - NPM         : Risya Annisa' Chairyah - 140810220008
 *                    : Faizzani Zingsky Pratiwi - 140810220008
 *                    : Shervina Ananda Hardellya - 140810220066   
 * 
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class Perjalanan {
    private Date tanggalBerangkat;
    private Date tanggalKedatangan;

    public void inputTanggalBerangkat(String tglBerangkat, String jamBerangkat) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.tanggalBerangkat = dateFormat.parse(tglBerangkat + " " + jamBerangkat);
    }

    public void inputTanggalKedatangan(String tglKedatangan, String jamKedatangan) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.tanggalKedatangan = dateFormat.parse(tglKedatangan + " " + jamKedatangan);
    }

    public long hitungLamaHariPerjalanan() {
        long selisihMillis = this.tanggalKedatangan.getTime() - this.tanggalBerangkat.getTime();
        long selisihDetik = selisihMillis / 1000;
        long selisihMenit = selisihDetik / 60;
        long selisihJam = selisihMenit / 60;
        long selisihHari = selisihJam / 24;

        return selisihHari;
    }

    public long hitungLamaPerjalanan() {
        long selisihMillis = this.tanggalKedatangan.getTime() - this.tanggalBerangkat.getTime();

        return selisihMillis;
    }

    public void tampilInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println("\nBerangkat:");
        System.out.println("Tanggal : " + dateFormat.format(this.tanggalBerangkat));
        System.out.println("Jam     : " + timeFormat.format(this.tanggalBerangkat));

        System.out.println("\nKedatangan:");
        System.out.println("Tanggal : " + dateFormat.format(this.tanggalKedatangan));
        System.out.println("Jam     : " + timeFormat.format(this.tanggalKedatangan));

        long lamaHariPerjalanan = hitungLamaHariPerjalanan();
        long lamaPerjalanan = hitungLamaPerjalanan();
        long sisaJam = (lamaPerjalanan / (1000 * 60 * 60)) % 24;
        long sisaMenit = (lamaPerjalanan / (1000 * 60)) % 60;
        long sisaDetik = (lamaPerjalanan / 1000) % 60;
        System.out.println("\nLama Perjalanan: " + lamaHariPerjalanan + " hari " + sisaJam + " jam " + sisaMenit + " menit " + sisaDetik + " detik");
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        Perjalanan perjalanan = new Perjalanan();

        String tglBerangkat = System.console().readLine("Tanggal berangkat (dd/MM/yyyy): ");
        String jamBerangkat = System.console().readLine("Jam berangkat (HH:mm:ss): ");
        perjalanan.inputTanggalBerangkat(tglBerangkat, jamBerangkat);

        String tglKedatangan = System.console().readLine("Tanggal kedatangan (dd/MM/yyyy): ");
        String jamKedatangan = System.console().readLine("Jam kedatangan (HH:mm:ss): ");
        perjalanan.inputTanggalKedatangan(tglKedatangan, jamKedatangan);

        perjalanan.tampilInfo();
    }
}
