package patrones._PlanesMedicos;

import java.time.LocalDate;
import java.util.List;

public class Afiliado {
	
	private String nombre;
	private int familiaresACargo;
	private double salario;
	private LocalDate fechaNacimiento;
	private Coseguro coseguro;
	private List<PlanMedico> previos;
	private PlanMedico plan;
	
	public String getNombre() {
		return nombre;
	}
	
	public int getFamiliaresACargo() {
		return familiaresACargo;
	}
	
	public void setFamiliaresACargo(int familiaresACargo) {
		this.familiaresACargo = familiaresACargo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Coseguro getCoseguro() {
		return coseguro;
	}
	
	public void setCoseguro(Coseguro coseguro) {
		this.coseguro = coseguro;
	}
	
	public List<PlanMedico> getPrevios() {
		return previos;
	}
	
	public PlanMedico getPlan() {
		return plan;
	}
	
	public void setPlan(PlanMedico plan) {
		this.previos.add(this.plan);
		this.plan = plan;
	}
	
	public double calcularMontoAPagar() {
		return this.plan.montoACobrar(salario, familiaresACargo, coseguro);
	}
	

}
