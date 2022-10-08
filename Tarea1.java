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
    
    public OrdenCompra(String est){
        //constructor
      //  fecha = f;
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
        detalle.add(cantidad, art);
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
    public void addDetalle(Articulo a){
        detalle.add(a);
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
    private int tipoPago;
    
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
        return total-pagado;
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(int i){
        super(i);
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

    public static void main(String[] args) {
        OrdenCompra orden = new OrdenCompra("entregado");
        DetalleOrden det = new DetalleOrden(10); 
        Articulo art = new Articulo("chocochips", "con chips de chocolate", 200, 1000);
        Articulo art1 = new Articulo("Rolls", "mani cubierto de chocolate", 150, 1500);
        det.addDetalle(art);
        det.addDetalle(art1);
        Pago pa = new Pago(20000);
        Efectivo e = new Efectivo(20000);

        
        System.out.println(art.getNombre());
        System.out.println(art.getDescripcion());
        System.out.println(det.calcularIva(art));
        System.out.println(art1.getNombre());
        System.out.println("vuelto: " + e.calcDevolucion(10000));
        System.out.println("Peso total (gramos):" + det.calcularPeso(art));
        for(int i=0; i<100; i++){
//            System.out.println("articulo: " + det.[i]);
        }
    }
    
}
