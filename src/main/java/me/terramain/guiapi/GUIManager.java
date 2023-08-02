package me.terramain.guiapi;


import me.terramain.guiapi.guiFunctions.ClickType;
import me.terramain.guiapi.guiFunctions.GUIClickData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;


import java.util.ArrayList;
import java.util.List;

public class GUIManager implements Listener {

    private static List<GUI> guiList = new ArrayList<>();
    public static void registerGUI(GUI gui){
        guiList.add(gui);
    }




    @EventHandler
    public void openInventory(InventoryOpenEvent e){
        for (GUI gui : guiList) {
            if (gui.inventory.equals( e.getInventory() )){
                gui.guiOpenFunction.open(gui, (Player) e.getPlayer());
            }
        }
    }
    @EventHandler
    public void closeInventory(InventoryCloseEvent e){
        for (GUI gui : guiList) {
            if (gui.inventory.equals( e.getInventory() )){
                gui.guiCloseFunction.close(gui,(Player) e.getPlayer());
            }
        }
    }
    @EventHandler
    public void clickInventory(InventoryClickEvent e){
        for (GUI gui : guiList) {
            if (gui.inventory.equals( e.getInventory() )){
                System.out.println("slot: " + e.getSlot());
                System.out.println("rawSlot: " + e.getRawSlot());
                System.out.println();

                ClickType clickType = ClickType.getClickType( e.getClick() );
                GUIClickData guiClickData = new GUIClickData(e.getSlot(),e.getRawSlot(), (e.getSlot()!=e.getRawSlot()) ,clickType, (Player) e.getWhoClicked());
                boolean cancel = gui.guiClickFunction.click(gui, guiClickData);
                e.setCancelled(cancel);

                return;
            }
        }
    }




}
