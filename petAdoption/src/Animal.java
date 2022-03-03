public class Animal {
    private long id;
    private String name;
    private String type;
    private String gender;
    private long zip;


    public Animal(long id, String name, String type, String gender, long zip) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.zip = zip;
    }

    //Getters for values stored
    public long getID() { 
        return id;
    }
    public String getName() { 
        return name;
    }
    public String getType() { 
        return type;
    }
    public String getGender() { 
        return gender;
    }
    public long getZip() { 
        return zip;
    }
    //Setters for the values.
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setZip(long zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return ("ID: " + id + " Name: " + name + " Type: " + type + 
                " Gender: " + gender + " Zipcode: " + zip);
    }
}
