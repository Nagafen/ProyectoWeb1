/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.ArbolCursos;
import Modelo.Cursos;
import Modelo.Estudiantes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class CursosDao {
    private RandomAccessFile CursosDataBase;
    private ArbolCursos arbol = new ArbolCursos();
    public int codigo;
    public String nuevo1="";
    public int dur;
    public int idProf;
    
    public CursosDao() throws FileNotFoundException {
        this.CursosDataBase = new RandomAccessFile("C:\\Users\\crist\\Desktop\\cursos.txt", "rw");
    }
  
   
    public boolean insertar(Cursos curso) throws IOException {
        long posicionMemoria = this.CursosDataBase.length();
        this.CursosDataBase.seek(posicionMemoria);

        arbol.Ingresar(curso.getCodigo(), posicionMemoria);
        arbol.ListarArbol();
        this.CursosDataBase.writeInt(curso.getCodigo());
        
        for (int i = 0; i < curso.getNombre().length; i++) {
            char letra = curso.getNombre()[i];
            this.CursosDataBase.writeChar(letra);
        }
        this.CursosDataBase.seek(posicionMemoria + 44);

        this.CursosDataBase.writeInt(curso.getDuracion());

        this.CursosDataBase.writeInt(curso.getIdprof());

        return true;
    }

    public boolean actualizar(Estudiantes estudiante) {

        return false;
    }

    public boolean borrar(Estudiantes estudiante) {
        return false;
    }

    public ArrayList<Cursos> listarTodo() throws IOException {
        for (long i = 0; i < this.CursosDataBase.length(); i = i + 52) {
            this.CursosDataBase.seek(i);
            System.out.println(this.CursosDataBase.readInt());
            for (int j = 0; j < 20; j++) {
                System.out.print(this.CursosDataBase.readChar());
            }
            System.out.println(this.CursosDataBase.readInt());
            System.out.println(this.CursosDataBase.readInt());
            System.out.println("");
        }
        return null;
    }

    public void ListarUnitario(int identificacion) throws IOException {
        
        long posm = arbol.Buscar(identificacion);
        this.CursosDataBase.seek(posm);
        codigo = this.CursosDataBase.readInt();
        System.out.println(codigo);
        for (int j = 0; j < 20; j++) {
            nuevo1 = nuevo1 + this.CursosDataBase.readChar();
           
        }
        System.out.println(nuevo1);
        dur = this.CursosDataBase.readInt();
        System.out.println(dur);
        idProf = this.CursosDataBase.readInt();
        System.out.println(idProf);
        System.out.println("");
    }

    public void destructor() throws IOException {
        this.CursosDataBase.close();
    }
}
