package org.launchcode.cheesemvc.modles.forms;

import org.launchcode.cheesemvc.modles.forms.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty.")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    //private CheeseType type;

    /*Changing from using an  id to creating a database and letting it use a
    primary key id.

   private int cheeseId;
   private static int nextId = 1;
   */

    public Cheese(String name, String description) {
        //this(); Removed because the constructor below is now a default constructor.
        this.name = name;
        this.description = description;
    }

    public Cheese()
    {
        //cheeseId = nextId;
        //nextId++;
    }

    /*
    We have now made the above a default constructor and we no longer need the
    getter and setter for it.
    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }*/

    public int getId() {
        return id;
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

    /*
    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }*/
}
