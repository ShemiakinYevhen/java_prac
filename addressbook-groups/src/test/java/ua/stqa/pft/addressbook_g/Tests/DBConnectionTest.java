package ua.stqa.pft.addressbook_g.Tests;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook_g.Models.GroupData;
import ua.stqa.pft.addressbook_g.Models.Groups;

import java.sql.*;

public class DBConnectionTest {
    @Test
    public void testDBConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list");
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                        .withHeader(rs.getString("group_header")).withFooter(rs.getString("Group_footer")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

