/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.sheintap;

/**
 *
 * @author MrX
 */


public class ClaseDatosPedidos {
  private String nombre, numcel, nomart, talla, color,  precio, mescicloaño;

    public String getNombre() {
        return nombre;
    }

    

    public String getNumcel() {
        return numcel;
    }

   

    public String getNomart() {
        return nomart;
    }

    

    public String getTalla() {
        return talla;
    }

   

    public String getColor() {
        return color;
    }

   

    public String getMescicloaño() {
        return mescicloaño;
    }

    public String getPrecio() {
        return precio;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
        System.out.print("Insertaste en clase de atributos el"+nombre);
    }
    public void setNumcel(String numcel) {
        this.numcel = numcel;
    }
    public void setNomart(String nomart) {
        this.nomart = nomart;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
     public void setColor(String color) {
        this.color = color;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public void setMescicloaño(String mescicloaño) {
        this.mescicloaño = mescicloaño;
    }
     
     
}


