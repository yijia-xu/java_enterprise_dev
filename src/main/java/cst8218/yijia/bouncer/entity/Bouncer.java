
package cst8218.yijia.bouncer.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bouncer Entity Class to represent a bouncer object, including properties and
 * methods to control update bouncer's state.
 * @author Yijia
 */
@Entity
@Table (name = "Bouncer")
@XmlRootElement
public class Bouncer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer xPosition;
    private Integer yPosition;
    private Integer yVelocity;
    public static final int GRAVITY_ACCEL = 1;
    public static final int FRAME_HEIGHT = 600;
    public static final int FRAME_WIDTH = 400;
    public static final int DECAY_RATE = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * retrieve bouncer's x position
     * @return xPosion - bouncer's position at x-axis
     */
    public Integer getxPosition() {
        return xPosition;
    }

    /**
     * set bouncer's x position
     * @param xPosition bouncer's position at x-axis
     */
    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }
    
    /**
     * retrieve bouncer's y position
     * @return xPosion - bouncer's position at y-axis
     */
    public Integer getyPosition() {
        return yPosition;
    }

    /**
     * set bouncer's y position
     * @param yPosition bouncer's position at y-axis
     */
    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }
 
    /**
     * retrieve bouncer's velocity in y-axis
     * @return velocity in y-axis
     */
    public Integer getyVelocity() {
        return yVelocity;
    }

    /**
     *  bouncer's velocity in y-axis
     * @param yVelocity velocity in y-axis
     */
    public void setyVelocity(Integer yVelocity) {
        this.yVelocity = yVelocity;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bouncer)) {
            return false;
        }
        Bouncer other = (Bouncer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.yijia.bouncer.Bouncer[ id=" + id + " ]";
    }
    
    /**
    * Changes bouncer's properties each advancing of frame.
    */
    public void advanceOneFrame() {
        //insert code that implements the last four bullets above
        yPosition += yVelocity;

        if (yPosition < 0) {
            // jf the bouncer hits the ceiling, reverse its velocity and apply decay
            yPosition = 0;
            yVelocity = -yVelocity - DECAY_RATE;
        } else if (yPosition > FRAME_HEIGHT) {
            // if the bouncer hits the ground , reverse its velocity and apply decay
            yPosition = FRAME_HEIGHT;
            yVelocity = -yVelocity + DECAY_RATE;
        } else {
            // add gravity acceleration to y-velocity
            yVelocity += GRAVITY_ACCEL;
        }       
    }

    /**
     * Updates the old bouncer's properties by new non-null properties 
     * the user posted.
     * 
     * @param newBouncer new bouncer object
     */
    public void updateBouncer(Bouncer newBouncer) {
        if (newBouncer.getxPosition() != null) {
            this.setyPosition(newBouncer.getxPosition());
        }
        if (newBouncer.getyPosition() != null) {
            this.setyPosition(newBouncer.getyPosition());
        }
        if (newBouncer.getyVelocity() != null) {
            this.setyVelocity(newBouncer.getyVelocity());
        }
    }
   
}
