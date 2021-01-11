package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.basketmanagement.Item

var basket = Basket(emptyList())
var ticket = ""

class Given(vararg items: Item)
{
    init
    {
        basket = Basket(items.toList())
    }
}
