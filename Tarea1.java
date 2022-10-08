package tarea1;

import java.util.ArrayList;
import java.util.Date;

class Cliente{
    private String nombre;
    private String rut;
    
    public Cliente(String nom, String r){
        nombre = nom;
        rut = r;
    }
    public String getNombreCliente(){
        return this.nombre;
    }
    public void setNombreCliente(String nuevoNomCliente){
        this.nombre = nuevoNomCliente;
    }
}

class Direccion{
    private String direccion;
    
    public Direccion( String direc){
        direccion = direc;
    } 
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String newDireccion){
        this.direccion = newDireccion;
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
    private ArrayList<Articulo> detalle;
    
    public DetalleOrden(int c){
        cantidad = c;
        detalle = new ArrayList();
    }
    
    public double calcularPrecio(Articulo art){
        //calcular precio total
        double calcularPrecio = (float)cantidad*art.getPrecio()*1.19;
        return calcularPrecio;
    }
    public double calcularPrecioSinIva(Articulo art){
        double iva = art.getPrecio()*0.19;
        return cantidad*art.getPrecio() - cantidad*iva;
    }
    public double calcularIva(Articulo art){
        double iva= art.getPrecio()*0.19;
        return iva*cantidad;
    }
    public float calcularPeso(Articulo art){
        return art.getPeso()*cantidad;
    }
}

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;  
    
    public Articulo(String nom, String desc, float peso, float prec){
       this.nombre = nom;
       this.descripcion = desc;
       this.precio = prec;
       this.peso = peso;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nuevoNom){
        this.nombre = nuevoNom;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setDescripcion(String nuevaDesc){
        this.descripcion= nuevaDesc;
    }
    public Float getPrecio(){
        return this.precio;
    }
    public void setPrecio(Float nuevoPrecio){
        this.precio= nuevoPrecio;
    }
    public Float getPeso(){
        return this.peso;
    }
    public void setPeso(Float nuevoPeso){
        this.precio= nuevoPeso;
    }
}
 
class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(float mont){
        monto = mont;
    }
    public Float getMonto(){
        return this.monto;
    }
}

class Efectivo extends Pago{
    public Efectivo(int i){
        super(i);
    }
    public float calcDevolucion(float pagado){
        //vuelto
        float total = super.getMonto();
        return pagado-total;
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(){
        
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
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
    public Factura(int i){
 //       super(i);
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
