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

    private ImageView imgV;
//    private FrameLayout.LayoutParams dimensions;
    private Dimension2D dimensions;
    private Image image; //was a bitmap
    private boolean lockFlag;

    public PointUI(ImageView iv,Image img, float pixelToDp){
        super();
        imgV = iv;
        image = img;
        lockFlag = false;
        
        dimensions.height = 1;
        imgV.setImage(img);
        imgV.setLayoutX(dimensions.width);
        imgV.setLayoutY(dimensions.height);
    }



    public ImageView getImgV() {
        return imgV;
    }

    public void setImgV(ImageView imgV) {
        this.imgV = imgV;
    }

    public Dimension2D getdimensions() {
        return dimensions;
    }

    public void setdimensions(Dimension2D dimensions) {
    	  
    	this.dimensions = dimensions;
        this.imgV.setLayoutX(dimensions.width);
        this.imgV.setLayoutY(dimensions.height);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    @Override
    public int getX(){
        return 	Math.round(dimensions.width);
    }

    @Override
    public int getY(){
        return Math.round(dimensions.height);
    }

    /**
     * Move a point in one of four possible directions.
     *
     * @param dir      A Direction enumeration literal for the intended direction.
     * @param inPixels An integer conversion of the DP point size stored in dimens.xml.
     */
    public void movePoint(Direction dir, float inPixels) {
        Dimension2D ndimensions = new Dimension2D(Math.round(inPixels), Math.round(inPixels));
        ndimensions.width = this.getX() + dir.getX();
        ndimensions.height = this.getY() + dir.getY();
        setdimensions(ndimensions);
    }

    public void setXUI(int xCor){
        dimensions.width = xCor;
    }

    public void setYUI(int yCor){
        dimensions.height = yCor;
    }

    public boolean getLockedFlag() {
        return lockFlag;
    }

    public void setLockedFlag(boolean lockFlag) {
        this.lockFlag = lockFlag;
    }
}