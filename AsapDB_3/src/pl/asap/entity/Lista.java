package pl.asap.entity;

import javax.persistence.*;
import java.lang.reflect.*;



@Entity
@Table(name = "Lista")
public class Lista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id_postepowanie")
	private Integer idPostepowanie;
	
	@Column(name="ZZ")
	private String ZZ;
	
	@Column(name="PZ")
	private String PZ;
	
	@Column(name="WP")
	private String WP;
	
	@Column(name="DK")
	private String DK;
	
	@Column(name="Status")
	private String Status;
	
	@Column(name="Przedmiot_zakupu")
	private String Przedmiot_zakupu;
	
	@Column(name="Dostawca")
	private String Dostawca;
	
	@Column(name="Nazwa")
	private String Nazwa;
	
	@Column(name="Spolka")
	private String Spolka;
	
	@Column(name="data_ZZ")
	private String data_ZZ;
	
	@Column(name="data_PZ")
	private String data_PZ;
	
	@Column(name="data_WP")
	private String data_WP;
	
	@Column(name="data_DK")
	private String data_DK;
	


	public Integer getIdPostepowanie() {
		return idPostepowanie;
	}
	public void setIdPostepowanie(Integer idPostepowanie) {
		this.idPostepowanie = idPostepowanie;
	}
	public String getZZ() {
		return ZZ;
	}
	public void setZZ(String zZ) {
		ZZ = zZ;
	}
	public String getPZ() {
		return PZ;
	}
	public void setPZ(String pZ) {
		PZ = pZ;
	}
	public String getWP() {
		return WP;
	}
	public void setWP(String wP) {
		WP = wP;
	}
	public String getDK() {
		return DK;
	}
	public void setDK(String dK) {
		DK = dK;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPrzedmiot_zakupu() {
		return Przedmiot_zakupu;
	}
	public void setPrzedmiot_zakupu(String przedmiot_zakupu) {
		Przedmiot_zakupu = przedmiot_zakupu;
	}
	public String getDostawca() {
		return Dostawca;
	}
	public void setDostawca(String dostawca) {
		Dostawca = dostawca;
	}
	public String getNazwa() {
		return Nazwa;
	}
	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}
	public String getSpolka() {
		return Spolka;
	}
	public void setSpolka(String spolka) {
		Spolka = spolka;
	}
	public String getData_ZZ() {
		return data_ZZ;
	}
	public void setData_ZZ(String data_ZZ) {
		this.data_ZZ = data_ZZ;
	}
	public String getData_PZ() {
		return data_PZ;
	}
	public void setData_PZ(String data_PZ) {
		this.data_PZ = data_PZ;
	}
	public String getData_WP() {
		return data_WP;
	}
	public void setData_WP(String data_WP) {
		this.data_WP = data_WP;
	}
	public String getData_DK() {
		return data_DK;
	}
	public void setData_DK(String data_DK) {
		this.data_DK = data_DK;
	}
	public Object[] getArray()	{
		Class c = getClass();
		Field[] fields = c.getDeclaredFields();
		int length = fields.length;
		Object[] array = new Object[length];
		for (int i =0; i<= length -1; i++)	{
			try {
				array[i] = fields[i].get(this);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return array;
	}

}
