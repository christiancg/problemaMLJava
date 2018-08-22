package com.ccg.problemaML.views;

public class ClimaResponse {
    public int dia;
    public String clima;
    public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public ClimaResponse(int dia, String clima)
    {
        this.dia = dia;
        this.clima = clima;
    }
}
