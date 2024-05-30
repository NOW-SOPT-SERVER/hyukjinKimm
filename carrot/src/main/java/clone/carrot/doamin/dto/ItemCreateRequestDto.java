package clone.carrot.doamin.dto;

public record ItemCreateRequestDto(
        String title,
        int price,
        String description,
        String city,

        String status
)

{
}
