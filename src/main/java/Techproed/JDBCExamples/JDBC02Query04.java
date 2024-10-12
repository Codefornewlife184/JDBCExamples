package Techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02Query04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		Statement st = con.createStatement();

		/*
		 * =======================================================================
		 * ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
		 * ========================================================================
		 */

		ResultSet sonuc2 = st.executeQuery("SELECT bolum_isim, personel_isim, maas" 
		                + " FROM personel" 
						+ " FULL JOIN bolumler"
						+ " ON bolumler.bolum_id=personel.bolum_id" 
						+ " ORDER BY maas DESC" 
						+ " FETCH NEXT 10 ROWS ONLY");

		while (sonuc2.next()) {

			System.out.println(sonuc2.getString(1) + "\t\t" + sonuc2.getString(2) + "\t\t" + sonuc2.getInt(3));
		}

		con.close();
		st.close();
	}

}