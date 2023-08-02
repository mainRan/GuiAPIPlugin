package me.terramain.guiapi;

import me.terramain.guiapi.guiFunctions.GUIClickFunction;
import me.terramain.guiapi.guiFunctions.GUICloseFunction;
import me.terramain.guiapi.guiFunctions.GUIFunction;
import me.terramain.guiapi.guiFunctions.GUIOpenFunction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class GUI {
    private final GUIType guiType;

    protected GUIClickFunction guiClickFunction;
    protected GUICloseFunction guiCloseFunction;
    protected GUIOpenFunction guiOpenFunction;

    protected Inventory inventory;


    public GUI(GUIType guiType){
        this.guiType=guiType;

        this.guiClickFunction = (gui, guiClickData) -> {return false;};
        this.guiCloseFunction = (gui, player) -> {};
        this.guiOpenFunction = (gui, player) -> {};

        if (guiType.isChest) this.inventory = Bukkit.createInventory(null,guiType.slots);
        else this.inventory = Bukkit.createInventory(null,guiType.inventoryType);
    }
    public GUI(GUIType guiType, GUIFunction guiFunction){
        this.guiType=guiType;

        this.guiClickFunction=(GUIClickFunction) guiFunction;
        this.guiCloseFunction=(GUICloseFunction) guiFunction;
        this.guiOpenFunction=(GUIOpenFunction) guiFunction;
    }
    public GUI(GUIType guiType, GUIClickFunction guiClickFunction, GUICloseFunction guiCloseFunction, GUIOpenFunction guiOpenFunction){
        this.guiType=guiType;

        this.guiClickFunction=guiClickFunction;
        this.guiCloseFunction=guiCloseFunction;
        this.guiOpenFunction=guiOpenFunction;
    }


    public GUIType getGuiType(){return guiType;}

    public void setFunctions(GUIFunction guiFunction){
        this.guiClickFunction=(GUIClickFunction) guiFunction;
        this.guiCloseFunction=(GUICloseFunction) guiFunction;
        this.guiOpenFunction=(GUIOpenFunction) guiFunction;
    }
    public void setGuiClickFunction(GUIClickFunction guiClickFunction) {this.guiClickFunction = guiClickFunction;}
    public void setGuiCloseFunction(GUICloseFunction guiCloseFunction) {this.guiCloseFunction = guiCloseFunction;}
    public void setGuiOpenFunction(GUIOpenFunction guiOpenFunction) {this.guiOpenFunction = guiOpenFunction;}
    public Inventory getInventory() {return inventory;}

    public void setItem(int slot, ItemStack itemStack){
        inventory.setItem(slot,itemStack);
    }
    public void setItem(int slotLine, int slotColumn, ItemStack itemStack){
        inventory.setItem((slotLine-1)*9 + slotColumn + 1,itemStack);
    }

    public ItemStack getItem(int slot){
        return inventory.getItem(slot);
    }
    public ItemStack getItem(int slotLine, int slotColumn){
        return inventory.getItem(slotColumn*slotLine-1);
    }



    public void openToPlayer(Player player){
        player.openInventory(inventory);
    }


}
