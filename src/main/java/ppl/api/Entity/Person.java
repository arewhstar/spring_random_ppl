package ppl.api.Entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import lombok.*;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = OffsetDateTime.now();
    }

    // Getters and Setters (you can generate them)
}