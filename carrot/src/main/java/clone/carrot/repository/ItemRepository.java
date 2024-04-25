package clone.carrot.repository;

import clone.carrot.doamin.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Long> {
}
