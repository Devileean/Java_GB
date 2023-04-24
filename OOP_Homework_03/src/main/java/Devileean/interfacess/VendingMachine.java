package Devileean.interfacess;

import Devileean.model.Product;

public interface VendingMachine {
    Product getProduct(String name) throws IllegalStateException;
}
