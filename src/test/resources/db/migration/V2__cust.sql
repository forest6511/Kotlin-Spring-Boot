-- 下記のCRATE TABLE URLを参照
-- http://www.ac.cyberhome.ne.jp/~coloration-style/Db2/CreateTable.html
-- テーブル
CREATE TABLE MST_CUSTOMER
(
    CUST_NO         INT           NOT NULL,  -- 顧客番号
    CUST_NAME       VARCHAR(30)   NOT NULL,  -- 氏名
    CUST_ADDR       VARCHAR(100)  NOT NULL,  -- 住所
    CUST_TEL        VARCHAR(20),             -- 電話番号
    JOIN_DATE       DATE                     -- 入会日時
)
;

-- プライマリーキー
ALTER TABLE MST_CUSTOMER
    ADD CONSTRAINT PK_MST_CUSTOMER PRIMARY KEY (CUST_NO)
;

-- コメント
COMMENT ON TABLE MST_CUSTOMER IS '顧客テーブル';
COMMENT ON COLUMN MST_CUSTOMER.CUST_NO   IS '顧客番号';
COMMENT ON COLUMN MST_CUSTOMER.CUST_NAME IS '氏名';
COMMENT ON COLUMN MST_CUSTOMER.CUST_ADDR IS '住所';
COMMENT ON COLUMN MST_CUSTOMER.CUST_TEL  IS '電話番号';
COMMENT ON COLUMN MST_CUSTOMER.JOIN_DATE IS '入会日時';
