package io.deoki.blog.entity.composite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Composite value class for address mapping
 * used in User entity.
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
