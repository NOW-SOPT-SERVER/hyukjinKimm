package org.sopt.practice.repository;

import org.sopt.practice.domain.Item;
import org.sopt.practice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


}
