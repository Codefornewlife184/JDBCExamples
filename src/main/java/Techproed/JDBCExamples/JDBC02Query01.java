package Techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		Statement st = con.createStatement();

		// Ornek 1 : bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz...

		ResultSet tablo1 = st.executeQuery("SELECT * FROM bolumler");

		System.out.println("Bolumler Tablosu");
		System.out.println("=====================================");

		while (tablo1.next()) {

			System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + "  \t" + tablo1.getString(3));
		}

		System.out.println("=====================================");

		con.close();
		st.close();
		tablo1.close();

	}

}