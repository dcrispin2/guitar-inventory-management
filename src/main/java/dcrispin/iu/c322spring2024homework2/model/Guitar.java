package dcrispin.iu.c322spring2024homework2.model;
import org.springframework.web.bind.annotation.GetMapping;
public class Guitar {
    private String serialNumber;
    private double price;
    private Builder builder;
    public enum Builder{
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;
        public String toString() {
            switch(this){
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                default: return "unspecified";
            }
        }
    }
    private String model;
    private Type type;

    public enum Type{
        ACOUSTIC, ELECTRIC;
        public String toString() {
            switch(this){
                case ACOUSTIC: return "acoustic";
                case ELECTRIC: return "electric";
                default: return "unspecified";
            }
        }
    }

    public enum Wood{
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
        public String toString(){
            switch(this){
                case INDIAN_ROSEWOOD: return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
                case MAHOGANY: return "Mahogany";
                case MAPLE: return "Maple";
                case COCOBOLO: return "Cocobolo";
                case CEDAR: return "Cedar";
                case ADIRONDACK: return "Adirondack";
                case ALDER: return "Alder";
                case SITKA: return "Sitka";
                default: return "unspecified";
            }
        }
    }
    private Wood backWood;
    private Wood topWood;


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuilder() {
        if (this.builder != null) {
            return builder.toString();
        }
        else return null;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        if (this.type != null) {
            return type.toString();
        }
        else return null;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBackWood() {
        if (this.backWood != null) {
            return backWood.toString();
        }
        else return null;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public String getTopWood() {
        if (this.topWood != null) {
            return topWood.toString();
        }
        else return null;
    }

    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }
}
