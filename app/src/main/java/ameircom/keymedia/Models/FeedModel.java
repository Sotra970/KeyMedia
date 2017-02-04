package ameircom.keymedia.Models;

import java.io.Serializable;

/**
 * Created by sotra on 2/4/2017.
 */
public class FeedModel implements Serializable {
    String text ;
    int img ;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
