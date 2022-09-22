package com.app.acmedelivery.domainModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Setter
@Getter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_ITEMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERITEM_SEQ", allocationSize = 1)
public class OrderItem extends BaseModel{


    @ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private Order order;

	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER)
    @JsonInclude
	private Product product;

    @Column(nullable = false)
    @NotNull
	@JsonInclude
    private Integer quantity;

    @Column
    @NotNull
	@JsonInclude
    private BigDecimal price;
}
