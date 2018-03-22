package matc.madjava.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity (name="Team")
@Table(name = "user_team")
public class Team {

    @Column(name = "team_name")
    private String teamName;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "team_id")
    private int teamID;

    @ManyToOne
    @JoinColumn(name="pointguard_id")
    private PointGuard pointGuard;

    @ManyToOne
    @JoinColumn(name="shootingguard_id")
    private ShootingGuard shootingGuard;

    @ManyToOne
    @JoinColumn(name="smallforward_id")
    private SmallForward smallForward;

    @ManyToOne
    @JoinColumn(name="powerforward_id")
    private PowerForward powerForward;

    @ManyToOne
    @JoinColumn(name="center_id")
    private Center center;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Team(String teamName, int teamID, PointGuard pointGuard, ShootingGuard shootingGuard, SmallForward smallForward,
                PowerForward powerForward, Center center, User user) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.pointGuard = pointGuard;
        this.shootingGuard = shootingGuard;
        this.smallForward = smallForward;
        this.powerForward = powerForward;
        this.center = center;
        this.user = user;
    }

    public Team() {}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public PointGuard getPointGuard() {
        return pointGuard;
    }

    public void setPointGuard(PointGuard pointGuard) {
        this.pointGuard = pointGuard;
    }

    public ShootingGuard getShootingGuard() {
        return shootingGuard;
    }

    public void setShootingGuard(ShootingGuard shootingGuard) {
        this.shootingGuard = shootingGuard;
    }

    public SmallForward getSmallForward() {
        return smallForward;
    }

    public void setSmallForward(SmallForward smallForward) {
        this.smallForward = smallForward;
    }

    public PowerForward getPowerForward() {
        return powerForward;
    }

    public void setPowerForward(PowerForward powerForward) {
        this.powerForward = powerForward;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "Team{" +
                "teamid='" + teamID + '\'' +
                ", teamname='" + teamName + '\'' +
                '}';
    }

    public String toStringFullTeam() {
        return "Team {" +
                "teamid='" + teamID + '\'' +
                ", teamname='" + teamName + '\'' +
                ", pointguard=" + pointGuard.getPointGuardID() +
                ", shootingguard=" + shootingGuard.getShootingGuardID() +
                ", smallforward=" + smallForward.getSmallForwardID() +
                ", powerforward=" + powerForward.getPowerForwardID() +
                ", center=" + center.getCenterID() +
                '}';



    }

    @ManyToOne(optional = false)
    private User team;

    public User getTeam() {
        return team;
    }

    public void setTeam(User team) {
        this.team = team;
    }

    @ManyToOne(optional = false)
    private PointGuard pointGuards;

    public PointGuard getPointGuards() {
        return pointGuards;
    }

    public void setPointGuards(PointGuard pointGuards) {
        this.pointGuards = pointGuards;
    }

    @ManyToOne(optional = false)
    private ShootingGuard shootingGuards;

    public ShootingGuard getShootingGuards() {
        return shootingGuards;
    }

    public void setShootingGuards(ShootingGuard pointGuards) {
        this.shootingGuards = shootingGuards;
    }

    @ManyToOne(optional = false)
    private SmallForward smallForwards;

    public SmallForward getSmallForwards() {
        return smallForwards;
    }

    public void setSmallForwards(SmallForward smallForwards) {
        this.smallForwards = smallForwards;
    }

    @ManyToOne(optional = false)
    private PowerForward powerForwards;

    public PowerForward getPowerForwards() {
        return powerForwards;
    }

    public void setPowerForwards(PowerForward powerForwards) {
        this.powerForwards = powerForwards;
    }

    @ManyToOne(optional = false)
    private Center centers;

    public Center getCenters() {
        return centers;
    }

    public void setCenters(Center centers) {
        this.centers = centers;
    }

}

