package com.example.ColorAssignment.service;

import com.example.ColorAssignment.model.mymodel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class myservice {

    private final Map<String, mymodel> mymap = new HashMap<>();
    private final Set<String> subscriptions = new HashSet<>();

    public myservice() {
        mymap.put("Sky", new mymodel("Sky", Arrays.asList("Blue", "Black")));
        mymap.put("Apple", new mymodel("Apple", Arrays.asList("Green", "Red")));
        mymap.put("Salt", new mymodel("Salt", Collections.singletonList("White")));
        mymap.put("Blood", new mymodel("Blood", Collections.singletonList("Red")));
        mymap.put("Frog", new mymodel("Frog", Arrays.asList("Blue", "Yellow")));
        mymap.put("Banana", new mymodel("Banana", Arrays.asList("Green", "Yellow")));
        mymap.put("Ink", new mymodel("Ink", Arrays.asList("Red", "Black")));
    }

    String inputName = "Frog"; // change input here and put same in url link or query param.

    public void subscribe(String name) {
        String newName = name.substring(1);
        if (mymap.containsKey(newName)) {
            if (name.startsWith("+")) {
                subscriptions.add(newName);       // subscribe
            }
            else {
                subscriptions.remove(newName);    // unsubscribe
            }
        }
    }

    public Set<String> listSubscriptions() {
        return subscriptions;
    }
    public List<String> notifySubscribers(String color) {
        List<String> notifications = new ArrayList<>();
        for (String subscription : subscriptions) {
            mymodel mymap1 = mymap.get(subscription);
            if (mymap1.getColors().contains(color)) {
                if (mymap1.getName().equals(inputName)) {
                    notifications.add("I'm " + mymap1.getName() + " I am " + color.toLowerCase() + " today.");
                } else {
                    notifications.add("I'm " + mymap1.getName() + "! I'm sometimes " + color.toLowerCase() + "!");
                }
            }
        }
        return notifications;
    }

}
