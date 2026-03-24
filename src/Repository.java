import java.sql.*;
import java.util.ArrayList;

class Repository {

    private static final String DB_URL = "jdbc:sqlite:Hardware Repository.db";

    public ArrayList<Hardware> getAllHardware() {
        ArrayList<Hardware> list = new ArrayList<>();

        String query = "SELECT * FROM [Hardware List]";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String brand = rs.getString("Brand");
                int spec = rs.getInt("Spec");
                String type = rs.getString("Type");

                if (type.equalsIgnoreCase("Laptop")) {
                    list.add(
                            new Laptop.Builder()
                                    .setId(id)
                                    .setBrand(brand)
                                    .setSpec(spec)
                                    .build()
                    );
                } else if (type.equalsIgnoreCase("Phone")) {
                    list.add(
                            new Phone.Builder()
                                    .setId(id)
                                    .setBrand(brand)
                                    .setSpec(spec)
                                    .build()
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
