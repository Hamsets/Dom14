import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/my_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String ADD = "INSERT INTO addresses (id,city,street,house,building,flat) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM addresses";
    private static final String DEL_BY_ID = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE_By_ID = "UPDATE addresses SET " +
            "id = ?, " +
            "city = ?," +
            "street = ?," +
            "house = ?," +
            "building = ?," +
            "flat = ? WHERE id = ?";


    public static Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(DB_URL,USER,PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void add (Address address){
        connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD)){
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouse());
            statement.setInt(5, address.getBuilding());
            statement.setInt(6, address.getFlat());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    };

    public static List<Address> readAll() {
        List<Address> res = new ArrayList<>();
        connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Address address = Address.toObj(result);
                res.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static  void delete (int id){
        connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DEL_BY_ID)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void update (Address address){
        connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_By_ID)){

            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouse());
            statement.setInt(5, address.getBuilding());
            statement.setInt(6, address.getFlat());
            statement.setInt(7, address.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
