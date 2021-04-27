package int221.project.services;

import java.text.DecimalFormat;

public class UUIDGenerator {
    public String Generate(String type, int id) {
        DecimalFormat myFormatter = new DecimalFormat("0");
        String newId = myFormatter.format(id + 1);
        return type + newId;
    }

}