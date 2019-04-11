package io.deoki.blog.entity.composite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
