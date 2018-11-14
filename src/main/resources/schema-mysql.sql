CREATE TABLE task
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    task_name varchar(64) NOT NULL,
    task_group varchar(64) NOT NULL,
    start_time timestamp NOT NULL,
    end_time timestamp NOT NULL,
    cron_expression varchar(128),
    status int,
    `desc` varchar(128),
    creator varchar(32) NOT NULL,
    create_time datetime NOT NULL,
    modifier varchar(32),
    modified_time datetime
);
CREATE UNIQUE INDEX task_id_uindex ON task (id);
ALTER TABLE task COMMENT = '任务表';