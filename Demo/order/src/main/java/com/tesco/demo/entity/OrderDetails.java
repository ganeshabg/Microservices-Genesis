package com.tesco.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderDetails implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`product_id`")
    private int productId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "`order_id`", nullable = false)
    private Order order;


}
