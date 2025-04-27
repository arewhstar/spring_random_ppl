package ppl.api.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {


    private Long id;
    @Column(name = "request_time", nullable = false)
    private OffsetDateTime requestTime = OffsetDateTime.now();
    private String request;
    private String response;
}