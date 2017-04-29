package dataStructures;

import com.sun.javafx.geom.Dimension2D;

import dataStructures.Point;
import enums.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by p4048818 on 20/04/2016.
 */
public class PointUI extends Point {

    private Image imgV;
//    private FrameLayout.LayoutParams lp;
    private Dimension2D lp;
    private Image image; //was a bitmap
    private boolean lockFlag;

    public PointUI(Image iv,Image img, int pixelToDp){
        super();
        imgV = iv;
        image = img;
        lockFlag = false;
        lp.height = (pixelToDp,pixelToDp);
        imgV.setImage(image);
        imgV.setLayoutX(lp.width);
        imgV.setLayoutY(lp.height);
    }



    public ImageView getImgV() {
        return imgV;
    }

    public void setImgV(ImageView imgV) {
        this.imgV = imgV;
    }

    public FrameLayout.LayoutParams getLp() {
        return lp;
    }

    public void setLp(FrameLayout.LayoutParams lp) {
        this.lp = lp;
        this.imgV.setLayoutParams(lp);
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
    @Override
    public int getX(){
        return lp.leftMargin;
    }

    @Override
    public int getY(){
        return lp.topMargin;
    }

    /**
     * Move a point in one of four possible directions.
     *
     * @param dir      A Direction enumeration literal for the intended direction.
     * @param inPixels An integer conversion of the DP point size stored in dimens.xml.
     */
    public void movePoint(Direction dir, float inPixels) {
        FrameLayout.LayoutParams nlp = new FrameLayout.LayoutParams(Math.round(inPixels), Math.round(inPixels));
        nlp.leftMargin = this.getX() + dir.getX();
        nlp.topMargin = this.getY() + dir.getY();
        setLp(nlp);
    }

    public void setXUI(int xCor){
        lp.leftMargin = xCor;
    }

    public void setYUI(int yCor){
        lp.topMargin = yCor;
    }

    public boolean getLockedFlag() {
        return lockFlag;
    }

    public void setLockedFlag(boolean lockFlag) {
        this.lockFlag = lockFlag;
    }
}