package com.coffeetory.economy.command;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdminCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if (!sender.isOp()) return false;
        if (args.length == 0) {
            say(sender, "§f§l========== [ §a§l돈 명령어 §f§l] ==========");
            say(sender, "/돈 확인 <닉네임>");
            say(sender, "/돈 설정 <닉네임> <액수>");
            say(sender, "/돈 전체초기화");
            return true;
        }
        return false;
    }

    private void say(@NotNull Audience to, String s) {
        to.sendMessage(Component.text(s));
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of();
    }
}
