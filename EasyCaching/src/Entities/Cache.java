/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author PAVM
 */
public class Cache {
    private int id;
    private String name;
    private String desc;
    private String hint;
    private float diff;
    private float size;
    private float terrain;
    private String owner;
    private float latitude;
    private float longitude;
   
    
    public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Cache(){}

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getDiff() {
        return diff;
    }

    public void setDiff(float diff) {
        this.diff = diff;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getTerrain() {
        return terrain;
    }

    public void setTerrain(float terrain) {
        this.terrain = terrain;
    }
    
    
}
