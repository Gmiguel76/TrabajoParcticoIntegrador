package TrababajoIntegrador;

import TrababajoIntegrador.Equipo;
import TrababajoIntegrador.Partido;
import TrababajoIntegrador.ResultadoEnum;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public int puntos(){

        ResultadoEnum resultadoReal = this.partido.resultado(this.equipo);

        if (this.resultado.equals(resultadoReal)) {
            return 1;}
        else {
            return 0;}
    }
}
