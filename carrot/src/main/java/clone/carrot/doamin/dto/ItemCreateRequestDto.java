package clone.carrot.doamin.dto;

import org.springframework.web.multipart.MultipartFile;

public record ItemCreateRequestDto(
        String title,
        int price,
        String description,
        String city,

        String status,

        MultipartFile image

) {
}
