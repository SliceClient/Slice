package com.sliceclient.client.file.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sliceclient.client.Client;
import com.sliceclient.client.file.FileManager;
import com.sliceclient.client.file.MFile;
import com.sliceclient.client.module.impl.render.Search;

import net.minecraft.block.Block;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class SearchBlocksFile extends MFile {

    public SearchBlocksFile() {
        super("SearchBlocks.json");
    }

    public void load() {
        FileManager fileManager = Client.INSTANCE.getFileManager();
        BufferedReader fileContents = null;
        try {
            fileContents = fileManager.getBufferedReaderForFile(this);
        } catch (FileNotFoundException e) {
            fileContents = fileManager.initializeFile(this);
        }
        if (fileContents.lines().count() == 0) return;
        Search search = (Search) Client.INSTANCE.getModuleManager().get(Search.class);
        final JsonObject json = (JsonObject) new JsonParser().parse(fileContents);
        for (final Map.Entry<String, JsonElement> entry : json.entrySet()) {
            String blockToAdd = entry.getKey();
            Block block = Block.getBlockFromName(blockToAdd);
            search.searchList.add(block);
        }
    }

    public void save() {
        FileManager fileManager = Client.INSTANCE.getFileManager();

        final JsonObject json = new JsonObject();
        Search search = (Search) Client.INSTANCE.getModuleManager().get(Search.class);
        for (final Block block : search.searchList) {
            int id = block.getIdFromBlock(block);
            String idString = String.valueOf(id);


            json.addProperty(idString, true);
        }

        try {
            fileManager.writeFile(this, json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
