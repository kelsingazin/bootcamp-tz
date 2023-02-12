package kz.kelsingazin.bootcamp.models.entities;

import jakarta.persistence.*;
import kz.kelsingazin.bootcamp.models.audits.AuditModel;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adverts")
public class Advert extends AuditModel {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ended_at", nullable = false, updatable = false)
    @CreatedDate
    private Date endedAt;

    @ManyToOne
    private User sellerId;

    @ManyToOne
    private User buyerId;

    @ManyToOne
    private Product product;
}
