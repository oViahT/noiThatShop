/*
 * package SnacksShop.DTO;
 * 
 * public class BillDetailsManagerDTO { private int id; private String
 * idProduct; private int idBill; private int quantity; private double total;
 * 
 * public BillDetailsManagerDTO() { super(); }
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getIdProduct() { return idProduct; }
 * 
 * public void setIdProduct(String idProduct) { this.idProduct = idProduct; }
 * 
 * public int getIdBill() { return idBill; }
 * 
 * public void setIdBill(int idBill) { this.idBill = idBill; }
 * 
 * public int getQuantity() { return quantity; }
 * 
 * public void setQuantity(int quantity) { this.quantity = quantity; }
 * 
 * public double getTotal() { return total; }
 * 
 * public void setTotal(double total) { this.total = total; } }
 */

//--------------------
package shopnoithat.DTO;

import shopnoithat.Entity.Bill;

public class BillDetailsManagerDTO {
	private int id;
	private ProductsDTO products;
	private Bill bill;
	private int quantity;
	private double total;

	public BillDetailsManagerDTO() {
		super();
	}

	public BillDetailsManagerDTO(int id, ProductsDTO products, Bill bill, int quantity, double total) {
		this.id = id;
		this.products = products;
		this.bill = bill;
		this.quantity = quantity;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductsDTO getProducts() {
		return products;
	}

	public void setProducts(ProductsDTO products) {
		this.products = products;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
