package com.coders.helpers;

import com.coders.domain.Cart;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class FakeCartFactoryGenerator {
    private PodamFactory factory = new PodamFactoryImpl();

    public Cart generateFakeCart() {
        return factory.manufacturePojo(Cart.class);
    }
}
