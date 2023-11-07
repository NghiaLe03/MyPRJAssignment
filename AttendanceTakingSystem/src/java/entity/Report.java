/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nghia
 */
public class Report extends BaseEntity {

    private int total_session;
    private int absent;
    private int percentage;

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int total, int absent) {
        this.percentage = (absent * 100) / total;
    }

    public int getTotal_session() {
        return total_session;
    }

    public void setTotal_session(int total_session) {
        this.total_session = total_session;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

}
