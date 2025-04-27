package ppl.api.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_time", nullable = false)
    private OffsetDateTime requestTime = OffsetDateTime.now();

    @Column
    private String request;

    @Column
    private String response;




}