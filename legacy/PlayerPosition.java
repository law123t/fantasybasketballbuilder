package matc.madjava.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity (name="player_position")
@Table(name = "player_position")
public class PlayerPosition {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "playerposition_id")
    private int playerPositionID;

    @Column(name = "position_name")
    private String positionName;

    public PlayerPosition(int playerPositionID, String positionName){
        this.playerPositionID = playerPositionID;
        this.positionName = positionName;
    }

    public PlayerPosition () {}

    public int getPlayerPositionID() {
        return playerPositionID;
    }

    public void setPlayerPositionID(int playerPositionID) {
        this.playerPositionID = playerPositionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString(){
        return "PlayerPosition{" +
                "playerPositionID='" + playerPositionID + '\'' +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
