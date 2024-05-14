package com.kosta.sample.json;

public class DataVO {
	private Element[] elements;
    private int total_count;
    private String after_url;
    private String result_id;
    private int favorite_count;

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getAfter_url() {
        return after_url;
    }

    public void setAfter_url(String after_url) {
        this.after_url = after_url;
    }

    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }
}
