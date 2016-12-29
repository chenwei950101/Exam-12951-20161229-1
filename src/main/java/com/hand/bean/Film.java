package com.hand.bean;

/**
 * Created by 陈伟 on 2016/12/29.
 */
public class Film {
    private int language_id;
    private String title;
    private String desciption;
   public Film(){

   }
    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return desciption;
    }

    public void setDescription(String desciption) {
        this.desciption = desciption;
    }
}
