package com.ccg.problemaML.views;

public class TenYearSimulationResponse {
    public int cantDiasSequia;
    public int periodosSequia;
    public int cantDiasLluvia;
    public int periodosLluvia;
    public int cantDiasCondicionesOptimas;
    public int periodosCondicionesOptimas;
    public int cantDiasIndeterminado;
    public int periodosIndeterminado;
    public int diaMayorLluvia;
    public int getCantDiasSequia() {
		return cantDiasSequia;
	}
	public void setCantDiasSequia(int cantDiasSequia) {
		this.cantDiasSequia = cantDiasSequia;
	}
	public int getPeriodosSequia() {
		return periodosSequia;
	}
	public void setPeriodosSequia(int periodosSequia) {
		this.periodosSequia = periodosSequia;
	}
	public int getCantDiasLluvia() {
		return cantDiasLluvia;
	}
	public void setCantDiasLluvia(int cantDiasLluvia) {
		this.cantDiasLluvia = cantDiasLluvia;
	}
	public int getPeriodosLluvia() {
		return periodosLluvia;
	}
	public void setPeriodosLluvia(int periodosLluvia) {
		this.periodosLluvia = periodosLluvia;
	}
	public int getCantDiasCondicionesOptimas() {
		return cantDiasCondicionesOptimas;
	}
	public void setCantDiasCondicionesOptimas(int cantDiasCondicionesOptimas) {
		this.cantDiasCondicionesOptimas = cantDiasCondicionesOptimas;
	}
	public int getPeriodosCondicionesOptimas() {
		return periodosCondicionesOptimas;
	}
	public void setPeriodosCondicionesOptimas(int periodosCondicionesOptimas) {
		this.periodosCondicionesOptimas = periodosCondicionesOptimas;
	}
	public int getCantDiasIndeterminado() {
		return cantDiasIndeterminado;
	}
	public void setCantDiasIndeterminado(int cantDiasIndeterminado) {
		this.cantDiasIndeterminado = cantDiasIndeterminado;
	}
	public int getPeriodosIndeterminado() {
		return periodosIndeterminado;
	}
	public void setPeriodosIndeterminado(int periodosIndeterminado) {
		this.periodosIndeterminado = periodosIndeterminado;
	}
	public int getDiaMayorLluvia() {
		return diaMayorLluvia;
	}
	public void setDiaMayorLluvia(int diaMayorLluvia) {
		this.diaMayorLluvia = diaMayorLluvia;
	}
	public TenYearSimulationResponse(int sequia, int perSequia, int lluvia, int perLluvia, int condOptimas, int perCondOpt, int indet, int perIndet, int diaMayorLluvia) {
        this.cantDiasSequia = sequia;
        this.periodosSequia = perSequia;
        this.cantDiasLluvia = lluvia;
        this.periodosLluvia = perLluvia;
        this.cantDiasCondicionesOptimas = condOptimas;
        this.periodosCondicionesOptimas = perCondOpt;
        this.cantDiasIndeterminado = indet;
        this.periodosIndeterminado = perIndet;
        this.diaMayorLluvia = diaMayorLluvia;
    }
}
