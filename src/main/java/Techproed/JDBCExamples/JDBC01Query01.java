package Techproed.JDBCExamples;
import java.sql.*;

public class JDBC01Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- Ilgili driver i yukle...
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2- Baglanti olsuturma
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

        // 3- SQL komutlari icin bir Statements nesnesi olustur...
        Statement st = con.createStatement();

        // 4- SQL ifadeleri yazabilir ve calistirabiliriz...
        //(personel tab;losundaki personel_id si 7369 olan perseonelin adini ve maasini sorgula)

        ResultSet isim = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE personel_id=7369 ");

        // 5- Sonuclari aldikve isledik...
        while(isim.next()) {

            System.out.print("Personel isim " +  isim.getString("personel_isim")+ " maas: "+isim.getInt("maas"));
        }

        // Olusturulan nesneleri kapatalim...

        con.close();
        st.close();
        isim.close();
    }
}
