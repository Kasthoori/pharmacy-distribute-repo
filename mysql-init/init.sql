-- create all 4 databases (schemas)
CREATE DATABASE IF NOT EXISTS pharmacy_auth;
CREATE DATABASE IF NOT EXISTS pharmacy_drug;
CREATE DATABASE IF NOT EXISTS pharmacy_order;
CREATE DATABASE IF NOT EXISTS pharmacy_inventory;

-- Create applicaiton user (if not already created)
CREATE USER IF NOT EXISTS 'pharmacy'@'%' IDENTIFIED BY 'pharmacy123';

-- Grant privileges on each database to the user

GRANT ALL PRIVILEGES ON pharmacy_auth.* TO 'pharmacy'@'%';
GRANT ALL PRIVILEGES ON pharmacy_drug.* TO 'pharmacy'@'%';
GRANT ALL PRIVILEGES ON pharmacy_order.* TO 'pharmacy'@'%';
GRANT ALL PRIVILEGES ON pharmacy_inventory.* TO 'pharmacy'@'%';

FLUSH PRIVILEGES;
