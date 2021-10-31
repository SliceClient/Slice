package com.sliceclient.client.module.impl.misc;

import com.google.common.eventbus.Subscribe;
import com.sliceclient.client.Client;
import com.sliceclient.client.event.impl.PacketEvent;
import com.sliceclient.client.event.impl.enums.PacketDirection;
import com.sliceclient.client.module.Module;
import com.sliceclient.client.module.annotations.ModuleData;
import com.sliceclient.client.module.enums.ModuleCategory;

import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

@ModuleData(name = "Name Protect", category = ModuleCategory.MISC)
public class NameProtect extends Module {

    public static boolean isEnabled() {
        return Client.INSTANCE.getModuleManager().get(NameProtect.class).isToggled();
    }

    public static String getProtectedName() {
        return "Slicer";
    }

    @Subscribe
    public void onPacket(PacketEvent packetEvent) {
        if (packetEvent.getPacketDirection() == PacketDirection.INBOUND) {
            if (packetEvent.getPacket() instanceof S02PacketChat) {
                S02PacketChat chat = (S02PacketChat) packetEvent.getPacket();
                IChatComponent chatComponent = chat.func_148915_c();
                if (chatComponent instanceof ChatComponentText && chat.isChat()) {
                    String text = chatComponent.getFormattedText().replace(mc.thePlayer.getName(), getProtectedName());
                    packetEvent.setPacket(new S02PacketChat(new ChatComponentText(text)));
                }
            }
        }
    }

    @Override
    public void setup() {

    }
}
