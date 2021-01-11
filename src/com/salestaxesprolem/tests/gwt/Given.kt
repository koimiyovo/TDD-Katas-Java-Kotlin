package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.basketmanagement.Item

var basket = Basket(emptyList())

class Given(vararg items: Item)
{
    init
    {
        basket = Basket(items.toList())
    }
}
