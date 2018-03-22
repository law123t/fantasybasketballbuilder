package matc.madjava.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type User role.
 */
@Entity (name = "UserRoles")
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="userrole_id")
    private int userRoleId;

    @Column(name="role_name")
    private String roleName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User userId;

    /**
     * Instantiates a new User role.
     */
    public UserRoles() {

    }

    /**
     * Instantiates a new User role.
     *
     * @param userRoleId   the role id
     * @param roleName the role name
     */
    public UserRoles(int userRoleId, String roleName, User userId) {
        this.userRoleId = userRoleId;
        this.roleName = roleName;
        this.userId = userId;

    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets role id.
     *
     * @param userRoleId the role id
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets role id.
     *
     * @return the user id
     */

    public User getUserId() {
        return userId;
    }

    /**
     * Sets role id.
     *
     * @param userId the role id
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                ", roleName ='" + roleName + '\'' +
                '}';
    }
}
