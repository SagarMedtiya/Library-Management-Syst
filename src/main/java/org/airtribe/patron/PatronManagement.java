package org.airtribe.patron;

import java.util.HashMap;
import java.util.Map;

public class PatronManagement {
    private Map<String, Patron> patrons;
    public PatronManagement() {
        this.patrons = new HashMap<>();
    }
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }
    public void updatePatron(String id, Patron updatedPatron){
        if (patrons.containsKey(id)){
            patrons.put(id, updatedPatron);
        }
    }
    public Patron getPatron(String id) {
        return patrons.get(id);
    }
}
