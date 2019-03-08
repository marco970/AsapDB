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
	private String dsZZ;
	
	@Column(name="data_PZ")
	private String dsPZ;
	
	@Column(name="data_WP")
	private String dsWP;
	
	@Column(name="data_DK")
	private String dsDK;
	


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
	public String getsZZ() {
		return dsZZ;
	}
	public void setdsZZ(String dsZZ) {
		this.dsZZ = dsZZ;
	}
	public String getdsPZ() {
		return dsPZ;
	}
	public void setdsPZ(String dsPZ) {
		this.dsPZ = dsPZ;
	}
	public String getdsWP() {
		return dsWP;
	}
	public void setdsWP(String dsWP) {
		this.dsWP = dsWP;
	}
	public String getdsDK() {
		return dsDK;
	}
	public void setdsDK(String dsDK) {
		this.dsDK = dsDK;
	}
	public Object[] getArray()	{
		
		Class c = getClass();
		Field[] fields = c.getDeclaredFields();

		int length = fields.length;
		Object[] array = new Object[length-1];
		for (int i =0; i<= length -2; i++)	{
			try {
				//System.out.println(" lista el "+fields[i].toString());
				String[] a = null;
				if (i+1<= length -1) {
					a = fields[i + 1].toString().split("[.]{1}");
					int k = a.length;
					array[i] = a[k-1];
				}

				//System.out.println(" lista el "+ k +" -- "+a[k-1]);
				//String[] b = a[k-1].split("[.]{1}");
				
				//int l = b.length;
				//System.out.println(" lista l "+ l);

				//System.out.println(" lista el "+a[k]+" * "+k);
				//System.out.println(" lista el "+array[i].getClass());
				//System.out.println(" lista el "+array[i]);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return array;
	}
	
public Object[] getRow()	{
		
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
	
	public int getLength()	{
		Class c = getClass();
		Field[] fields = c.getDeclaredFields();
		return fields.length;
		
	}
	

}
