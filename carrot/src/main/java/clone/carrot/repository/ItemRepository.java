package clone.carrot.repository;

import clone.carrot.doamin.City;
import clone.carrot.doamin.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository  extends JpaRepository<Item, Long> {
    List<Item> findByCity(City city);
}
