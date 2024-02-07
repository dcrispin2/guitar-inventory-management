package dcrispin.iu.c322spring2024homework2.repository;

import dcrispin.iu.c322spring2024homework2.model.Guitar;
import org.junit.jupiter.api.Test;
import dcrispin.iu.c322spring2024homework2.repository.InventoryRepository;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitarTest() throws IOException {
        Guitar test = new Guitar();
        test.setSerialNumber("1111");
        test.setPrice(10.00);
        test.setBuilder(Guitar.Builder.valueOf("FENDER"));
        test.setModel("Strato");
        test.setType(Guitar.Type.valueOf("ELECTRIC"));
        test.setBackWood(Guitar.Wood.valueOf("MAPLE"));
        test.setTopWood(Guitar.Wood.valueOf("MAPLE"));
        InventoryRepository.addGuitar(test);

        Guitar test1 = new Guitar();
        test1.setSerialNumber("1234");
        test1.setPrice(10.00);
        test1.setBuilder(Guitar.Builder.valueOf("FENDER"));
        test1.setModel("Strato");
        test1.setType(Guitar.Type.valueOf("ACOUSTIC"));
        test1.setBackWood(Guitar.Wood.valueOf("MAHOGANY"));
        test1.setTopWood(Guitar.Wood.valueOf("MAHOGANY"));
        InventoryRepository.addGuitar(test1);

        //System.out.println(test);
        //System.out.println(InventoryRepository.getGuitar("1111"));

        //Not sure how to unit test for this one
    }

    @Test
    void getGuitarTest() throws IOException {
        Guitar gt1 = InventoryRepository.getGuitar("1111");
        Guitar gt2 = InventoryRepository.getGuitar("1234");

        assert (gt1.getSerialNumber().equals("1111"));
        assert (gt2.getBackWood().equals("Mahogany"));
        //assert (InventoryRepository.getGuitar("1111").equals(test));
        //assert (InventoryRepository.getGuitar("1234").equals(test1));
    }

    @Test
    void searchTest() throws IOException {
        Guitar gt1 = new Guitar();

        gt1.setBuilder(Guitar.Builder.valueOf("FENDER"));
        gt1.setPrice(10.00);

        List<Guitar> testList = InventoryRepository.search(gt1);
        assert(testList.get(0).getSerialNumber().equals("1111"));
        assert(testList.get(0).getPrice() == 10.0);
        assert(testList.get(1).getBackWood().equals("Mahogany"));
        assert(testList.get(1).getSerialNumber().equals("1234"));
    }
}