package tarea1;

import java.util.Date;

class Cliente{
    private String nombre;
    private String rut;
    
    public Cliente(String nom, String r){
        nombre = nom;
        rut = r;
    }
    
}

class Direccion{
    private String direccion;
    
    public Direccion( String direc){
        direccion = direc;
    } 
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    
    public OrdenCompra(Date f, String est){
        //constructor
        fecha = f;
        estado = est;
    }
    public void calcularPrecioSinIva(){
       
    }
    public float calcularIva(float precio){
        float iva = precio*(19/100);
        return iva;
    }
    public void calcularPrecio(){
        
    }
    public void calcularPeso(){
        
    }
}

class DetalleOrden{
    private int cantidad;
    
    public DetalleOrden(int c){
        cantidad = c;
    }
    
    public void calcularPrecio(){
        
    }
    public void calcularPrecioSinIva(){
        
    }
    public void calcularIva(){
        
    }
    public void calcularPeso(){
        
    }
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;  
    
    public Articulo(){
       
    }
}

class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(){
        
    }
}

class Efectivo extends Pago{
    public Efectivo(){
        
    }
}
class Transferencia extends Pago{
    public Transferencia(){
        
    }
}

class Tarjeta extends Pago{
    public Tarjeta(){
        
    }
}

class DocumentoTributario{
    private String numero;
    private String rut;
    private Date fecha;
    
    public DocumentoTributario(){
        
    }
}

class Factura extends DocumentoTributario{
    public Factura(){
        
    }
}

class Boleta extends DocumentoTributario{
    public Boleta(){
        
    }
}

public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
