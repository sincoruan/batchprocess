delete from users;
INSERT INTO users(username, password, enabled) VALUES ( 'user', 'user', true );
INSERT INTO users(username, password, enabled) VALUES ( 'admin', 'admin', true );

delete from authorities;
INSERT INTO authorities(username, authority) VALUES ( 'user', 'ROLE_USER' );
INSERT INTO authorities(username, authority) VALUES ( 'admin', 'ROLE_ADMIN' );


-- INSERT INTO BATCH_JOB_SEQ values(0);
-- INSERT INTO BATCH_STEP_EXECUTION_SEQ values(0);
-- INSERT INTO BATCH_JOB_EXECUTION_SEQ values(0);
