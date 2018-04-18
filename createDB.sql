create database droneservice;

Create Table Users(
	userID VARCHAR(20) PRIMARY KEY, 
	password VARCHAR(45), 
	type VARCHAR(10)
)ENGINE = InnoDB;;

Create Table DroneInventory(
	droneID VARCHAR(45) NOT NULL,
	make VARCHAR(45),
	model VARCHAR(45),
	year VARCHAR(45),
	vin VARCHAR(45),
	faaLicenseNum VARCHAR(45),
	lastService DATETIME,
	locationID VARCHAR(45),

	CONSTRAINT droneInv_droneID_pk PRIMARY KEY(droneID)
)ENGINE = InnoDB;;

Create Table Employee(
	employeeID INT NOT NULL,
	first VARCHAR(45),
	last VARCHAR(45),
	phone VARCHAR(45),
	street VARCHAR(45),
	city VARCHAR(45),
	state VARCHAR(45),
	zip VARCHAR(45),
	jobCode VARCHAR(45),
	jobTitle VARCHAR(45),
	dateStarted DATE,
	dateTerminated DATE,

	CONSTRAINT employee_employeeID_pk PRIMARY KEY(employeeID)
)ENGINE = InnoDB;

Create Table DroneService(
	serviceID INT NOT NULL,
	droneID VARCHAR(45) NOT NULL,
	employeeID INT NOT NULL,
	description VARCHAR(100),

	CONSTRAINT droneservice_serviceID_pk PRIMARY KEY(serviceID),
	FOREIGN KEY (droneID) REFERENCES DroneInventory(droneID),
	FOREIGN KEY (employeeID) REFERENCES Employee(employeeID)
)ENGINE = InnoDB;

Create Table DronePart(
	partID INT NOT NULL,
	serialNumber VARCHAR(45),
	expirationDate Date,
	supplierID VARCHAR(45),
	state VARCHAR(45),
	reorderLevel INT,
	amount INT,

	CONSTRAINT PRIMARY KEY (partID)
)ENGINE = InnoDB;

Create Table Service_has_Part(
	serviceID INT NOT NULL,
	partID INT NOT NULL,

	CONSTRAINT servicepart_serviceID_partID_pk PRIMARY KEY (serviceID, partID)
);


insert into users values ('admin','admin','admin');
