package com.salestaxesprolem.tests.gwt

import com.salestaxesprolem.basketmanagement.Basket
import com.salestaxesprolem.basketmanagement.Item
import java.util.Collections.emptyList

var basket = Basket(emptyList())

object Given
{
    fun basket(vararg items: Item)
    {
        basket = Basket(items.toList())
    }
}
