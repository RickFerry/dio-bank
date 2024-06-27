CREATE TABLE tb_news
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    icon        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_tb_news PRIMARY KEY (id)
);