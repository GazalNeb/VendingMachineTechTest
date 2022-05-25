package com.nology;

public interface IVendingMachine {

    void buy(Product product);
    void refill(Product product);
    void stock();
}
