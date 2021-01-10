package com.salestaxesprolem.tests

import com.salestaxesprolem.basketmanagement.BasketItem
import com.salestaxesprolem.basketmanagement.Product
import com.salestaxesprolem.taxmanagement.ImportType
import com.salestaxesprolem.taxmanagement.TaxType

object TestConstants {
    val ONE_BOOK_NOT_IMPORTED = BasketItem(Product("book", 12.49F, TaxType.NO_TAX, ImportType.NOT_IMPORTED), 1)
    val TWO_BOOKS_NOT_IMPORTED = BasketItem(Product("book", 12.49F, TaxType.NO_TAX, ImportType.NOT_IMPORTED), 2)

    val ONE_CHOCOLATE_BAR_NOT_IMPORTED =
        BasketItem(Product("chocolate bar", 0.85F, TaxType.NO_TAX, ImportType.NOT_IMPORTED), 1)

    val ONE_MUSIC_CD_NOT_IMPORTED =
        BasketItem(Product("music CD", 14.99F, TaxType.BASIC_TAX, ImportType.NOT_IMPORTED), 1)
    val TWO_MUSIC_CD_NOT_IMPORTED =
        BasketItem(Product("music CD", 14.99F, TaxType.BASIC_TAX, ImportType.NOT_IMPORTED), 2)

    val ONE_IMPORTED_BOX_OF_CHOCOLATES_AT_10F =
        BasketItem(Product("imported box of chocolates", 10F, TaxType.NO_TAX, ImportType.IMPORTED), 1)
    val THREE_IMPORTED_BOXES_OF_CHOCOLATES_AT_11_25F =
        BasketItem(Product("imported box of chocolates", 11.25F, TaxType.NO_TAX, ImportType.IMPORTED), 3)

    val ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_47_5F =
        BasketItem(Product("imported bottle of perfume", 47.5F, TaxType.BASIC_TAX, ImportType.IMPORTED), 1)
    val ONE_IMPORTED_BOTTLE_OF_PERFUME_AT_27_99F =
        BasketItem(Product("imported bottle of perfume", 27.99F, TaxType.BASIC_TAX, ImportType.IMPORTED), 1)
    val ONE_BOTTLE_OF_PERFUME_NOT_IMPORTED =
        BasketItem(Product("bottle of perfume", 18.99F, TaxType.BASIC_TAX, ImportType.NOT_IMPORTED), 1)

    val ONE_PACKET_OF_HEADACHE_PILLS_NOT_IMPORTED =
        BasketItem(
            Product("packet of headache pills", 9.75F, TaxType.NO_TAX, ImportType.NOT_IMPORTED),
            1
        )
}