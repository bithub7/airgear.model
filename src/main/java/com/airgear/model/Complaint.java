package com.airgear.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "complaint_category_id", referencedColumnName = "id")
    private ComplaintCategory complaintCategory;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    @Column(name = "description")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 1000, message = "Description length must be between 10 and 1000 characters")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

}