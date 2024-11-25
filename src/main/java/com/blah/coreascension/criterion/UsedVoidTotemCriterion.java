//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.blah.coreascension.criterion;

import com.blah.coreascension.CoreAscension;
import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemPredicate.Builder;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class UsedVoidTotemCriterion extends AbstractCriterion<UsedVoidTotemCriterion.Conditions>
{
    static final Identifier ID = new Identifier(CoreAscension.MOD_ID, "used_void_totem");

    public UsedVoidTotemCriterion() {
    }

    public Identifier getId() {
        return ID;
    }

    public Conditions conditionsFromJson(JsonObject jsonObject, LootContextPredicate lootContextPredicate, AdvancementEntityPredicateDeserializer advancementEntityPredicateDeserializer) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(jsonObject.get("item"));
        return new Conditions(lootContextPredicate, itemPredicate);
    }

    public void trigger(ServerPlayerEntity player, ItemStack stack) {
        this.trigger(player, (conditions) -> conditions.matches(stack));
    }

    public static class Conditions extends AbstractCriterionConditions
    {
        private final ItemPredicate item;

        public Conditions(LootContextPredicate player, ItemPredicate item) {
            super(UsedVoidTotemCriterion.ID, player);
            this.item = item;
        }

        public static Conditions create(ItemPredicate itemPredicate) {
            return new Conditions(LootContextPredicate.EMPTY, itemPredicate);
        }

        public static Conditions create(ItemConvertible item) {
            return new Conditions(LootContextPredicate.EMPTY, Builder.create().items(new ItemConvertible[]{item}).build());
        }

        public boolean matches(ItemStack stack) {
            return this.item.test(stack);
        }

        public JsonObject toJson(AdvancementEntityPredicateSerializer predicateSerializer) {
            JsonObject jsonObject = super.toJson(predicateSerializer);
            jsonObject.add("item", this.item.toJson());
            return jsonObject;
        }
    }
}
