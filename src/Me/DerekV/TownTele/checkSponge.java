package Me.DerekV.TownTele;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class checkSponge implements Listener{

	TownTele plugin;
	 
	public checkSponge(TownTele instance) {
	plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onClick(BlockBreakEvent e){
		
		Player player = e.getPlayer();
		if(e.getBlock().getType() == Material.SPONGE){
			
			int X = e.getBlock().getX();
			int Y = e.getBlock().getY() + 1;
			int Z = e.getBlock().getZ();
			String cords = Integer.toString(X) + " " + Integer.toString(Y) + " " + Integer.toString(Z) + " " + player.getLocation().getWorld().getName();
		 	
		 	
		 	
		 	for(String key : plugin.getConfig().getKeys(true)){

		 		if(plugin.getConfig().getString(key).equals(cords)){
			        String string = key;
			        System.out.println("last character: " +
			        string.substring(string.length() - 1)); 
			        
					if(string.substring(string.length() - 1).equals("2")){
					String s = key;
					String var = "1";
					s = s.replaceAll("2", var);
					player.sendMessage(ChatColor.RED + "Teleported to... " + plugin.getConfig().getString(s) );
					
					String[] thing = plugin.getConfig().getString(s).split(" ");
					
					World world = Bukkit.getWorld(thing[3]);
					
					Location location = new Location(world, Integer.parseInt(thing[0]), Integer.parseInt(thing[1]), Integer.parseInt(thing[2]));
					player.teleport(location.add(0.5, 0.5, 0.5));
					
					} else if(string.substring(string.length() - 1).equals("1")){
						String s = key;
						String var = "2";
						s = s.replaceAll("1", var);
						player.sendMessage(ChatColor.RED + "Teleported to... " + plugin.getConfig().getString(s) );
						
						String[] thing = plugin.getConfig().getString(s).split(" ");
						
						World world = Bukkit.getWorld(thing[3]);
						Location location = new Location(world, Integer.parseInt(thing[0]), Integer.parseInt(thing[1]), Integer.parseInt(thing[2]));
						player.teleport(location.add(0.5, 0.5, 0.5));
						
					
					}
					
					
					
					
					
					e.setCancelled(true);
					break;
					
				}

		 	}
		 	
		 	
		}
	}
	
	
	
}
