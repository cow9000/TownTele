package Me.DerekV.TownTele;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TownTele extends JavaPlugin{
	public static TownTele plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final checkSponge cs = new checkSponge(this);
	
	
	@Override
	public void onDisable(){
		this.logger.info("TownTele has been disabled.");
		
	}
	
	@Override
	public void onEnable(){
		this.logger.info("TownTele has been Enabled.");
		getConfig().options().copyDefaults(true);
		saveConfig();
		PluginManager pm = getServer().getPluginManager();
		//pm.registerEvents(this.thing, this);
		pm.registerEvents(this.cs, this);
		
		
	}
	
	
	
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("tt")){
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "/tt settele [telename] [1 or 2]");
				player.sendMessage(ChatColor.RED + "Example /tt settele cows 1, /tt settele cows 2");
			}else
			{
				if(args[0].equalsIgnoreCase("settele")){
					if (args.length == 1){
						player.sendMessage(ChatColor.RED + "/tt settele [telename] [1 or 2]");
						player.sendMessage(ChatColor.RED + "Example /tt settele cows 1, /tt settele cows 2");
					}
					else if(args.length >= 2){
						if(args[2].equals("1")){
							if (player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.SPONGE){
								if(this.getConfig().contains(args[1] + "1")){
									player.sendMessage(args[1] + "Already exists");
								}else{
									player.sendMessage(ChatColor.GREEN + "Location of " + args[1] + " 1 has been set");
									this.getConfig().set(player.getName() + ".Location." + args[1] + "1", player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ() + " " + player.getLocation().getWorld().getName());
									this.saveConfig();
								}
								}else{
				            	player.sendMessage(ChatColor.RED + "You need to be standing a sponge!");
				            }
						}else if(args[2].equals("2")){
							if (player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.SPONGE){
								if(this.getConfig().contains(args[1] + "2")){
									player.sendMessage(args[1] + "Already exists");
								}else{
								player.sendMessage(ChatColor.GREEN + "Location of " + args[1] + " 2 has been set");
								this.getConfig().set(player.getName() + ".Location." + args[1] + "2", player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ() + " " + player.getLocation().getWorld().getName());
								this.saveConfig();
								}
				            }else{
				            	player.sendMessage(ChatColor.RED + "You need to be standing a sponge!");
				            }
						}else{
							player.sendMessage(ChatColor.RED + "/tt settele [telename] [1 or 2]");
							player.sendMessage(ChatColor.RED + "Example /tt settele cows 1, /tt settele cows 2");
						}
						
					}
				}
			}
			
			
		}
		
		
		return false;
	}
	
}
