package io.deoki.blog.entity.composite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * This is a composite value class that represents the address in Account Entity class.
 * @author deoki
 * @version 1.0
 */
@Embeddable
@Setter
@Getter
public class Address {
    private String country;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
