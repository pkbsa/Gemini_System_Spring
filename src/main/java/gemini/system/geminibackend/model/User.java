package gemini.system.geminibackend.model;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.AstronomicalData;
import edu.gemini.app.ocs.model.SciencePlan;
import jakarta.persistence.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

@Entity

@Table(name="USER")
public abstract class User {
    @Id
    private int userId;
    public String userUsername;
    private String userPassword;
    private String userPermission;
    private String userAccountName;

    static OCS ocs = new OCS(true);

    protected User(){  }

    public User(int userId, String userUsername, String userPassword, String userPermission, String userAccountName) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userPermission = userPermission;
        this.userAccountName = userAccountName;
    }

    public int login(String username, String password) {
        if(this.userUsername.equals(username) && this.userPassword.equals(password)) {
            return this.userId;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPermission='" + userPermission + '\'' +
                ", userAccountName='" + userAccountName + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserOperationLevel(String userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public ArrayList<SciencePlan> getAllSciencePlan(){
        System.out.println("Getting all SciencePlan");
        for(SciencePlan sc : ocs.getAllSciencePlans()){
            System.out.println(sc);
        }
        return ocs.getAllSciencePlans();
    }

    public SciencePlan getSciencePlanByID(int id){
        for(SciencePlan sc : ocs.getAllSciencePlans()){
            if(sc.getPlanNo() == id) return sc;
        }
        return null;
    }
    public ArrayList<BufferedImage> setDummyData(){
        ocs.updateSciencePlanStatus(2, SciencePlan.STATUS.COMPLETE);
        // Case 6: Execute a command line
        System.out.println("\nCase 6: Execute a Gemini command line's command");
        // Execute the command to get the Gemini system version
        System.out.println(ocs.executeCommand("GetVersion"));
        // Execute the command to get the status of the Gemini system
        System.out.println(ocs.executeCommand("GetStatus"));
        // Execute the command to run the system test
        System.out.println(ocs.executeCommand("RunTest"));
        // Send command to the virtual telescope
        System.out.println(ocs.executeCommand("START"));
        System.out.println(ocs.executeCommand("UP"));
        System.out.println(ocs.executeCommand("UP"));
        System.out.println(ocs.executeCommand("LEFT"));
        System.out.println(ocs.executeCommand("LEFT"));
        System.out.println(ocs.executeCommand("FOCUS"));
        System.out.println(ocs.executeCommand("TAKE_PHOTO"));
        System.out.println(ocs.executeCommand("STOP"));
        // Case 7: Install and remove the configurations
        System.out.println("\nCase 7: Install and remove the configurations");
        System.out.println("INSTALLED CONFIGURATIONS\n" + ocs.getConfigurations());
        boolean success = ocs.addConfiguration("/home/drive/gemini/configuration1.conf");
        System.out.println("Adding status: " + success);
        System.out.println("INSTALLED CONFIGURATIONS\n" + ocs.getConfigurations());
        success = ocs.removeConfiguration(1);
        System.out.println("Removing status: " + success);
        System.out.println("INSTALLED CONFIGURATIONS\n" + ocs.getConfigurations());

        // Case 9: Access live view of telescope
        System.out.println("\nCase 9: Access live view of telescope");
        try {
            System.out.println(ocs.accessTelescopeLiveView());
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        // Case 9: Test science plan
        System.out.println("\nCase 9: Test science plan");
        System.out.println(ocs.testSciencePlan(ocs.getSciencePlanByNo(2)));
        System.out.println(ocs.getAllSciencePlans());

        System.out.println("\nCase 10: Get the astronomical data from complete science plan");
        System.out.println(ocs.getSciencePlanByNo(2));
        AstronomicalData astroData = null;
        try {
            astroData = ocs.getAstronomicalData(ocs.getSciencePlanByNo(2));
            return astroData.getAllImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
