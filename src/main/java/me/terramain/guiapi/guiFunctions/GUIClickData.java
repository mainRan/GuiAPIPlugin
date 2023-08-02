package me.terramain.guiapi.guiFunctions;

import org.bukkit.entity.Player;

public class GUIClickData {
    private int slot;
    private int rawSlot;
    private boolean ofInventory;
    private ClickType clickType;
    private Player player;

    public GUIClickData(int slot, int rawSlot, boolean ofInventory, ClickType clickType, Player player) {
        this.slot = slot;
        this.rawSlot = rawSlot;
        this.ofInventory = ofInventory;
        this.clickType = clickType;
        this.player = player;
    }

    public int getSlot() {return slot;}
    public int getRawSlot() {return rawSlot;}
    public boolean isOfInventory() {return ofInventory;}
    public ClickType getClickType() {return clickType;}
    public Player getPlayer() {return player;}
}
