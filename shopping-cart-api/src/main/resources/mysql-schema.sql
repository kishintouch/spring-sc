

INSERT ignore INTO  user_login
(id,created_at, created_by, updated_at, updated_by, password, username)
VALUES(1,null, 0, null, 0, 'test', 'admin@gmail.com');


INSERT ignore INTO scapp.user_details
(id,created_at, created_by, updated_at, updated_by, age, billing_address, delivery_address, email_address, gender, name, user_login_id)
VALUES(1,null, 0, null, 0, 0, '', '', 'admin@gmail.com', 'M', 'test', 1);

INSERT ignore INTO scapp.products
(id,created_at, created_by, updated_at, updated_by, product_catageory, product_description, product_model, product_name, product_price, product_id)
VALUES(1,null, 0, null, 0, 'Mobile', 'Nokia Mobile', 'N395', 'Noika',375, null);

INSERT ignore INTO scapp.products
(id,created_at, created_by, updated_at, updated_by, product_catageory, product_description, product_model, product_name, product_price, product_id)
VALUES(2,null, 0, null, 0, 'Mobile', 'Sony Mobile', 'S395', 'Sony',1200, null);
