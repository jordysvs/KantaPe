package com.kruma.core.fileserver.entity;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class FileUpload {

    //region VARIABLES
    private Integer Iddocumento;
    private Integer Idalmacen;
    private Integer Idregistro;
    private String nombre;
    private String nombreArchivo;
    private String extension;
    private String descripcionLogica;
    private String descripcionFisica;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private OutputStream stream;
    private Byte[] bytes;
    //endregion

    //region CONSTRUCTOR
    public FileUpload() {
    }
    //endregion

    //region PROPIEDADES

    public Integer getIddocumento() {
        return Iddocumento;
    }

    public void setIddocumento(Integer iddocumento) {
        Iddocumento = iddocumento;
    }

    public Integer getIdalmacen() {
        return Idalmacen;
    }

    public void setIdalmacen(Integer idalmacen) {
        Idalmacen = idalmacen;
    }

    public Integer getIdregistro() {
        return Idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        Idregistro = idregistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDescripcionLogica() {
        return descripcionLogica;
    }

    public void setDescripcionLogica(String descripcionLogica) {
        this.descripcionLogica = descripcionLogica;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    public void setBytes(Byte[] bytes) {
        this.bytes = bytes;
    }

    public OutputStream getStream() {
        return stream;
    }

    public void setStream(OutputStream stream) {
        this.stream = stream;
    }

    //endregion
}
