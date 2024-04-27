package com.siwft.cargo.persistence.enums;

public enum EstadoEnvio {
    PENDIENTE("Pendiente"),
    EN_CARGA("En Carga"),
    EN_TRANSITO("En Tránsito"),
    RETRASADO("Retrasado"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private final String estado;

    // Constructor del enum para setear el estado
    EstadoEnvio(String estado) {
        this.estado = estado;
    }

    // Getter para obtener el valor del estado
    public String getEstado() {
        return this.estado;
    }
}
