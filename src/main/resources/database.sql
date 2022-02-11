create table users (
id  BIGINT PRIMARY KEY NOT NULL,
first_name VARCHAR(50),
last_name VARCHAR(50),
username VARCHAR(50),
password VARCHAR(100)
);



create table accounts(
id  BIGINT PRIMARY KEY NOT NULL,
account_type VARCHAR(15),
balance FLOAT,
last_operation_date TIMESTAMP WITH TIME ZONE,
currency VARCHAR(10),
user_id BIGINT,
CONSTRAINT `acc_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);


create table operations(
id  BIGINT PRIMARY KEY NOT NULL,
type VARCHAR(15),
date TIMESTAMP WITH TIME ZONE,
amount FLOAT,
account_id BIGINT,
CONSTRAINT `op_fk` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
);
