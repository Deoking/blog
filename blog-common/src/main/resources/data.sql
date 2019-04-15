INSERT INTO permission (id, created, name, permission) VALUES
(nextval('hibernate_sequence'), current_timestamp, 'POST_WRITE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'POST_UPDATE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'POST_DELETE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'USER_WRITE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'USER_UPDATE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'USER_DELETE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'CATEGORY_WRITE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'CATEGORY_UPDATE', 1),
(nextval('hibernate_sequence'), current_timestamp, 'CATEGORY_DELETE', 1);