public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(1,"Minsk", "Nahimova", 5,1,5);
        Address address2 = new Address(2,"Borisov", "Lenina", 15,2,0);
        Address address3 = new Address(3,"Minsk", "Lenina", 3,4,5);
        Address address4 = new Address(4,"Moscow", "Kutuzova", 3,0,71);
        Address address5 = new Address(5,"Minsk", "Pobediteley", 6,3,47);

        Address addressUpd1 = new Address(1,"Odincovo", "Pivovarov", 15,2,153);
        Address addressUpd2 = new Address(2,"Minsk", "Golubeva", 52,0,24);

        AddressConnector.add(address1);
        AddressConnector.add(address2);
        AddressConnector.add(address3);
        AddressConnector.add(address4);
        AddressConnector.add(address5);
        System.out.println(AddressConnector.readAll());
        AddressConnector.update(addressUpd1);
        AddressConnector.update(addressUpd2);
        System.out.println(AddressConnector.readAll());
        AddressConnector.delete(1);
        AddressConnector.delete(3);
        System.out.println(AddressConnector.readAll());
    }
}