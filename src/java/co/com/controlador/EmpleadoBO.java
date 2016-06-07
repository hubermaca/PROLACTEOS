/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.controlador;

import co.com.entidades.PlEmpleado;
import co.com.modelo.EmpleadoDaoJpa;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author porta
 */
@ManagedBean(name = "empleadoBO")
@SessionScoped

public class EmpleadoBO {

    private PlEmpleado plempleado;
    private EmpleadoDaoJpa empleadoDaoJpa;
    private List<PlEmpleado> empleadosList;
    private PlEmpleado seleccionarEmpleado;
    private Integer codigo;
    private String nombreTemp;

//    metodo constructor
    public EmpleadoBO() {
        empleadoDaoJpa = new EmpleadoDaoJpa();
        init();
    }

    private void init() {

        plempleado = new PlEmpleado();
        empleadosList = empleadoDaoJpa.listAll();
        seleccionarEmpleado = new PlEmpleado();
    }

    public String agregarEmpleados() {

        System.out.print("ENTRO METODO AGREGAR......");
        empleadoDaoJpa.crearEmpleado(plempleado);
        init();
        return null;

    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Producto Seleccionado", ((PlEmpleado) event.getObject()).getNombres());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Empleado Unselected", ((PlEmpleado) event.getObject()).getNombres());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//      Metodo para dar formato a las fechas
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    // informacion temporal del formulario de edicion(Proveedor)
    public String cargarEmpleado(PlEmpleado empleado) {

        codigo = seleccionarEmpleado.getIdEmpleado();
        System.out.println("Obteniendo codigo____" + codigo);
        nombreTemp = seleccionarEmpleado.getNombres();
        // descripcion = proveedor.getNombreProveedor();
        // navegmos a la pagina de edicion
        System.out.print("prueba------" + nombreTemp);
        return "EditarEmpleado";

        // accion para invocar al manager
    }

    public void actualizarEmpleado() {

        empleadoDaoJpa.actualizarEmpleado(codigo, nombreTemp);
    }

    public PlEmpleado getPlempleado() {
        return plempleado;
    }

    public void setPlempleado(PlEmpleado plempleado) {
        this.plempleado = plempleado;
    }

    public EmpleadoDaoJpa getEmpleadoDaoJpa() {
        return empleadoDaoJpa;
    }

    public void setEmpleadoDaoJpa(EmpleadoDaoJpa empleadoDaoJpa) {
        this.empleadoDaoJpa = empleadoDaoJpa;
    }

    public List<PlEmpleado> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<PlEmpleado> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public PlEmpleado getSeleccionarEmpleado() {
        return seleccionarEmpleado;
    }

    public void setSeleccionarEmpleado(PlEmpleado seleccionarEmpleado) {
        this.seleccionarEmpleado = seleccionarEmpleado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreTemp() {
        return nombreTemp;
    }

    public void setNombreTemp(String nombreTemp) {
        this.nombreTemp = nombreTemp;
    }

}
