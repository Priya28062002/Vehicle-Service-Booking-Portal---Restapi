package com.springapp.vehicleservice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.springapp.vehicleservice.utilities.ServiceCharges;
import com.springapp.vehicleservice.utilities.ServiceTypes;

@Entity
@Table(name = "vehicle_service")
public class VehicleService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int vehicleId;
	@Column(name = "email")
	private String userEmail;
	@Column(name = "brand")
	private String vehicleBrand;
	@Column(name = "reg_no")
	private String registrationNumber;
	@Column(name = "service_date")
	private Date serviceDate;
	@Column(name = "service_type")
	private String serviceType;
	@Column(name = "delivery_type")
	private String deliveryType;
	@Column(name = "status")
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "charge_id")
    private Charges charges;

	public VehicleService() {

	}

	public VehicleService(int vehicleId, String userEmail, String vehicleBrand, String registrationNumber,
			Date serviceDate, String serviceType, String deliveryType, String status, Charges charges) {
		this.vehicleId = vehicleId;
		this.userEmail = userEmail;
		this.vehicleBrand = vehicleBrand;
		this.registrationNumber = registrationNumber;
		this.serviceDate = serviceDate;
		this.serviceType = serviceType;
		this.deliveryType = deliveryType;
		this.status = status;
		this.charges = charges;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Charges getCharges() {
		return charges;
	}
	
	public void setCharges(Charges charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "VehicleService [vehicleId=" + vehicleId + ", userEmail=" + userEmail + ", vehicleBrand=" + vehicleBrand
				+ ", registrationNumber=" + registrationNumber + ", serviceDate=" + serviceDate + ", serviceType="
				+ serviceType + ", deliveryType=" + deliveryType + ", status=" + status + ", charges=" + charges.getServiceCharge() + "]";
	}
	
	@PrePersist
	public void setChargesOnServiceType() {
		Charges charges = new Charges();
		charges.setServiceCharge(setServiceChargeOnType(serviceType));
		setCharges(charges);
	}
	
	private Integer setServiceChargeOnType(String serviceType) {
		switch (serviceType) {
		case ServiceTypes.PUNCHTURE:
			return ServiceCharges.PUNCHTURE;
		case ServiceTypes.WATER_WASH: 
			return ServiceCharges.PUNCHTURE;
		case ServiceTypes.AIR_FILTER_CHANGE:
			return ServiceCharges.AIR_FILTER_CHANGE;
		case ServiceTypes.BATTERY_CHANGE:
			return ServiceCharges.BATTERY_CHANGE;
		default:
			return null;
		}
	}

}
