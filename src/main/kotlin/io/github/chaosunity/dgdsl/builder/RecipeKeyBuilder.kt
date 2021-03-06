package io.github.chaosunity.dgdsl.builder

import net.minecraft.item.Item
import net.minecraft.item.crafting.Ingredient
import net.minecraft.tags.ITag
import net.minecraft.util.IItemProvider

class RecipeKeyBuilder : AbstractBuilder() {
    private val keyMap = mutableMapOf<Char, Ingredient>()

    infix fun Char.to(item: IItemProvider) {
        keyMap[this] = Ingredient.of(item)
    }

    infix fun Char.to(tag: ITag<Item>) {
        keyMap[this] = Ingredient.of(tag)
    }

    infix fun Char.to(ingredient: Ingredient) {
        keyMap[this] = ingredient
    }

    fun build(): Map<Char, Ingredient> = keyMap
}