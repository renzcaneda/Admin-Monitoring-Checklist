/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

/**
 *
 * @author jetro
 */
public class AttendanceList {
    private String txtname;
    private String txtroom,txttime,txtdate;
    
    public AttendanceList(String txtname,String txtroom,String txttime,String txtdate){
        this.txtname = txtname;
        this.txtroom = txtroom;
        this.txttime = txttime;
        this.txtdate = txtdate;

    }
    
    public String getStudent_id(){
        return txtname;
    }
    public String getStudent_name(){
        return txtroom;
    }
    public String getcourse(){
        return txttime = txttime;
    }
    public String getage(){
        return txtdate;
    }
  
}
