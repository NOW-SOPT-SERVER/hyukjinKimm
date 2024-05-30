package clone.carrot.controller;

import clone.carrot.doamin.dto.ItemCreateRequestDto;
import clone.carrot.doamin.dto.ItemFindDto;
import clone.carrot.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<String> createItem(
            @RequestHeader(value = "memberId") Long memberId,
            @RequestBody ItemCreateRequestDto itemCreateRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.create(memberId, itemCreateRequestDto));
    }


    @GetMapping("/item/{cityName}")
    public ResponseEntity<List> findItemByCityName(@PathVariable("cityName") String cityName) {
        return ResponseEntity.ok(itemService.findItemByCity(cityName));
    }


}
