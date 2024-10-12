package Techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02Query03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		Statement st = con.createStatement();

		/*
		 * ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini ve
		 * maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa bile
		 * bolum ismi gosterilmelidir.
		 */

		ResultSet sonuc1 = st.executeQuery("SELECT bolum_isim, personel_isim, maas" 
		+ " FROM bolumler"
		+ " LEFT JOIN personel" 
		+ " ON bolumler.bolum_id=personel.bolum_id" 
		+ " ORDER BY bolum_isim, maas");

		while (sonuc1.next()) {
			System.out.println(sonuc1.getString(1) + "    \t" + sonuc1.getString(2) + "     \t" + sonuc1.getInt(3));
		}

		System.out.println("=====================================");


		con.close();
		st.close();
		sonuc1.close();
	}

}