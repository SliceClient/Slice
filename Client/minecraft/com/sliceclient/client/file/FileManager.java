package com.sliceclient.client.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sliceclient.client.manager.Manager;

public class FileManager extends Manager<MFile> {

    public FileManager() {
        super(new ArrayList<>());
    }

    @Override
    public void onCreated() {
        this.getList().forEach(MFile::load);
    }

    public void writeFile(MFile file, String contents) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Slice/" + file.getName()));
        bufferedWriter.write(contents);
        bufferedWriter.close();
    }

    public List<String> loadFileContents(MFile file) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Slice/" + file.getName()));
        return bufferedReader.lines().collect(Collectors.toCollection(ArrayList::new));
    }

    public BufferedReader getBufferedReaderForFile(MFile file) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Slice/" + file.getName()));
        return bufferedReader;
    }

    public BufferedReader initializeFile(MFile file) {
        try {
            return getBufferedReaderForFile(file);
        }
        catch (Exception e) {
            return null;
        }
    }
}
