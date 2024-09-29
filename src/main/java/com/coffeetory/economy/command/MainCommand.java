package com.coffeetory.economy.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
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
        return false;
    }
}
