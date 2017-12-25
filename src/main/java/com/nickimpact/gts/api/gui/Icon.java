package com.nickimpact.gts.api.gui;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.item.inventory.AffectSlotEvent;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;

import javax.crypto.Cipher;
import java.util.*;
import java.util.function.Consumer;

public class Icon {

    private int slot;
    private ItemStack display;
    private Set<Consumer<Clickable>> listeners;

    public Icon(int slot, ItemStack display) {
        this.slot = slot;
        this.display = display;
        this.listeners = new HashSet<>();
    }

    /**
     * Returns the slot of this icon.
     *
     * @return The slot of this icon
     */
    public int getSlot() {
        return this.slot;
    }

    /**
     * Sets the slot of this icon
     *
     * @param slot The slot to apply to the icon
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }

    /**
     * Returns the ItemStack display of the icon
     *
     * @return The ItemStack representation for the icon
     */
    public ItemStack getDisplay() {
        return this.display;
    }

    /**
     * Sets the ItemStack of this icon
     *
     * @param display The ItemStack to apply to the icon
     */
    public void setDisplay(ItemStack display) {
        this.display = display;
    }

    /**
     * Returns a copy of all listeners attached to this icon
     *
     * @return A set of consumers detailing the listening aspects of the UI icon
     */
    public Set<Consumer<Clickable>> getListeners() {
        return this.listeners;
    }

    /**
     * Appends a listener to an icon
     *
     * @param listener The consuming action to run
     */
    public void addListener(Consumer<Clickable> listener) {
        this.listeners.add(listener);
    }

	/**
	 * Attempts to run each listener attached to the icon
	 *
	 * @param clickable The clickable wrapper with the player and event
	 */
	public void process(Clickable clickable) {
    	for(Consumer<Clickable> listener : listeners)
    		listener.accept(clickable);
    }
}
