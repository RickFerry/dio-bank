CREATE TABLE tb_client
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255),
    account_id BIGINT,
    card_id    BIGINT,
    CONSTRAINT pk_tb_client PRIMARY KEY (id)
);

CREATE TABLE tb_client_features
(
    features_id  BIGINT NOT NULL,
    tb_client_id BIGINT NOT NULL,
    CONSTRAINT pk_tb_client_features PRIMARY KEY (features_id, tb_client_id)
);

CREATE TABLE tb_client_news
(
    news_id      BIGINT NOT NULL,
    tb_client_id BIGINT NOT NULL,
    CONSTRAINT pk_tb_client_news PRIMARY KEY (news_id, tb_client_id)
);

ALTER TABLE tb_client_features
    ADD CONSTRAINT uc_tb_client_features_features UNIQUE (features_id);

ALTER TABLE tb_client_news
    ADD CONSTRAINT uc_tb_client_news_news UNIQUE (news_id);

ALTER TABLE tb_client
    ADD CONSTRAINT FK_TB_CLIENT_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES tb_account (id);

ALTER TABLE tb_client
    ADD CONSTRAINT FK_TB_CLIENT_ON_CARD FOREIGN KEY (card_id) REFERENCES tb_card (id);

ALTER TABLE tb_client_features
    ADD CONSTRAINT fk_tbclifea_on_client FOREIGN KEY (tb_client_id) REFERENCES tb_client (id);

ALTER TABLE tb_client_features
    ADD CONSTRAINT fk_tbclifea_on_feature FOREIGN KEY (features_id) REFERENCES tb_features (id);

ALTER TABLE tb_client_news
    ADD CONSTRAINT fk_tbclinew_on_client FOREIGN KEY (tb_client_id) REFERENCES tb_client (id);

ALTER TABLE tb_client_news
    ADD CONSTRAINT fk_tbclinew_on_news FOREIGN KEY (news_id) REFERENCES tb_news (id);