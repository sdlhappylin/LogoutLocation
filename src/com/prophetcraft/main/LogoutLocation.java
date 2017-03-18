package com.prophetcraft.main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.User;
import com.earth2me.essentials.spawn.SpawnStorage;

import net.ess3.api.IEssentials;

public class LogoutLocation extends JavaPlugin implements Listener{

	private IEssentials ess;
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("LogoutLocation���������");
		ess = ((IEssentials)getServer().getPluginManager().getPlugin("Essentials"));
	}
	public void onDisable(){
		getLogger().info("LogoutLocation�����ж��");
		ess.onDisable();
	}
	
	//����������
	@EventHandler
	public void getPlayerLogout(PlayerQuitEvent quit){
		Location location =null;
		Player p = quit.getPlayer();
		String player = p.getName();
		if(ess!=null){
		getLogger().info("ʹ����EssentialSpawn�ĳ�����");
		SpawnStorage spawn = new SpawnStorage(ess);
		User user =  ess.getUser(player);
		location = spawn.getSpawn(user.getGroup());
		}else{
			getLogger().info("ʹ����Word�ĳ�����");
			location = getServer().getWorld("world").getSpawnLocation();
		}
		p.teleport(location);
	}
}
