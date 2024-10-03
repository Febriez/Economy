package com.coffeetory.economy.command;

import com.coffeetory.economy.api.Economy;
import com.coffeetory.lib.format.MessageFormat;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {

    private static final TextComponent PREFIX = Component.text("§f§l[ §a§l소지금 §f§l]§r ");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            if (!sender.isOp()) return false;
            sender.sendMessage(Component.text("§f§l========== [ §a§l돈 명령어 §f§l] =========="));
            sender.sendMessage(Component.text("/돈 확인 <닉네임>"));
            sender.sendMessage(Component.text("/돈 설정 <닉네임> <액수>"));
            sender.sendMessage(Component.text("/돈 전체초기화"));
            return true;
        }
        Economy eco = new Economy(p.getUniqueId());
        if (args.length == 0) {
            p.sendMessage(PREFIX.append(Component.text("§e§l" + MessageFormat.m(eco.getBalance()).replaceAll(",", "§f§l,§e§l") + " §f§l원")));
            return true;
        }
        return false;
    }
}
