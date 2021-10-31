package com.sliceclient.client.util.impl.networking;

import com.sliceclient.client.util.Util;


import net.minecraft.network.Packet;

public class PacketUtil implements Util {

    public static void sendPacket(Packet packet) {
        mc.getNetHandler().addToSendQueue(packet);
    }

    public static void sendPacketNoEvent(Packet packet) {
        mc.getNetHandler().getNetworkManager().sendPacket(packet);
    }

}
