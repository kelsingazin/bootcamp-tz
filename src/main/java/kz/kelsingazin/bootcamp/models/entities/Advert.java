package kz.kelsingazin.bootcamp.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kz.kelsingazin.bootcamp.models.audits.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adverts")
public class Advert extends AuditModel {

    @ManyToOne
    private User sellerId;

    @ManyToOne
    private User buyerId;

    @ManyToOne
    private Product product;
}
