package vn.edu.hcmuaf.fit.shopzonerestfulapi.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.hcmuaf.fit.shopzonerestfulapi.model.Category;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String SKU;
    private String name;
    private double price;
    private int discount;
    private LocalDate offerEnd;
    private boolean isNew;
    private int rating;
    private int saleCount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Set<Category> category = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> variant = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_image", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private List<String> images;

    private String shortDescription;
    private String fullDescription;
}