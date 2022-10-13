import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {
    private int id;
    private String city;
    private String street;
    private int house;
    private int building;
    private int flat;
    Address (int id, String city, String street, int house, Integer building, Integer flat){
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.building = building;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getBuilding() {
        return building;
    }

    public int getFlat() {
        return flat;
    }

    public static Address toObj (ResultSet result) throws SQLException {
        return new Address(
                result.getInt("id"),
                result.getString("city"),
                result.getString("street"),
                result.getInt("house"),
                result.getInt("building"),
                result.getInt("flat"));
    }
    @Override
    public String toString () {
        return "Address {" +
                "id=" + id +
                ", city = " + city + ", " +
                ", street = " + street +", " +
                ", house = " + house + ", " +
                ", building = " + building + ", " +
                ", flat = " + flat + "}" + "\n";
    }
}
