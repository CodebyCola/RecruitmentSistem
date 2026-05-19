/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.model;

/**
 *
 * @author Pongo
 */
public abstract class Kandidat implements Evaluator {

    private int id;
    private String nama;
    private String path;
    protected int writing;
    protected int coding;
    protected int interview;
    protected float score;

    private String status;

    public Kandidat(String nama, String path, int writing, int coding, int interview) {

        this.nama = nama;
        this.path = path;
        this.writing = writing;
        this.coding = coding;
        this.interview = interview;
    }

    public void setStatus() {
        if (evaluateStatus()) {
            status = "DITERIMA";
        } else {
            status = "DITOLAK";
        }
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWriting() {
        return writing;
    }

    public void setWriting(int writing) {
        this.writing = writing;
    }

    public int getCoding() {
        return coding;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    public int getInterview() {
        return interview;
    }

    public void setInterview(int interview) {
        this.interview = interview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
