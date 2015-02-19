/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author nUll
 */
public class TypeUserModel {

    private int id;
    private String name;
    private String frames;

    public TypeUserModel(String type, String frames) {

        this.name = type;
        this.frames = frames;
        System.out.println(frames);
    }

    public TypeUserModel(int id, String type, String frames) {
        this.id = id;
        this.name = type;
        this.frames = frames;
    }

    public TypeUserModel() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the frames
     */
    public String getFrames() {
        return frames;
    }

    /**
     * @param frames the frames to set
     */
    public void setFrames(String frames) {
        this.frames = frames;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        TypeUserModel typeUser = (TypeUserModel) obj;
        if (this.id == typeUser.id) {
            return true;
        }
        return false;
    }

}
