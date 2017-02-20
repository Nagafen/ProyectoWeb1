/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Inscribciones;
import Modelo.Profesor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class InscribcionesDAO {
    
    private RandomAccessFile InscribcionseDB;
    private Inscribciones in;
    private ArrayList<Inscribciones> ain = new ArrayList<>();
    
    public int idEst;
    public int idCur;
    public String fei = "";
    public String fef = "";
    public int nota;
    
    public InscribcionesDAO() throws FileNotFoundException {
        this.InscribcionseDB = new RandomAccessFile("Inscribciones.txt", "rw");
    }
     public boolean insertar(Inscribciones Incribcion) throws IOException {
        long posicionMemoria = this.InscribcionseDB.length();
        this.InscribcionseDB.seek(posicionMemoria);
        
        this.InscribcionseDB.writeInt(Incribcion.getIdEst());
        this.InscribcionseDB.writeInt(Incribcion.getIdCurso());
         for (int i = 0; i < Incribcion.getFecha_ins().length; i++) {
             char letra=Incribcion.getFecha_ins()[i];
             this.InscribcionseDB.writeChar(letra);
         }
        this.InscribcionseDB.seek(posicionMemoria + 48);
        System.out.println(this.InscribcionseDB.getFilePointer());
         for (int i = 0; i < Incribcion.getFecha_fin().length; i++) {
             char letra =Incribcion.getFecha_fin()[i];
             this.InscribcionseDB.writeChar(letra);
         }
        this.InscribcionseDB.seek(posicionMemoria + 88);
        System.out.println(this.InscribcionseDB.getFilePointer());
        
        this.InscribcionseDB.writeInt(Incribcion.getNota());
        return true;
    }
     public boolean actualizar(Inscribciones Inscribcion) {

        return false;
    }

    public boolean borrar(Inscribciones Incribcion) {
        return false;
    }
        public ArrayList<Inscribciones> listarTodo() throws IOException {
        for (long i = 0; i < this.InscribcionseDB.length(); i = i + 92) {
            this.InscribcionseDB.seek(i);
            idEst = this.InscribcionseDB.readInt();
            idCur = this.InscribcionseDB.readInt();
            for (int j = 0; j < 20; j++) {
                fei = fei + this.InscribcionseDB.readChar();
            }
            for (int k = 0; k < 20; k++) {
                fef = fef + this.InscribcionseDB.readChar();
            }
            nota = this.InscribcionseDB.readInt();
            in = new Inscribciones(idEst, idCur, fei.toCharArray(),fei.toCharArray(), nota);
            ain.add(in);
        }
        return ain;
    }
       public void destructor() throws IOException {
        this.InscribcionseDB.close();
    }
    
    
}
