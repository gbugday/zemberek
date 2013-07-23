
package zemberek;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.KelimeTipi;
import net.zemberek.yapi.Kok;


public class Zemberek {

    
    public static void main(String[] args) {
       net.zemberek.erisim.Zemberek zemberek = new net.zemberek.erisim.Zemberek(new TurkiyeTurkcesi());
        Scanner nesne=new Scanner(System.in);
        
        String giris = "kitaplarım";
        System.out.println("Giriş:" + giris);
        //denetleme
        if (!zemberek.kelimeDenetle(giris)) {
            System.out.println(giris + "kelimesi doğru yazılmamış");
            System.exit(1);
        }
        System.out.println(giris + " kelimesi doğru yazılmış");
        //cozumleme
        Kelime [] cozumler=zemberek.kelimeCozumle(giris);
        System.out.println("Çözümlemeler");
        for(Kelime kelime:cozumler)
            System.out.println(kelime);
        // ayrıstırma
        System.out.println("\nayrıştırma sonuçları:");
        List <String []> ayrisimlar=zemberek.kelimeAyristir(giris);
        for(String [] strings: ayrisimlar)
            System.out.println(Arrays.toString(strings));
        //kelime üretme
        Kelime kelime=cozumler[0];
        List<Kok> kokler=zemberek.dilBilgisi().kokler().kokBul("on");
        System.out.println("kokler"+ kokler);
        Kok kok=zemberek.dilBilgisi().kokler().kokBul("koyun", KelimeTipi.ISIM);
        String yeni=zemberek.kelimeUret(kok, kelime.ekler());
        System.out.println("\nkök değişimi sonrası yeni kelime "+ yeni);
        //ascii donusum çözümleme
        String asciiGiris="koyun";
        System.out.println('\n'+ asciiGiris + "için ascii ayrıştırma:");
        Kelime [] asciiCozumler=zemberek.asciiCozumle(asciiGiris);
        for(Kelime kelime1: asciiCozumler)
            System.out.println("olası çözümler:"+kelime1);
        // ascii dönüşüm işlemini doğrudan String [] döndürme
        System.out.println("\n 'koyun' için ascii dönüşüm sonuçları");
        String []sonuclar=zemberek.asciidenTurkceye("koyun");
        for(String s: sonuclar)
            System.out.println("olası çözüm:"+s);
        //heceleme
        String [] heceler=zemberek.hecele(giris);
        System.out.println("\n heceleme sonucu:"+Arrays.toString(heceler));
    }
}
