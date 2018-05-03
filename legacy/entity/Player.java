package matc.madjava.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "Player")
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "player_id")
    private int playerID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    private PlayerPosition playerPosition;

    @Column(name = "points")
    private int points;

    @Column(name = "assists")
    private int assists;

    @Column(name = "rebounds")
    private int rebounds;

    @Column(name = "steals")
    private int steals;

    @Column(name = "blocks")
    private int blocks;

    @Column(name = "turnovers")
    private int turnovers;

    @OneToMany
    @JoinColumn(name = "playerone_player_id")
    private Set<Team> playerOneTeams = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "playertwo_player_id")
    private Set<Team> playerTwoTeams = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "playerthree_player_id")
    private Set<Team> playerThreeTeams = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "playerfour_player_id")
    private Set<Team> playerFourTeams = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "playerfive_player_id")
    private Set<Team> playerFiveTeams = new HashSet<>();

    //private Status status;

    public Player(int playerID, String firstName, String lastName, PlayerPosition playerPosition, int points, int assists,
                  int rebounds, int steals, int blocks, int turnovers){
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerPosition = playerPosition;
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.steals = steals;
        this.blocks = blocks;
        this.turnovers = turnovers;

    }

    public Player() {}

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public Set<Team> getPlayerOneTeams() {
        return playerOneTeams;
    }

    /**
     * Sets teams.
     *
     * @param playerOneTeams the teams
     */
    public void setPlayerOneTeams(Set<Team> playerOneTeams) {
        this.playerOneTeams = playerOneTeams;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public Set<Team> getPlayerTwoTeams() {
        return playerTwoTeams;
    }

    /**
     * Sets teams.
     *
     * @param playerTwoTeams the teams
     */
    public void setPlayerTwoTeams(Set<Team> playerTwoTeams) {
        this.playerTwoTeams = playerTwoTeams;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public Set<Team> getPlayerThreeTeams() {
        return playerThreeTeams;
    }

    /**
     * Sets teams.
     *
     * @param playerThreeTeams the teams
     */
    public void setPlayerThreeTeams(Set<Team> playerThreeTeams) {
        this.playerThreeTeams = playerThreeTeams;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public Set<Team> getPlayerFourTeams() {
        return playerFourTeams;
    }

    /**
     * Sets teams.
     *
     * @param playerFourTeams the teams
     */
    public void setPlayerFourTeams(Set<Team> playerFourTeams) {
        this.playerFourTeams = playerFourTeams;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public Set<Team> getPlayerFiveTeams() {
        return playerFiveTeams;
    }

    /**
     * Sets teams.
     *
     * @param playerFiveTeams the teams
     */
    public void setPlayerFiveTeams(Set<Team> playerFiveTeams) {
        this.playerFiveTeams = playerFiveTeams;
    }


    @Override
    public String toString(){
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String toStringFull(){
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", playerType=" +
                '}';
    }

}