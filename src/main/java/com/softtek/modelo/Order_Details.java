package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order_Details {
    private int orderID;
    private int productID;
    private double unitPrice;
    private int quantity;
    private double discount;
}
