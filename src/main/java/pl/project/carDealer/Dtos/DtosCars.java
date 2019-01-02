package pl.project.carDealer.Dtos;

public class DtosCars {

    private String vintage;
    private String brand;
    private String model;
    private String nr_oc;
    private String proof_registration_number;
    private String fuel_type;
    private Integer mileage;
    private String engine;
    private String gearbox;
    private String description;
    private Integer number_of_test_drives;

    public DtosCars(String vintage, String brand, String model, String nr_oc,
                    String proof_registration_number, String fuel_type,
                    Integer mileage, String engine, String gearbox, String description,
                    Integer number_of_test_drives) {
        this.vintage = vintage;
        this.brand = brand;
        this.model = model;
        this.nr_oc = nr_oc;
        this.proof_registration_number = proof_registration_number;
        this.fuel_type = fuel_type;
        this.mileage = mileage;
        this.engine = engine;
        this.gearbox = gearbox;
        this.description = description;
        this.number_of_test_drives = number_of_test_drives;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNr_oc() {
        return nr_oc;
    }

    public void setNr_oc(String nr_oc) {
        this.nr_oc = nr_oc;
    }

    public String getProof_registration_number() {
        return proof_registration_number;
    }

    public void setProof_registration_number(String proof_registration_number) {
        this.proof_registration_number = proof_registration_number;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber_of_test_drives() {
        return number_of_test_drives;
    }

    public void setNumber_of_test_drives(Integer number_of_test_drives) {
        this.number_of_test_drives = number_of_test_drives;
    }
}
