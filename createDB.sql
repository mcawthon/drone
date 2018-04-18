create database droneservice;

Create Table Users(
	userID VARCHAR(20) PRIMARY KEY, 
	password VARCHAR(45), 
	type VARCHAR(10));

Create Table DroneInventory(
	droneID VARCHAR(45) NOT NULL,
	make VARCHAR(45),
	model VARCHAR(45),
	year VARCHAR(45),
	vin VARCHAR(45),
	faaLicenseNum VARCHAR(45),
	lastService DATETIME,
	locationID VARCHAR(45),

	CONSTRAINT droneInv_drone_id_pk PRIMARY KEY(droneID)
);



insert into users values ('admin','admin','admin');
