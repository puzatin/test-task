create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR,
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_capacity INT,
  seats INT
);

create table CAR_ASSESSMENT (
    car_id BIGINT,
    value DEC(20),
    assess_date DATE,
    FOREIGN KEY (car_id) REFERENCES CAR (Id) ON DELETE CASCADE
);

create table AIRPLANE_ASSESSMENT (
    airplane_id BIGINT,
    value DEC(20),
    assess_date DATE,
    FOREIGN KEY (airplane_id) REFERENCES AIRPLANE (Id) ON DELETE CASCADE
);
