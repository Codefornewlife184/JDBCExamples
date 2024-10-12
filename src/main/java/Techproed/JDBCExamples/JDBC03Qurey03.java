package Techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC03Qurey03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		Statement st = con.createStatement();

		
		// Ornek 2 :  SATIS VE MUHASEBE bolumlerinde calisan personelin isimlerini ve
		// maaslarini, maas ters sirali olarak listeleyin...
		

		String a = "SELECT personel_isim, maas" + " FROM personel" + " WHERE bolum_id IN (10,30)"
				+ " ORDER BY maas DESC"; 
		// komutları tırnağın içindeyken enterla alt satıra indirdiğimizde bir
		// karakter boşluk bırakmalıyız ki üstteki komutla yapışmasın

		ResultSet tablo2 = st.executeQuery(a);

		System.out.println("Personel Tablosu");	

		while (tablo2.next()) {
			System.out.println(tablo2.getString(1) + "   \t" + tablo2.getInt(2));

		}

		System.out.println("=====================================");

		con.close();
		st.close();
		tablo2.close();
	
	}

}