package com.app.acmedelivery.domainModel;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@ToString
@SuperBuilder
public class Catalog extends BaseModel{
   private List<Product> catalog;
}
