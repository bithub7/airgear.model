package com.airgear.model;

import com.airgear.model.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "settlement", nullable = false)
    private String settlement;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(unique = true)
    private Integer uniqueSettlementID;

    @Enumerated(EnumType.STRING)
    private SettlementType settlementType;

    public Location(String settlement, Region region) {
        this.settlement = settlement;
        this.region = region;
    }
}
