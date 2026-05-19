/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.model;

/**
 *
 * @author Pongo
 */
public class AndroidDeveloper extends Kandidat {
    
    public AndroidDeveloper(String nama, String path, int writing, int coding, int interview) {
        super(nama, "Android Developer", writing, coding, interview);
        this.score = calculateFinalScore();
        
    }

    public float calculateFinalScore() {
        float finalScore = (writing + coding + interview) / 3;
        return finalScore;
    }

    public boolean evaluateStatus() {
        return calculateFinalScore() >= 85;
    }

}
