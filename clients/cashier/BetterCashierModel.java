package clients.cashier;

import catalogue.Basket;
import catalogue.BetterBasket;
import middle.MiddleFactory;

public class BetterCashierModel extends CashierModel {

    @Override
    public Basket makeBasket() {return new BetterBasket();}



    /**
     * Construct the model of the Cashier
     *
     * @param mf The factory to create the connection objects
     */
    public BetterCashierModel(MiddleFactory mf) {
        super(mf);
    }
}
