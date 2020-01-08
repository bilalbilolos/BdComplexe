
package MyInterface.models;

public class Temperature {
    private String officeName;
    private String value ;

    public Temperature(String officeName, String value) {
        this.officeName = officeName;
        this.value = value;
    }

    public Temperature() {
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Temperature{" + "officeName=" + officeName + ", value=" + value + '}';
    }
    
    
    
    
}
