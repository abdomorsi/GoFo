package models;


/**
 * The class Location
 */
public class Location {
    private String area;
    private String address;


    /**
     *
     * It is a constructor.
     *
     * @param _area  the _area
     * @param _address  the _address
     */
    public Location(String _area, String _address){

        setArea(_area);
        setAddress(_address);
    }


    /**
     *
     * Sets the address
     *
     * @param address  the address
     */
    public void setAddress(String address) {

        this.address = address;
    }


    /**
     *
     * Sets the area
     *
     * @param area  the area
     */
    public void setArea(String area) {

        this.area = area;
    }


    /**
     *
     * Gets the address
     *
     * @return the address
     */
    public String getAddress() {

        return address;
    }


    /**
     *
     * Gets the area
     *
     * @return the area
     */
    public String getArea() {

        return area;
    }
}
