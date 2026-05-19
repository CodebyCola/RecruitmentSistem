/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.controller;

import java.util.ArrayList;
import java.util.List;
import latihan.dao.KandidatDAO;
import latihan.model.*;
import latihan.view.MainFrame;

/**
 *
 * @author Pongo
 */
public class Controller {

    private KandidatDAO dao;
    private MainFrame view;

    public Controller(MainFrame view) {
        this.dao = new KandidatDAO();
        this.view = view;
    }

    public Kandidat createObject(String nama, String path, int writing, int coding, int interview) {
        Kandidat k;
        if (path.equals("Android Developer")) {
            k = new AndroidDeveloper(nama, path, writing, coding, interview);
        } else {
            k = new WebsiteDeveloper(nama, path, writing, coding, interview);
        }
        return k;
    }

    public void addKandidat(String nama, String path, int writing, int coding, int interview) {

        dao.insert(createObject(nama, path, writing, coding, interview));

    }

    public List<Kandidat> getAllKandidat() {
        List<Kandidat> list = dao.getAll();

        return list;
    }

    public void updateKandidat(int selectedId, String nama,
            String path, int writing, int coding, int interview) 
    {
      Kandidat k = createObject(nama, path, writing, coding, interview);
      k.setId(selectedId);
      k.setStatus();
      dao.update(k);
    }
    
    public void deleteKandidat(int selectedId) {
        dao.delete(selectedId);
    }
}
