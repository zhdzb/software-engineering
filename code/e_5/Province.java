package sorftware_engineering;

public class Province {
    private String name;
    private int sum;
    private City[] city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public City[] getCity() {
        return city;
    }

    public void setCity(City[] city) {
        this.city = city;
    }
}
