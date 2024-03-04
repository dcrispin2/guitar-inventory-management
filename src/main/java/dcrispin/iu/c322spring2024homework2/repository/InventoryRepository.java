package dcrispin.iu.c322spring2024homework2.repository;

import dcrispin.iu.c322spring2024homework2.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryRepository {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "guitars/guitars_database.txt";
    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public static boolean addGuitar(Guitar guitar) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        String data = guitar.getSerialNumber() + "," +
                guitar.getPrice() + "," + guitar.getBuilder()
                + "," + guitar.getModel() + "," + guitar.getType()
                + "," + guitar.getBackWood() + "," + guitar.getTopWood();
        appendToFile(path, data + NEW_LINE);
        return true;
    }

    public static List<Guitar> findAll() throws IOException {
        List<Guitar> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data){
            String[] words = line.split(",");
            Guitar g = new Guitar();
            g.setSerialNumber(words[0]);
            g.setPrice(Double.parseDouble(words[1]));
            g.setBuilder(Guitar.Builder.valueOf(words[2].toUpperCase()));
            g.setModel(words[3]);
            g.setType(Guitar.Type.valueOf(words[4].toUpperCase()));
            g.setBackWood(Guitar.Wood.valueOf(words[5].toUpperCase()));
            g.setTopWood(Guitar.Wood.valueOf(words[6].toUpperCase()));

            result.add(g);
        }
        return result;
    }

    public static Guitar getGuitar(String serialNumber) throws IOException{
        Guitar result = null;
        List<Guitar> guitars = findAll();
        for (Guitar data : guitars){
            if (data.getSerialNumber().equals(serialNumber)){
                result = data;
            }
        }
        return result;
    }

    public static List<Guitar> search(Guitar guitar) throws IOException{
        List<Guitar> results = new ArrayList<>();
        List<Guitar> guitars = findAll();
        for (Guitar data : guitars){
            if (compare(guitar, data)){
                results.add(data);
            }
        }
        return results;
    }

    public static boolean compare(Guitar guitar, Guitar target){

        String serialNumber = guitar.getSerialNumber();
        double price = guitar.getPrice();
        String builder = guitar.getBuilder();
        String model = guitar.getModel();
        String type = guitar.getType();
        String backWood = guitar.getBackWood();
        String topWood = guitar.getTopWood();

        if (serialNumber == null && builder == null && model == null && type == null && backWood == null && topWood == null && price == 0){
            return false;
        }

        if (serialNumber != null){
            if (!(serialNumber.equals(target.getSerialNumber()))){
                return false;
            }}
        if (price != 0){
            if (!(price == target.getPrice())){
                return false;
            }}
        if (builder != null){
            if (!(builder.equals(target.getBuilder()))){
                return false;
            }}
        if (model != null){
            if (!(model.equals(target.getModel()))){
                return false;
            }}
        if (type != null){
            if (!(type.equals(target.getType()))){
                return false;
            }}
        if (backWood != null){
            if (!(backWood.equals(target.getBackWood()))){
                return false;
            }}
        if (topWood != null){
            if (!(topWood.equals(target.getTopWood()))){
                return false;
            }}

        return true;
    }


}