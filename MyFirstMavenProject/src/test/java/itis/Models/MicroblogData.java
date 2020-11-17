package itis.Models;

import java.util.Map;

public class MicroblogData {


    String name;
    String description;


    public MicroblogData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public MicroblogData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

