package fauzi.hilmy.app11;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 26FaUZeE02 on 4/26/18.
 */

public class Quotee {
    @SerializedName("title")
    @Expose
    private String titlee;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("link")
    @Expose
    private String link;

    public String getTitlee() {
        return titlee;
    }

    public void setTitlee(String titlee) {
        this.titlee = titlee;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
