package pl.project.carDealer.Dtos;

public class DtosCustomer {

    private Integer id;
    private Integer customer_number;
    private String last_name;
    private String first_name;
    private String address;
    private String pesel;
    private String nNIP;


    public DtosCustomer() {
    }

    public DtosCustomer (Integer customer_number, String last_name, String first_name,
                         String addres, String nNIP, String pesel ){
        this.customer_number = customer_number;
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = addres;
        this.nNIP = nNIP;
        this.pesel = pesel;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(Integer customer_number) {
        this.customer_number = customer_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getnNIP() {
        return nNIP;
    }

    public void setnNIP(String nNIP) {
        this.nNIP = nNIP;
    }
}
