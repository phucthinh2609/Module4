package com.mvpt.model.dto;

import com.mvpt.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductDTO {

    private Long id;
    @NotBlank(message = "Product Name is required")
    private String title;

    @NotBlank(message = "Sku is required")
    private String sku;

    private String urlImage;
    private String description;

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setSku(sku)
                .setUrlImage(urlImage)
                .setDescription(description);
    }
}
