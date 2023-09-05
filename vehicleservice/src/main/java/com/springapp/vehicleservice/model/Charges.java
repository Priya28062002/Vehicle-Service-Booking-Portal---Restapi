package com.springapp.vehicleservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_charges")
public class Charges {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "charge_id")
	private int chargeId;
	@Column(name = "service_charge")
	private int serviceCharge;
	
	public Charges() {
		
	}

	public Charges(int chargeId, int serviceCharge) {
		this.chargeId = chargeId;
		this.serviceCharge = serviceCharge;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	
}
